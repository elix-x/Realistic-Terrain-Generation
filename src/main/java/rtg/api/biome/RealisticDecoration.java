package rtg.api.biome;

import java.util.Random;

import rtg.api.lib.CellNoise;
import rtg.api.lib.OpenSimplexNoise;

import net.minecraft.world.World;


public abstract class RealisticDecoration {
    
    public abstract void rDecorate(World world, Random rand, int chunkX, int chunkY, OpenSimplexNoise simplex, CellNoise cell, float strength, float river);
}
