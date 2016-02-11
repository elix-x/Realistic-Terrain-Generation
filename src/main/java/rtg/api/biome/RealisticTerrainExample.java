package rtg.api.biome;

import rtg.api.lib.CellNoise;
import rtg.api.lib.OpenSimplexNoise;


public class RealisticTerrainExample extends RealisticTerrain
{
    public RealisticTerrainExample()
    {
        
    }
    
    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river)
    {
        return 70f;
    }
}
