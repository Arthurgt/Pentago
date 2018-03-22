package events;

import frames.FrameMenu;
import properties.CProperties;

public class IsListener implements InterfaceSettings 
{
	public void ChangeBackgroundd(EventChangeBackground event) 
	{
		 if( event.mood() == CChangeBackground.BLACK )
	        {
			 CProperties.saveproperties("skin","0");
	        }
	        else if( event.mood() == CChangeBackground.GREEN )
	        {
	        	CProperties.saveproperties("skin","1");
	        }
	        else if( event.mood() == CChangeBackground.PINK )
	        {
	        	CProperties.saveproperties("skin","2");
	        }	
	}

	public void ChangeLanguagee(EventChangeLanguage event) 
	{
		if( event.mood() == CChangeLanguage.POLISH )
        {
		 CProperties.saveproperties("language","0");
        }
        else if( event.mood() == CChangeLanguage.ENGLISH )
        {
        	CProperties.saveproperties("language","1");
        }
	}

	public void ChangePlaff(EventChangePlaf event) 
	{
		if( event.mood() == CChangePlaf.METAL )
        {
		 CProperties.saveproperties("lookandfeel","0");
        }
        else if( event.mood() == CChangePlaf.SYSTEM )
        {
        	CProperties.saveproperties("lookandfeel","1");
        }
        else if( event.mood() == CChangePlaf.WINDOWS )
        {
        	CProperties.saveproperties("lookandfeel","2");
        }			
	}  
	
	public void ChangeImagee(EventChangeImage event) 
	{
		if( event.mood() == CChangeImage.PENTAGO )
        {
		 CProperties.saveproperties("image","0");
        }
        else if( event.mood() == CChangeImage.NATURE )
        {
        	CProperties.saveproperties("image","1");
        }
        else if( event.mood() == CChangeImage.LAKE )
        {
        	CProperties.saveproperties("image","2");
        }			
	}  
}
