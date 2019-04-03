package rocks.rdil.jailbreak.plugin;
import cc.hyperium.config.Settings;
import rocks.rdil.jailbreak.chat.CommonChatResponder;

public class ThankWatchdog {
    public ThankWatchdog() {
        if (Settings.THANK_WATCHDOG && !Settings.FPS) {
            CommonChatResponder c = new CommonChatResponder(
                    "removed from your game for hacking",
                    "Thanks Watchdog!",
                    true
            );
        }
    }
}
