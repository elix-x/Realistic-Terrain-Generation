package rtg.world.gen.terrain.enhancedbiomes;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainEBScrub extends TerrainBase
{
    
    public TerrainEBScrub()
    {
    
    }
    
    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river)
    {
    
        float h = simplex.noise2(x / 100f, y / 100f) * 7;
        h += simplex.noise2(x / 20f, y / 20f) * 2;
        
        float m = simplex.noise2(x / 180f, y / 180f) * 70f * river;
        m *= m / 70f;
        
        float sm = simplex.noise2(x / 30f, y / 30f) * 8f;
        sm *= m / 20f > 3.75f ? 3.75f : m / 20f;
        m += sm;
        
        float l = simplex.noise2(x / 260f, y / 260f) * 38f;
        l *= l / 35f;
        l = l < -8f ? -8f : l;
        
        return 68f + h + m - l;
    }
}
