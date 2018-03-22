package pentago.edu.wat.pl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import events.EventCreateMenu;
import events.EventChangeLanguage;
import events.EventChangePlaf;
import events.EventChangeBackground;
import events.EventChangeImage;
import events.InterfaceMenu;
import events.InterfaceSettings;
import events.CCreateMenu;
import events.CChangeLanguage;
import events.CChangePlaf;
import events.CChangeBackground;
import events.CChangeImage;

public class CMenuLanucher 
{
    private CCreateMenu men = CCreateMenu.MENU;
    private List _listeners = new ArrayList();
    
    public synchronized void obrot() 
    {
    	men = CCreateMenu.MENU ;
    	fireMenuEvent();

    }
    
    public synchronized void addMoodListener( InterfaceMenu mn ) 
    {
        _listeners.add( mn );
    }
    
    public synchronized void removeMoodListener( InterfaceMenu l )
    {
        _listeners.remove( l );
    }
     
    private synchronized void fireMenuEvent() 
    {
    	EventCreateMenu createmenu = new EventCreateMenu( this, men );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) 
        {
            ( (InterfaceMenu) listeners.next() ).CreateMenuu( createmenu );
        }
    }
}
