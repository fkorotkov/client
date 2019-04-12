package cc.hyperium.mixins.utils;

import net.minecraft.util.ClassInheritanceMultiMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import java.util.List;
import java.util.Map;

@Mixin(ClassInheritanceMultiMap.class)
public abstract class MixinMultiMap<T> {
    @Shadow
    @Final
    private List<T> field_181745_e;

    @Shadow
    @Final
    private Map<Class<?>, List<T>> map;

    @Shadow
    protected abstract Class<?> func_181157_b(Class<?> p_181157_1_);
}
