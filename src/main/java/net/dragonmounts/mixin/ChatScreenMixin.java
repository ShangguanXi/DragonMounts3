package net.dragonmounts.mixin;

import net.dragonmounts.client.gui.DMConfigScreen;
import net.dragonmounts.command.ConfigCommand;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatScreen.class)
public abstract class ChatScreenMixin extends Screen {
    @Shadow
    protected TextFieldWidget chatField;

    private ChatScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = true)
    public void handleClientCommand(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> info) {
        if (keyCode == 257 || keyCode == 335) {
            String message = this.chatField.getText().trim();
            if (message.equals(ConfigCommand.OPEN_CONFIG_SCREEN)) {
                //noinspection DataFlowIssue
                this.client.inGameHud.getChatHud().addToMessageHistory(message);
                this.client.openScreen(new DMConfigScreen(this.client, this.client.currentScreen));
                info.setReturnValue(true);
            }
        }
    }
}
