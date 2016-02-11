package rtg.api.biome;

import net.minecraft.world.biome.BiomeGenBase;


public class RealisticBiomeExample extends RealisticBiome
{
    
    public BiomeGenBase biome;
    public BiomeGenBase river;
    public RealisticTerrain terrain;
    public RealisticSurface surface;
    public RealisticDecoration decoration;
    public BiomeConfig config;
    
    public RealisticBiomeExample(BiomeGenBase biome, BiomeGenBase river, RealisticTerrain terrain, RealisticSurface surface, RealisticDecoration decoration, BiomeConfig config)
    {
        super(
            BiomeGenBase.plains,
            BiomeGenBase.river,
            new RealisticTerrainExample(),
            new RealisticSurfaceExample(),
            new RealisticDecorationExample(),
            new BiomeConfigExample()
        );
    }
}
