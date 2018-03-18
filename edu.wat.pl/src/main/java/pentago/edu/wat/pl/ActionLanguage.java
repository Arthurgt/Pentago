package pentago.edu.wat.pl;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
		if(jezyk=="Polski" || jezyk=="Polish")
		{
			ZProperties.saveProperties("jezyk","0");
		}
		else if(jezyk=="Angielski" || jezyk=="English")
		{
			ZProperties.saveProperties("jezyk","1");
		}
	}

}
