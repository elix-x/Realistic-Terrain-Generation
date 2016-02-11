package rtg.api.event;

import cpw.mods.fml.common.eventhandler.Event;

public class RealisticBiomeAddEvent extends Event
{

	public RealisticBiomeAddEvent()
	{
		super();
	}

    public static class Pre extends RealisticBiomeAddEvent
    {
        public Pre()
        {
            super();
        }
    }
    
    public static class Post extends RealisticBiomeAddEvent
    {
        public Post()
        {
            super();
        }
    }
}