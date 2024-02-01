package net.dragonmounts.block.entity;

import net.dragonmounts.block.DragonCoreBlock;
import net.dragonmounts.init.DMBlockEntities;
import net.dragonmounts.inventory.DragonCoreScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.entity.ShulkerBoxBlockEntity.AnimationStage;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShapes;

import java.util.List;

/**
 * @see net.minecraft.block.entity.ShulkerBoxBlockEntity
 */
public class DragonCoreBlockEntity extends LootableContainerBlockEntity implements Tickable, ExtendedScreenHandlerFactory {
    private static final String TRANSLATION_KEY = "container.dragonmounts.dragon_core";
    private DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private int openCount;
    private AnimationStage stage = AnimationStage.CLOSED;
    private float progress;
    private float progressOld;

    public DragonCoreBlockEntity() {
        super(DMBlockEntities.DRAGON_CORE);
    }

    @Override
    public void tick() {
        this.updateAnimation();
        if (this.stage == AnimationStage.OPENING || this.stage == AnimationStage.CLOSING) {
            this.pushEntities();
        }
    }

    protected void updateAnimation() {
        this.progressOld = this.progress;
        switch (this.stage) {
            case CLOSED:
                this.progress = 0.0F;
                break;
            case OPENING:
                this.progress += 0.1F;
                if (this.progress >= 1.0F) {
                    this.pushEntities();
                    this.stage = AnimationStage.OPENED;
                    this.progress = 1.0F;
                    this.updateNeighborStates();
                }
                break;
            case CLOSING:
                this.progress -= 0.1F;
                if (this.progress <= 0.1F) {
                    this.progress = 0.0F;
                    //noinspection DataFlowIssue
                    this.world.syncWorldEvent(2003, this.pos.up(), 0);
                    this.world.breakBlock(this.pos, true);
                    this.stage = AnimationStage.CLOSED;
                }
                break;
            case OPENED:
                this.progress = 1.0F;
        }

    }

    public AnimationStage getAnimationStage() {
        return this.stage;
    }

    public Box getBoundingBox() {
        return VoxelShapes.fullCube().getBoundingBox().stretch(0, 0.5 * this.getProgress(1.0F), 0);
    }

    private void pushEntities() {
        //noinspection DataFlowIssue
        BlockState blockstate = this.world.getBlockState(this.pos);
        if (blockstate.getBlock() instanceof DragonCoreBlock) {
            Box box = this.getBoundingBox().offset(this.pos);
            List<Entity> list = this.world.getOtherEntities(null, box);
            if (list.isEmpty()) return;
            for (Entity entity : list) {
                if (entity.getPistonBehavior() != PistonBehavior.IGNORE)
                    entity.move(MovementType.SHULKER_BOX, new Vec3d(0, box.maxY + 0.01 - entity.getBoundingBox().minY, 0));
            }
        }
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean onSyncedBlockEvent(int id, int data) {
        if (id == 1) {
            this.openCount = data;
            if (data == 0) {
                this.stage = AnimationStage.CLOSING;
                this.updateNeighborStates();
            } else if (data == 1) {
                this.stage = AnimationStage.OPENING;
                this.updateNeighborStates();
            }
            return true;
        } else return super.onSyncedBlockEvent(id, data);
    }

    private void updateNeighborStates() {
        this.getCachedState().updateNeighbors(this.world, this.pos, 3);
    }

    @Override
    public void onOpen(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.openCount < 0) this.openCount = 0;
            ++this.openCount;
            //noinspection DataFlowIssue
            this.world.addSyncedBlockEvent(this.pos, this.getCachedState().getBlock(), 1, this.openCount);
            if (this.openCount == 1) {
                this.world.playSound(null, this.pos, SoundEvents.BLOCK_ENDER_CHEST_CLOSE, SoundCategory.BLOCKS, 0.9F, this.world.random.nextFloat() * 0.1F + 0.9F);
                this.world.playSound(null, this.pos, SoundEvents.ENTITY_ENDER_DRAGON_AMBIENT, SoundCategory.BLOCKS, 0.05F, this.world.random.nextFloat() * 0.3F + 0.9F);
                this.world.playSound(null, this.pos, SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.BLOCKS, 0.08F, this.world.random.nextFloat() * 0.1F + 0.9F);
            }

        }
    }

    @Override
    public void onClose(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.openCount;
            //noinspection DataFlowIssue
            this.world.addSyncedBlockEvent(this.pos, this.getCachedState().getBlock(), 1, this.openCount);
        }
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText(TRANSLATION_KEY);
    }

    @Override
    public void fromTag(BlockState state, NbtCompound compound) {
        super.fromTag(state, compound);
        this.items = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(compound)) {
            Inventories.readNbt(compound, this.items);
        }
    }

    @Override
    public NbtCompound writeNbt(NbtCompound compound) {
        super.writeNbt(compound);
        if (!this.serializeLootTable(compound)) {
            Inventories.writeNbt(compound, this.items);
        }
        return compound;
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.items;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> items) {
        this.items = items;
    }

    public float getProgress(float partialTicks) {
        return MathHelper.lerp(partialTicks, this.progressOld, this.progress);
    }

    @Override
    protected ScreenHandler createScreenHandler(int id, PlayerInventory player) {
        return new DragonCoreScreenHandler(id, player, this);
    }

    public boolean isClosed() {
        return this.stage == AnimationStage.CLOSED;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buffer) {
        buffer.writeBlockPos(this.pos);
    }
}
