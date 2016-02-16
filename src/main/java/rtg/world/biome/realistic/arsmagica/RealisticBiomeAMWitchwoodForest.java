package rtg.world.biome.realistic.arsmagica;

import rtg.api.biome.BiomeConfig;
import rtg.world.gen.surface.arsmagica.SurfaceAMWitchwoodForest;
import rtg.world.gen.terrain.arsmagica.TerrainAMWitchwoodForest;

import net.minecraft.world.biome.BiomeGenBase;

public class RealisticBiomeAMWitchwoodForest extends RealisticBiomeAMBase
{
    
    public RealisticBiomeAMWitchwoodForest(BiomeGenBase amBiome, BiomeConfig config)
    {
    
        super(config,
            amBiome, BiomeGenBase.river,
            new TerrainAMWitchwoodForest(),
            new SurfaceAMWitchwoodForest(config, amBiome.topBlock, amBiome.fillerBlock));
    }
}
