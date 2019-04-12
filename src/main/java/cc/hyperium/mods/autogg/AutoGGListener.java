package cc.hyperium.mods.autogg;

import cc.hyperium.Hyperium;
import cc.hyperium.event.ChatEvent;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.WorldChangeEvent;
import cc.hyperium.mods.sk1ercommon.Multithreading;
import cc.hyperium.mods.victoryroyale.VictoryRoyale;
import cc.hyperium.utils.ChatColor;
import net.minecraft.client.Minecraft;

public class AutoGGListener {
    private final Minecraft mc = Minecraft.getMinecraft();
    private final AutoGG mod;
    boolean invoked = false;

    public AutoGGListener(AutoGG mod) {
        this.mod = mod;
    }

    @InvokeEvent
    public void worldSwap(WorldChangeEvent event) {
        invoked = false;
    }

    @InvokeEvent
    public void onChat(final ChatEvent e) {
        if (this.mod.getConfig().ANTI_GG && invoked && (e.getChat().getUnformattedText().toLowerCase().endsWith("gg") || e.getChat().getUnformattedText().endsWith("Good Game"))) e.setCancelled(true);
        if (!this.mod.getConfig().isToggled() || this.mod.isRunning() || this.mod.getTriggers().isEmpty()) return;

        String unformattedMessage = ChatColor.stripColor(e.getChat().getUnformattedText());

        if (this.mod.getTriggers().stream().anyMatch(unformattedMessage::contains) && unformattedMessage.startsWith(" ")) {
            this.mod.setRunning(true);
            invoked = true;
            // The GGThread in an anonymous class
            Multithreading.runAsync(() -> {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                VictoryRoyale.getInstance().gameEnded();
            });
            Multithreading.POOL.submit(() -> {
                try {
                    Thread.sleep(Hyperium.INSTANCE.getModIntegration().getAutoGG().getConfig().getDelay() * 1000);
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/achat " + (mod.getConfig().sayGoodGameInsteadOfGG ? (mod.getConfig().lowercase ? "good game" : "Good Game") : (mod.getConfig().lowercase ? "gg" : "GG")));
                    Thread.sleep(2000L);

                    // We are referring to it from a different thread, thus we need to do this
                    Hyperium.INSTANCE.getModIntegration().getAutoGG().setRunning(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        }
    }
}
