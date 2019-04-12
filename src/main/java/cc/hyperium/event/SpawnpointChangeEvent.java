package cc.hyperium.event;
import net.minecraft.util.BlockPos;

public class SpawnpointChangeEvent extends Event {
    private final BlockPos blockPos;

    public SpawnpointChangeEvent(BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    public BlockPos getBlockPos() {
        return this.blockPos;
    }
}
