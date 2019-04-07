package rocks.rdil.jailbreak.chat;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.ChatEvent;
public class CommonChatCanceller {
    public String whatToListenFor = "";
    public CommonChatResponder(String whatToListenFor) {
        this.whatToListenFor = whatToListenFor;
    }
    @InvokeEvent
    public void onChat(ChatEvent event) {
        if(event.getUnformattedText.contains(this.whatToListenFor)) {
            event.setCancelled(true);
        }
    }
}
