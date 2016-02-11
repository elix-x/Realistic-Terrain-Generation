package rtg.api.biome;

import java.util.Random;

import rtg.api.lib.CellNoise;
import rtg.api.lib.OpenSimplexNoise;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;


public class RealisticSurfaceExample extends RealisticSurface
{
    
    public RealisticSurfaceExample()
    {
        
    }
    
    @Override
    public void paintTerrain(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world, Random rand,
        OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
        
    }
}
