package net.dragonmounts.capability;

import net.dragonmounts.api.IArmorEffect;
import net.dragonmounts.api.IArmorEffectSource;
import net.dragonmounts.registry.CooldownCategory;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

import static java.lang.System.arraycopy;
import static java.util.Arrays.fill;
import static net.dragonmounts.DragonMounts.MOD_ID;
import static net.dragonmounts.network.DMPacketHandler.INIT_COOLDOWN_PACKET_ID;
import static net.dragonmounts.network.DMPacketHandler.SYNC_COOLDOWN_PACKET_ID;

public final class ArmorEffectManager implements IArmorEffectManager {
    public static final String DATA_PARAMETER_KEY = MOD_ID + ":armor_effect_manager";
    private static ArmorEffectManager LOCAL_MANAGER = null;
    public static final int INITIAL_COOLDOWN_SIZE = 8;
    public static final int INITIAL_LEVEL_SIZE = 5;

    public static void onPlayerClone(PlayerEntity player, PlayerEntity priorPlayer, boolean alive) {
        if (alive) {
            ArmorEffectManager manager = ((IArmorEffectManagerProvider) player).dragonMounts3_Fabric$getArmorEffectManager();
            ArmorEffectManager priorManager = ((IArmorEffectManagerProvider) priorPlayer).dragonMounts3_Fabric$getArmorEffectManager();
            manager.cdRef = priorManager.cdRef;
            manager.cdKey = priorManager.cdKey;
            manager.cdDat = priorManager.cdDat;
            manager.cdMask = priorManager.cdMask;
            manager.cdN = priorManager.cdN;
        }
    }

    public final PlayerEntity player;
    private int[] cdRef;
    private int[] cdKey;
    private int[] cdDat;
    private int cdMask;
    private int cdN;
    private int[] lvlRef;//active effects
    private IArmorEffect[] lvlKey;//all effects
    private int[] lvlDat;
    private int lvlSize;
    private int lvlN;
    private int activeN;

    public ArmorEffectManager(PlayerEntity player) {
        this.player = player;
        if (player.isMainPlayer()) {
            LOCAL_MANAGER = this;
        }
        this.cdMask = INITIAL_COOLDOWN_SIZE - 1;
        this.cdRef = new int[INITIAL_COOLDOWN_SIZE];
        fill(this.cdKey = new int[INITIAL_COOLDOWN_SIZE], -1);
        this.cdDat = new int[INITIAL_COOLDOWN_SIZE];
        this.lvlSize = INITIAL_LEVEL_SIZE;
        this.lvlRef = new int[INITIAL_LEVEL_SIZE];
        this.lvlKey = new IArmorEffect[INITIAL_LEVEL_SIZE];
        this.lvlDat = new int[INITIAL_LEVEL_SIZE];
    }

    public static ArmorEffectManager getLocal() {
        return LOCAL_MANAGER;
    }

    public static int getLocalCooldown(CooldownCategory category) {
        return LOCAL_MANAGER == null ? 0 : LOCAL_MANAGER.getCooldown(category);
    }

    public static void init(int[] data) {
        if (LOCAL_MANAGER == null) return;//?
        LOCAL_MANAGER.cdN = 0;
        final int length = data.length >> 1;
        if (length > LOCAL_MANAGER.cdMask) {
            int size = LOCAL_MANAGER.cdRef.length << 1;
            while (length >= size) size <<= 1;
            LOCAL_MANAGER.cdMask = size - 1;
            LOCAL_MANAGER.cdRef = new int[size];
            fill(LOCAL_MANAGER.cdKey = new int[size], -1);
            LOCAL_MANAGER.cdDat = new int[size];
        } else fill(LOCAL_MANAGER.cdKey, -1);
        for (int i = 0, j = 0, k; i < length; ++i)
            if ((k = data[i++]) >= 0)
                j = LOCAL_MANAGER.setCDImpl(k, data[i], j);
    }

    private void reassign(final int pos, final int arg) {
        for (int i = this.cdN - 1, j, k; i > arg; --i)
            if (((k = this.cdKey[j = this.cdRef[i]]) & this.cdMask) == pos) {
                this.cdRef[i] = pos;
                this.cdKey[pos] = k;
                this.cdDat[pos] = this.cdDat[j];
                this.reassign(j, i);
                return;
            }
        this.cdKey[pos] = -1;//it is unnecessary to reset `this.cdDat[pos]`
    }

