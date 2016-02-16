package rtg.world.gen.surface.highlands;

import java.util.Random;

import rtg.api.biome.BiomeConfig;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.surface.SurfaceBase;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class SurfaceHLRedwoodForest extends SurfaceBase
{
	private boolean beach;
	private Block beachBlock;
	private float min;
	
	private float sCliff = 1.5f;
	private float sHeight = 60f;
	private float sStrength = 65f;
	private float cCliff = 1.5f;
	
	public SurfaceHLRedwoodForest(BiomeConfig config, Block top, Block fill, boolean genBeach, Block genBeachBlock, float minCliff) 
	{
	    super(config, top, (byte)0, fill, (byte)0);
		beach = genBeach;
		beachBlock = genBeachBlock;
		min = minCliff;
	}
	
	public SurfaceHLRedwoodForest(BiomeConfig config, Block top, Block fill, boolean genBeach, Block genBeachBlock, float minCliff, float stoneCliff, float stoneHeight, float stoneStrength, float clayCliff)
	{
		this(config, top, fill, genBeach, genBeachBlock, minCliff);
		
		sCliff = stoneCliff;
		sHeight = stoneHeight;
		sStrength = stoneStrength;
		cCliff = clayCliff;
	}
	
	@Override
	public void paintTerrain(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world, Random rand, OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		float c = CliffCalculator.calc(x, y, noise);
		int cliff = 0;
		boolean gravel = false;
		
    	Block b;
		for(int k = 255; k > -1; k--)
		{
			b = blocks[(y * 16 + x) * 256 + k];
            if(b == Blocks.air)
            {
            	depth = -1;
            }
            else if(b == Blocks.stone)
            {
            	depth++;
            	
            	if(depth == 0)
            	{
            		if(k < 63)
            		{
            			if(beach)
            			{
            				gravel = true;
            			}
            		}

					float p = simplex.noise3(i / 8f, j / 8f, k / 8f) * 0.5f;
        			if(c > min && c > sCliff - ((k - sHeight) / sStrength) + p)
        			{
        				cliff = 1;
        			}
            		if(c > cCliff)
        			{
        				cliff = 2;
        			}
            		
            		if(cliff == 1)
            		{
                        if (rand.nextInt(3) == 0) {
                            
                            blocks[(y * 16 + x) * 256 + k] = hcCobble(world, i, j, x, y, k);
                            metadata[(y * 16 + x) * 256 + k] = hcCobbleMeta(world, i, j, x, y, k);
                        }
                        else {
                            
                            blocks[(y * 16 + x) * 256 + k] = hcStone(world, i, j, x, y, k);
                            metadata[(y * 16 + x) * 256 + k] = hcStoneMeta(world, i, j, x, y, k);
                        }
            		}
            		else if(cliff == 2)
            		{
        				blocks[(y * 16 + x) * 256 + k] = getShadowStoneBlock(world, i, j, x, y, k); 
        				metadata[(y * 16 + x) * 256 + k] = getShadowStoneMeta(world, i, j, x, y, k);
            		}
            		else if(k < 63)
            		{
            			if(beach)
            			{
	            			blocks[(y * 16 + x) * 256 + k] = beachBlock;
	            			gravel = true;
            			}
            			else if(k < 62)
            			{
                			blocks[(y * 16 + x) * 256 + k] = fillerBlock;
            			    metadata[(y * 16 + x) * 256 + k] = fillerBlockMeta;
            			}
            			else
            			{
                			blocks[(y * 16 + x) * 256 + k] = topBlock;
                			metadata[(y * 16 + x) * 256 + k] = topBlockMeta;
            			}
            		}
            		else
            		{
            			blocks[(y * 16 + x) * 256 + k] = topBlock;
            			metadata[(y * 16 + x) * 256 + k] = topBlockMeta;
            		}
            	}
            	else if(depth < 6)
        		{
            		if(cliff == 1)
            		{
                        blocks[(y * 16 + x) * 256 + k] = hcStone(world, i, j, x, y, k);
                        metadata[(y * 16 + x) * 256 + k] = hcStoneMeta(world, i, j, x, y, k);
            		}
            		else if(cliff == 2)
            		{
        				blocks[(y * 16 + x) * 256 + k] = getShadowStoneBlock(world, i, j, x, y, k); 
        				metadata[(y * 16 + x) * 256 + k] = getShadowStoneMeta(world, i, j, x, y, k);
            		}
            		else if(gravel)
            		{
            			blocks[(y * 16 + x) * 256 + k] = beachBlock;
            		}
            		else
            		{
            			blocks[(y * 16 + x) * 256 + k] = fillerBlock;
            		    metadata[(y * 16 + x) * 256 + k] = fillerBlockMeta;
            		}
        		}
            }
		}
	}
}
