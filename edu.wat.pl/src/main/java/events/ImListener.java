package events;

import java.awt.EventQueue;

import frames.FrameMenu;
import properties.CProperties;

public class ImListener implements InterfaceMenu
{
	public void CreateMenuu(EventCreateMenu event) 
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