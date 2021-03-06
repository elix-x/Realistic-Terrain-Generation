package rtg.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeBase extends BiomeGenBase
{

	public BiomeBase(int intBiomeId) {
	    
		super(intBiomeId, false);
		
		/**
		 *  Let's make sure the biome always has a biome name, as sometimes it doesn't always get set.
		 *  This is important because some mods depend on biomeName being set.
		 *  See https://github.com/Team-RTG/Realistic-Terrain-Generation/issues/444 for an example.
		 */
		this.biomeName = getBiome(intBiomeId).biomeName;
	}
}
