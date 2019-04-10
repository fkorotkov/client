package rocks.rdil.jailbreak.chat;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.ChatEvent;
public class CommonChatCanceller {
    public String whatToListenFor = "";
    public CommonChatCanceller(String whatToListenFor) {
        this.whatToListenFor = whatToListenFor;
    }
    @InvokeEvent
    public void onChat(ChatEvent event) {
        if(event.getChat().getUnformattedText().contains(this.whatToListenFor)) {
            event.setCancelled(true);
        }
    }
}
