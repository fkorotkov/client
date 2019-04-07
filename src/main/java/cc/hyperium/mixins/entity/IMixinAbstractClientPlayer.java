package cc.hyperium.mixins.entity;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(AbstractClientPlayer.class)
public interface IMixinAbstractClientPlayer {
    @Invoker
    NetworkPlayerInfo callGetPlayerInfo();
}
