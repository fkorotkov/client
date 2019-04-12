package cc.hyperium.internal.addons;

public interface IAddon {
    void onLoad();

    void onClose();

    default void sendDebugInfo() {}
}
