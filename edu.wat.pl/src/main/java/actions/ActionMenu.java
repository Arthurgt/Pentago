package actions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import events.InterfejsLogikiGry;
import events.InterfejsUstawieniaGry;
import events.zSluchaczObrotu;
import events.zWyborTla;
import frames.FrameMenu;
import panels.PannelGame;
import pentago.edu.wat.pl.ZMenuLanucher;
import pentago.edu.wat.pl.ZTlo;

public class ActionMenu extends AbstractAction 
{
	public String jezyk;
	public JFrame frame;

	public ActionMenu(String text, JFrame frame)
	{
		super(text);
		this.jezyk=text;
		this.frame=frame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		ZMenuLanucher happy = new ZMenuLanucher();
        InterfejsLogikiGry  sky   = new zSluchaczObrotu();
        happy.addMoodListener( sky );
		happy.obrot();
		PannelGame.gra.reset=1;
		PannelGame.okno.dispose();	
	}

}
