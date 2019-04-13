package cc.hyperium.event;

import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;

public class PacketReceivedEvent extends Event {
    private final Packet<INetHandler> packet;
    public PacketReceivedEvent(Packet<INetHandler> packet) {
        this.packet = packet;
    }
    public Packet<INetHandler> getPacket() {
        return this.packet;
    }
}
