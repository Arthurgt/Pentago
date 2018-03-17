package pentago.edu.wat.pl;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class LanguageAction extends AbstractAction 
{
	public String jezyk;

	public LanguageAction(String text)
	{
		super(text);
		this.jezyk=text;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(jezyk=="Polski" || jezyk=="Polish")
		{
			MyPannel.jezyk=0;
			MenuPannel.jezyk=0;
		}
		else if(jezyk=="Angielski" || jezyk=="English")
		{
			MyPannel.jezyk=1;
			MenuPannel.jezyk=1;
		}
	}

}
