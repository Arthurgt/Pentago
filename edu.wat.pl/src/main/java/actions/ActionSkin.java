package actions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import events.InterfejsUstawieniaGry;
import events.zWyborTla;
import frames.FrameMenu;
import pentago.edu.wat.pl.ZMain;
import pentago.edu.wat.pl.ZTlo;
import properties.ZProperties;

public class ActionSkin extends AbstractAction 
{
	public static int i=0;
	
	public ActionSkin()
	{
		i = ZProperties.geti();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		ZTlo happy = new ZTlo();
        InterfejsUstawieniaGry  sky   = new zWyborTla();
        happy.addMoodListener( sky );
		ZMain.log.info("Zmieniono skina");
		if(i==2)
		{
			happy.black();
			happy.metal();
			happy.pentago();
			ZProperties.saveProperties("i","0");
		}
		else if(i==0)
		{
			happy.green();
			happy.system();
			happy.nature();
			ZProperties.saveProperties("i","1");
		}
		else if(i==1)
		{
			happy.pink();
			happy.windows();
			happy.lake();
			ZProperties.saveProperties("i","2");
		}
	}
}
