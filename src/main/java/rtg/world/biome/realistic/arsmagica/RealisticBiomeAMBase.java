package rtg.world.biome.realistic.arsmagica;

import rtg.api.biome.BiomeConfig;
import rtg.api.biome.arsmagica.config.BiomeConfigAM;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.SurfaceBase;
import rtg.world.gen.terrain.TerrainBase;
import cpw.mods.fml.common.Loader;

import net.minecraft.world.biome.BiomeGenBase;

public class RealisticBiomeAMBase extends RealisticBiomeBase
{
    public static RealisticBiomeBase amWitchwoodForest;
    
    public RealisticBiomeAMBase(BiomeConfig config, BiomeGenBase b, BiomeGenBase riverbiome, TerrainBase t, SurfaceBase s)
    {
    
        super(config, b, riverbiome, t, s);
        
        this.waterSurfaceLakeChance = 0;
        this.lavaSurfaceLakeChance = 0;
    }
    
    public static void addBiomes()
    {
    
        if (Loader.isModLoaded("arsmagica2"))
        {
            BiomeGenBase[] b = BiomeGenBase.getBiomeGenArray();
            
            for (int i = 0; i < 256; i++)
            {
                if (b[i] != null)
                {
                    BiomeGenBase amBiome = b[i];
                    String biomeName = b[i].biomeName;
                    String biomeClass = b[i].getBiomeClass().getName();
                    
                    if (biomeName == "WitchwoodForest" && biomeClass == "am2.worldgen.BiomeWitchwoodForest")
                    {
                        amWitchwoodForest = new RealisticBiomeAMWitchwoodForest(amBiome, BiomeConfigAM.biomeConfigAMWitchwoodForest);
                    }
                }
            }
        }
    }
}
