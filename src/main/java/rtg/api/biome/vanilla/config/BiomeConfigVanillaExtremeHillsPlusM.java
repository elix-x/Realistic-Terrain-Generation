package rtg.api.biome.vanilla.config;

import rtg.api.biome.BiomeConfigProperty;
import rtg.api.biome.BiomeConfigProperty.Type;


public class BiomeConfigVanillaExtremeHillsPlusM extends BiomeConfigVanillaBase
{
    public static final String surfaceMixBlockId = "surfaceMixBlock";
    public static final String surfaceMixBlockName = "RTG Surface: Mix Block";
    
    public static final String surfaceMixBlockMetaId = "surfaceMixBlockMeta";
    public static final String surfaceMixBlockMetaName = "RTG Surface: Mix Block Meta";
    
    public BiomeConfigVanillaExtremeHillsPlusM()
    {
        super("extremehillsplusm");
        
        this.addProperty(new BiomeConfigProperty(surfaceMixBlockId, Type.STRING, surfaceMixBlockName, "", ""));
        this.addProperty(new BiomeConfigProperty(surfaceMixBlockMetaId, Type.STRING, surfaceMixBlockMetaName, "", ""));
    }
}
