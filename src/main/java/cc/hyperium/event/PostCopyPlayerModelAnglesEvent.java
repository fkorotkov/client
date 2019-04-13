package cc.hyperium.event;

import cc.hyperium.mixinsimp.renderer.model.IMixinModelBiped;
import net.minecraft.client.entity.AbstractClientPlayer;
import org.jetbrains.annotations.NotNull;

public final class PostCopyPlayerModelAnglesEvent extends CopyPlayerModelAnglesEvent {
    public PostCopyPlayerModelAnglesEvent(@NotNull AbstractClientPlayer entity, @NotNull IMixinModelBiped model) {
        super(entity, model);
    }
}
