package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import events.InterfaceSettings;
import events.IsListener;
import pentago.edu.wat.pl.CMain;
import pentago.edu.wat.pl.CSettingsChanger;

public class ActionLanguage extends AbstractAction 
{
	public String language;

	public ActionLanguage(String text)
	{
		super(text);
		this.language=text;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		CSettingsChanger change = new CSettingsChanger();
        InterfaceSettings  is   = new IsListener();
        change.addMoodListener( is );
		if(language=="Polski" || language=="Polish")
		{
			change.polish();
		}
		else if(language=="Angielski" || language=="English")
		{
			change.english();
		}
		CMain.log.info("Language changed");
	}

}
