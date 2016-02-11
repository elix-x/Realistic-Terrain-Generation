package rtg.api.biome;

import net.minecraft.world.biome.BiomeGenBase;


public abstract class RealisticBiome
{
    
    protected BiomeGenBase biome;
    protected BiomeGenBase river;
    protected RealisticTerrain terrain;
    protected RealisticSurface surface;
    protected RealisticDecoration decoration;
    protected BiomeConfig config;
    
    public RealisticBiome(BiomeGenBase biome, BiomeGenBase river, RealisticTerrain terrain, RealisticSurface surface, RealisticDecoration decoration, BiomeConfig config)
    {
        this.biome = biome;
        this.river = river;
        this.terrain = terrain;
        this.surface = surface;
        this.decoration = decoration;
        this.config = config;
    }
}
