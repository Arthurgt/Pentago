package actions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import events.InterfaceSettings;
import events.IsListener;
import frames.FrameMenu;
import pentago.edu.wat.pl.CMain;
import pentago.edu.wat.pl.CSettingsChanger;
import properties.CProperties;

public class ActionSkin extends AbstractAction 
{
	public static int i=0;
	
	public ActionSkin()
	{
		i = CProperties.geti();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		CSettingsChanger sc = new CSettingsChanger();
        InterfaceSettings  is   = new IsListener();
        sc.addMoodListener( is );
		CMain.log.info("Skin Changed");
		if(i==2)
		{
			sc.black();
			sc.metal();
			sc.pentago();
			CProperties.saveproperties("i","0");
		}
		else if(i==0)
		{
			sc.green();
			sc.system();
			sc.nature();
			CProperties.saveproperties("i","1");
		}
		else if(i==1)
		{
			sc.pink();
			sc.windows();
			sc.lake();
			CProperties.saveproperties("i","2");
		}
	}
}
