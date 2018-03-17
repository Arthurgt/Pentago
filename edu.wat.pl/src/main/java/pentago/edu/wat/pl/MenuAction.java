package pentago.edu.wat.pl;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class MenuAction extends AbstractAction 
{
	public String jezyk;
	public JFrame frame;

	public MenuAction(String text, JFrame frame)
	{
		super(text);
		this.jezyk=text;
		this.frame=frame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new MyMenu();
            }
        });
		MyPannel.gra.reset=1;
		MyPannel.okno.dispose();	
	}

}
