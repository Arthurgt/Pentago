package pentago.edu.wat.pl;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class SkinAction extends AbstractAction 
{
	public static int i=1;
	
	public SkinAction()
	{
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(i==0)
		{
			MyFrame.wskin=0;
			MyMenu.wskin=0;
			i=1;
		}
		else if(i==1)
		{
			MyFrame.wskin=1;
			MyMenu.wskin=1;
			i=2;
		}
		else if(i==2)
		{
			MyFrame.wskin=2;
			MyMenu.wskin=2;
			i=0;
		}
	}
}
