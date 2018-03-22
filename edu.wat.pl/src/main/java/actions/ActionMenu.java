package actions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import events.InterfaceMenu;
import events.InterfaceSettings;
import events.ImListener;
import events.IsListener;
import frames.FrameMenu;
import panels.PanelGame;
import pentago.edu.wat.pl.CMenuLanucher;
import pentago.edu.wat.pl.CSettingsChanger;

public class ActionMenu extends AbstractAction 
{
	public String language;
	public JFrame frame;

	public ActionMenu(String text, JFrame frame)
	{
		super(text);
		this.language=text;
		this.frame=frame;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		CMenuLanucher ml = new CMenuLanucher();
        InterfaceMenu  gm   = new ImListener();
        ml.addMoodListener( gm );
		ml.obrot();
		PanelGame.game.reset=1;
		PanelGame.frame.dispose();	
	}

}
