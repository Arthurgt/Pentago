package pentago.edu.wat.pl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import events.EventChangeLanguage;
import events.EventChangePlaf;
import events.EventChangeBackground;
import events.EventChangeImage;
import events.InterfaceSettings;
import events.CChangeLanguage;
import events.CChangePlaf;
import events.CChangeBackground;
import events.CChangeImage;

public class CSettingsChanger 
{
    private CChangeBackground backgroundd = CChangeBackground.BLACK;
    private CChangePlaf plaff = CChangePlaf.METAL;
    private CChangeLanguage languagee = CChangeLanguage.POLISH;
    private CChangeImage imagee = CChangeImage.PENTAGO;
    private List _listeners = new ArrayList();
    
    public synchronized void black() 
    {
    	backgroundd = CChangeBackground.BLACK ;
    	fireBackgroundEvent();

    }
    
    public synchronized void green() 
    {
    	backgroundd = CChangeBackground.GREEN ;
    	fireBackgroundEvent();
    }
    
    public synchronized void pink() 
    {
    	backgroundd = CChangeBackground.PINK ;
        fireBackgroundEvent();
    }
    
    public synchronized void metal() 
    {
    	plaff = CChangePlaf.METAL ;
    	firePlafEvent();

    }
    public synchronized void system() 
    {
    	plaff = CChangePlaf.SYSTEM ;
    	firePlafEvent();
    }
    
    public synchronized void windows() 
    {
    	plaff = CChangePlaf.WINDOWS ;
        firePlafEvent();
    }
    
    public synchronized void polish() 
    {
    	languagee = CChangeLanguage.POLISH ;
    	fireLanguageEvent();;
    }
    
    public synchronized void english() 
    {
    	languagee = CChangeLanguage.ENGLISH ;
        fireLanguageEvent();
    }
    
    public synchronized void pentago() 
    {
    	imagee = CChangeImage.PENTAGO ;
    	fireImageEvent();

    }
    public synchronized void nature() 
    {
    	imagee = CChangeImage.NATURE ;
    	fireImageEvent();
    }
    
    public synchronized void lake() 
    {
    	imagee = CChangeImage.LAKE ;
        fireImageEvent();
    }
    
    public synchronized void addMoodListener( InterfaceSettings l ) 
    {
        _listeners.add( l );
    }
    
    public synchronized void removeMoodListener( InterfaceSettings l )
    {
        _listeners.remove( l );
    }
     
    private synchronized void fireBackgroundEvent() 
    {
        EventChangeBackground bg = new EventChangeBackground( this, backgroundd );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) 
        {
            ( (InterfaceSettings) listeners.next() ).ChangeBackgroundd( bg );
        }
    }
    
    private synchronized void fireLanguageEvent() 
    {
        EventChangeLanguage lang = new EventChangeLanguage( this, languagee );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) 
        {
            ( (InterfaceSettings) listeners.next() ).ChangeLanguagee( lang );
        }
    }
    
    private synchronized void firePlafEvent() 
    {
        EventChangePlaf plf = new EventChangePlaf( this, plaff );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) 
        {
            ( (InterfaceSettings) listeners.next() ).ChangePlaff( plf );
        }
    }
    
    private synchronized void fireImageEvent() 
    {
        EventChangeImage img = new EventChangeImage( this, imagee );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) 
        {
            ( (InterfaceSettings) listeners.next() ).ChangeImagee( img );
        }
    }
}
