package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import events.InterfejsUstawieniaGry;
import events.zWyborTla;
import pentago.edu.wat.pl.ZMain;
import pentago.edu.wat.pl.ZTlo;
import properties.ZProperties;

public class ActionLanguage extends AbstractAction 
{
	public String jezyk;

	public ActionLanguage(String text)
	{
		super(text);
		this.jezyk=text;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		ZTlo happy = new ZTlo();
        InterfejsUstawieniaGry  sky   = new zWyborTla();
        happy.addMoodListener( sky );
		if(jezyk=="Polski" || jezyk=="Polish")
		{
			happy.polski();
		}
		else if(jezyk=="Angielski" || jezyk=="English")
		{
			happy.angielski();
		}
		ZMain.log.info("Zmieniono jezyk");
	}

}
