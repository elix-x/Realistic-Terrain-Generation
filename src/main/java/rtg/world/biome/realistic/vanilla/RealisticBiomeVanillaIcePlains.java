package rtg.world.biome.realistic.vanilla;

import java.util.Random;

import rtg.api.biome.BiomeConfig;
import rtg.api.biome.vanilla.config.BiomeConfigVanillaIcePlains;
import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.feature.WorldGenBlob;
import rtg.world.gen.feature.WorldGenLog;
import rtg.world.gen.surface.vanilla.SurfaceVanillaIcePlains;
import rtg.world.gen.terrain.vanilla.TerrainVanillaIcePlains;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class RealisticBiomeVanillaIcePlains extends RealisticBiomeVanillaBase
{	
	public static Block topBlock = BiomeGenBase.icePlains.topBlock;
	public static Block fillerBlock = BiomeGenBase.icePlains.fillerBlock;
	
	public RealisticBiomeVanillaIcePlains(BiomeConfig config)
	{
		super(config, 
			BiomeGenBase.icePlains,
			BiomeGenBase.frozenRiver,
			new TerrainVanillaIcePlains(),
			new SurfaceVanillaIcePlains(config, topBlock, fillerBlock, topBlock, topBlock)
		);
	}
	
    @Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, OpenSimplexNoise simplex, CellNoise cell, float strength, float river)
    {
        
        /**
         * Using rDecorateSeedBiome() to partially decorate the biome? If so, then comment out this method.
         */
        //rOreGenSeedBiome(world, rand, chunkX, chunkY, simplex, cell, strength, river, baseBiome);
    
        rDecorateSeedBiome(world, rand, chunkX, chunkY, simplex, cell, strength, river, baseBiome);
        
        if(river > 0.86f)
        {
            for(int j = 0; j < 5f * strength; j++)
            {
                int i1 = chunkX + rand.nextInt(16) + 8;
                int j1 = chunkY + rand.nextInt(16) + 8;
                int k1 = world.getHeightValue(i1, j1);
                
                if (k1 < 64 && rand.nextInt(16) == 0) {
                    (new WorldGenBlob(Blocks.packed_ice, 0, rand)).generate(world, rand, i1, k1, j1);
                }
            }
        }
        
        if (this.config.getPropertyById(BiomeConfigVanillaIcePlains.decorationLogsId).valueBoolean) {
        
            if(rand.nextInt((int)(24f / strength)) == 0)
            {
                int j6 = chunkX + rand.nextInt(16) + 8;
                int k10 = chunkY + rand.nextInt(16) + 8;
                int z52 = world.getHeightValue(j6, k10);
                
                WorldGenerator worldgenerator = new WorldGenLog(1, rand.nextInt(6), false);
                worldgenerator.setScale(1.0D, 1.0D, 1.0D);
                worldgenerator.generate(world, rand, j6, z52, k10);
            }
        }
    }
}
