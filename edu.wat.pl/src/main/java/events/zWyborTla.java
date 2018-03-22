package events;

import frames.FrameMenu;
import properties.ZProperties;

public class zWyborTla implements InterfejsUstawieniaGry 
{
	public void ZmienTlo(EventZmianaTla event) 
	{
		 if( event.mood() == zZmianaTla.BLACK )
	        {
			 ZProperties.saveProperties("wskin","0");
	        }
	        else if( event.mood() == zZmianaTla.GREEN )
	        {
	        	ZProperties.saveProperties("wskin","1");
	        }
	        else if( event.mood() == zZmianaTla.PINK )
	        {
	        	ZProperties.saveProperties("wskin","2");
	        }	
	}

	public void ZmienJezyk(EventZmianaJezyka event) 
	{
		if( event.mood() == zZmianaJezyka.POLSKI )
        {
		 ZProperties.saveProperties("jezyk","0");
        }
        else if( event.mood() == zZmianaJezyka.ANGIELSKi )
        {
        	ZProperties.saveProperties("jezyk","1");
        }
	}

	public void ZmienPlaf(EventZmianaPlafa event) 
	{
		if( event.mood() == zZmianaPlafa.METAL )
        {
		 ZProperties.saveProperties("lookifeel","0");
        }
        else if( event.mood() == zZmianaPlafa.SYSTEM )
        {
        	ZProperties.saveProperties("lookifeel","1");
        }
        else if( event.mood() == zZmianaPlafa.WINDOWS )
        {
        	ZProperties.saveProperties("lookifeel","2");
        }			
	}  
	
	public void ZmienZdjecie(EventZmianaZdjecia event) 
	{
		if( event.mood() == zZmianaZdjecia.PENTAGO )
        {
		 ZProperties.saveProperties("zdjecie","0");
        }
        else if( event.mood() == zZmianaZdjecia.NATURE )
        {
        	ZProperties.saveProperties("zdjecie","1");
        }
        else if( event.mood() == zZmianaZdjecia.LAKE )
        {
        	ZProperties.saveProperties("zdjecie","2");
        }			
	}  
}