    private int setCDImpl(final int category, final int cooldown, int cursor) {
        int pos = category & this.cdMask;
        do {
            int key = this.cdKey[pos];
            if (key == -1) {
                if (cooldown > 0) {
                    this.cdRef[this.cdN++] = pos;
                    this.cdKey[pos] = category;
                    this.cdDat[pos] = cooldown;
                }
                return cursor == pos ? pos + 1 : cursor;
            } else if (key == category) {
                if (cooldown > 0) {
                    this.cdDat[pos] = cooldown;
                } else {
                    for (int i = 0; i < this.cdN; ++i) {
                        if (this.cdRef[i] == pos) {
                            arraycopy(this.cdRef, i + 1, this.cdRef, i, --this.cdN - i);
                            this.reassign(pos, i - 1);
                            return cursor == pos ? pos + 1 : cursor;
                        }
                    }
                }
                return cursor == pos ? pos + 1 : cursor;
            }
        } while ((pos = cursor++) <= this.cdMask);
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void setCooldown(final CooldownCategory category, final int cooldown) {
        final int id = category.id;
        if (id < 0) return;
        if (this.cdN == this.cdRef.length) {
            final int[] ref = this.cdRef, key = this.cdKey, dat = this.cdDat;
            final int n = this.cdN;
            int temp = n << 1;//temp: new array size
            this.cdMask = temp - 1;
            this.cdN = 0;
            this.cdRef = new int[temp];
            fill(this.cdKey = new int[temp], -1);
            this.cdDat = new int[temp];
            for (int i = temp = 0, j; i < n; ++i)//temp: cursor
                temp = this.setCDImpl(key[j = ref[i]], dat[j], temp);
            this.setCDImpl(id, cooldown, temp);
        } else this.setCDImpl(id, cooldown, 0);
        if (!this.player.world.isClient)
            ServerPlayNetworking.send((ServerPlayerEntity) this.player, SYNC_COOLDOWN_PACKET_ID, PacketByteBufs.create().writeVarInt(id).writeVarInt(cooldown));
    }

    @Override
    public NbtCompound saveNBT() {
        NbtCompound compound = new NbtCompound();
        for (int i = 0, j, v; i < cdN; ++i)
            if ((v = this.cdDat[j = cdRef[i]]) > 0) {
                CooldownCategory category = CooldownCategory.REGISTRY.get(this.cdKey[j]);
                if (category != null) compound.putInt(category.identifier.toString(), v);
            }
        return compound;
    }


    @Override
    public void readNBT(NbtCompound nbt) {
        for (CooldownCategory category : CooldownCategory.REGISTRY) {
            String name = category.identifier.toString();
            if (nbt.contains(name)) {
                if (this.cdN == this.cdRef.length) {
                    final int[] ref = this.cdRef, key = this.cdKey, dat = this.cdDat;
                    final int n = this.cdN;
                    int temp = n << 1;//temp: new array size
                    this.cdMask = temp - 1;
                    this.cdN = 0;
                    this.cdRef = new int[temp];
                    fill(this.cdKey = new int[temp], -1);
                    this.cdDat = new int[temp];
                    for (int i = temp = 0, j; i < n; ++i)//temp: cursor
                        temp = this.setCDImpl(key[j = ref[i]], dat[j], temp);
                    this.setCDImpl(category.id, nbt.getInt(name), temp);
                } else this.setCDImpl(category.id, nbt.getInt(name), 0);
            }
        }
    }

    @Override
    public void sendInitPacket() {
        if (this.cdN == 0) return;
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeVarInt(this.cdN << 1);
        for (int i = 0, j, k; i < this.cdN; ++i)
            if ((k = this.cdKey[j = this.cdRef[i]]) != -1)
                buffer.writeVarInt(k).writeVarInt(this.cdDat[j]);
        ServerPlayNetworking.send((ServerPlayerEntity) this.player, INIT_COOLDOWN_PACKET_ID, buffer);
    }

    @Override
    public int getCooldown(final CooldownCategory category) {
        final int id = category.id;
        if (id < 0) return 0;
        int pos = id & this.cdMask;
        int key = this.cdKey[pos];
        if (key == -1) return 0;
        if (key == id) return this.cdDat[pos];
        for (int i = 0; i < this.cdN; ++i) {
            if (this.cdRef[i] == pos) {
                while (++i < this.cdN)
                    if (this.cdKey[pos = this.cdRef[i]] == id) return this.cdDat[pos];
                return 0;
            }
        }
        return 0;
    }

    private void validateLvlSize() {
        if (this.lvlN == this.lvlSize) {
            this.lvlSize += 4;
            final IArmorEffect[] key = new IArmorEffect[this.lvlSize];
            final int[] dat = new int[this.lvlSize];
            arraycopy(this.lvlKey, 0, key, 0, this.lvlN);
            arraycopy(this.lvlDat, 0, dat, 0, this.lvlN);
            this.lvlKey = key;
            this.lvlDat = dat;
        }
    }

    @Override
    public int setLevel(final IArmorEffect effect, final int level) {
        for (int i = 0; i < this.lvlN; ++i)
            if (this.lvlKey[i] == effect) return this.lvlDat[i] = level;
        this.validateLvlSize();
        this.lvlKey[this.lvlN] = effect;
        return this.lvlDat[this.lvlN++] = level;
    }

    @Override
    public int stackLevel(final IArmorEffect effect) {
        for (int i = 0; i < this.lvlN; ++i)
            if (this.lvlKey[i] == effect) return ++this.lvlDat[i];
        this.validateLvlSize();
        this.lvlKey[this.lvlN] = effect;
        return this.lvlDat[this.lvlN++] = 1;
    }

    @Override
    public boolean isActive(final IArmorEffect effect) {
        for (int i = 0; i < this.activeN; ++i)
            if (this.lvlKey[this.lvlRef[i]] == effect) return true;
        return false;
    }


    @Override
    public int getLevel(final IArmorEffect effect, final boolean filtered) {
        if (filtered) {
            for (int i = 0, j; i < this.activeN; ++i)
                if (this.lvlKey[j = this.lvlRef[i]] == effect) return this.lvlDat[j];
        } else {
            for (int i = 0; i < this.lvlN; ++i)
                if (this.lvlKey[i] == effect) return this.lvlDat[i];
        }
        return 0;
    }

    private void checkSlot(final EquipmentSlot slot) {
        final ItemStack stack = this.player.getEquippedStack(slot);
        final Item item = stack.getItem();
        if (item instanceof IArmorEffectSource)
            ((IArmorEffectSource) item).affect(this, this.player, stack);
    }

    @Override
    public void tick() {
        for (int i = 0, j; i < this.cdN; ++i) {
            if (--this.cdDat[j = this.cdRef[i]] < 1) {
                arraycopy(this.cdRef, i + 1, this.cdRef, i, --this.cdN - i);
                this.reassign(j, --i);
            }
        }
        this.activeN = this.lvlN = 0;
        this.checkSlot(EquipmentSlot.HEAD);
        this.checkSlot(EquipmentSlot.CHEST);
        this.checkSlot(EquipmentSlot.LEGS);
        this.checkSlot(EquipmentSlot.FEET);
        for (int i = 0; i < this.lvlN; ++i) {
            final IArmorEffect effect = this.lvlKey[i];
            if (effect.activate(this, this.player, this.lvlDat[i])) {
                if (this.activeN == this.lvlRef.length) {
                    final int[] array = new int[this.activeN + 4];
                    arraycopy(this.lvlRef, 0, array, 0, this.activeN);
                    this.lvlRef = array;
                }
                this.lvlRef[this.activeN++] = i;
            }
        }
    }

    /*public static class Storage implements Capability.IStorage<IArmorEffectManager> {
        @Nullable
        @Override
        public CompoundNBT writeNBT(Capability<IArmorEffectManager> capability, IArmorEffectManager instance, Direction side) {
            return instance.saveNBT();
        }

        @Override
        public void readNBT(Capability<IArmorEffectManager> capability, IArmorEffectManager instance, Direction side, INBT nbt) {
            instance.readNBT((CompoundNBT) nbt);
        }
    }

    public static class Provider implements ICapabilitySerializable<CompoundNBT> {
        private final IArmorEffectManager manager;

        public Provider(PlayerEntity player) {
            this.manager = ARMOR_EFFECT_MANAGER.getDefaultInstance();
            if (this.manager != null) {
                this.manager.bind(player);
            }
        }

        @Override
        public CompoundNBT serializeNBT() {
            return (CompoundNBT) ARMOR_EFFECT_MANAGER.getStorage().writeNBT(ARMOR_EFFECT_MANAGER, manager, null);
        }

        @Override
        public void deserializeNBT(CompoundNBT nbt) {
            ARMOR_EFFECT_MANAGER.getStorage().readNBT(ARMOR_EFFECT_MANAGER, this.manager, null, nbt);
        }

        @Nonnull
        @Override
        public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
            return ARMOR_EFFECT_MANAGER.orEmpty(capability, LazyOptional.of(() -> this.manager));
        }
    }*/
}
