package pentago.edu.wat.pl;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class ActionSkin extends AbstractAction 
{
	public static int i=0;
	
	public ActionSkin()
	{
		i = ZProperties.geti();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(i==0)
		{
			ZProperties.saveProperties("wskin","0");
			ZProperties.saveProperties("lookifeel","0");
			ZProperties.saveProperties("i","1");
		}
		else if(i==1)
		{
			ZProperties.saveProperties("wskin","1");
			ZProperties.saveProperties("lookifeel","1");
			ZProperties.saveProperties("i","2");
		}
		else if(i==2)
		{
			ZProperties.saveProperties("wskin","2");
			ZProperties.saveProperties("lookifeel","2");
			ZProperties.saveProperties("i","0");
		}
	}
}
