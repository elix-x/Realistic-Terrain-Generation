package rtg.api.biome;

import rtg.api.lib.CellNoise;
import rtg.api.lib.OpenSimplexNoise;


public abstract class RealisticTerrain {
    
    public abstract float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river);
}
