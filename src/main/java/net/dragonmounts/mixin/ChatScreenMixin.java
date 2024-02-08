package net.dragonmounts.mixin;

import net.dragonmounts.client.gui.DMConfigScreen;
import net.dragonmounts.command.ConfigCommand;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ChatScreen.class)
public abstract class ChatScreenMixin extends Screen {
    private ChatScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "keyPressed", at = @At(
            value = "INVOKE",
            target = "Ljava/lang/String;isEmpty()Z"
    ), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    public void handleClientCommand(int key, int scan, int modifiers, CallbackInfoReturnable<Boolean> info, String string) {
        if (string.equals(ConfigCommand.OPEN_CONFIG_SCREEN)) {
            //noinspection DataFlowIssue
            this.client.inGameHud.getChatHud().addToMessageHistory(string);
            this.client.openScreen(new DMConfigScreen(this.client, this.client.currentScreen));
            info.setReturnValue(true);
        }
    }
}
