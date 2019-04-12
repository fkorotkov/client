package cc.hyperium.event;

public class ServerJoinEvent extends Event {
    private final String server;
    private final int port;

    public ServerJoinEvent(String server, int port) {
        this.server = server;
        this.port = port;
    }

    public String getServer() {
        return this.server;
    }

    public int getPort() {
        return this.port;
    }
}
