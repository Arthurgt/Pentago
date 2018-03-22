package events;

import java.awt.EventQueue;

import frames.FrameMenu;
import properties.ZProperties;

public class zSluchaczObrotu implements InterfejsLogikiGry
{
	public void ObrocPlansze(EventObrotPlanszy event) 
	{
		EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new FrameMenu();
            }
        });
	}
}