package cc.hyperium.event;

public class RenderHUDEvent extends Event {
    private final float partialTicks;
    public RenderHUDEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }
    public float getPartialTicks() {
        return this.partialTicks;
    }
}
