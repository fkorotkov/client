package cc.hyperium.event;

public final class RenderEntitiesEvent extends Event {
    private final float partialTicks;
    public RenderEntitiesEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }
    public final float getPartialTicks() {
        return this.partialTicks;
    }
}
