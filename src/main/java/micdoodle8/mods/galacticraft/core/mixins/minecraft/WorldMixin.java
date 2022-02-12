package micdoodle8.mods.galacticraft.core.mixins.minecraft;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(World.class)
public abstract class WorldMixin {

    public float getRainStrength(float partialTicks) {
        return WorldUtil.getRainStrength((World) (Object) this, partialTicks);
    }
}
