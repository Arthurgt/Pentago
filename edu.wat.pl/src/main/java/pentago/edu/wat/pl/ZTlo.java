package pentago.edu.wat.pl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import events.EventZmianaJezyka;
import events.EventZmianaPlafa;
import events.EventZmianaTla;
import events.EventZmianaZdjecia;
import events.InterfejsUstawieniaGry;
import events.zZmianaJezyka;
import events.zZmianaPlafa;
import events.zZmianaTla;
import events.zZmianaZdjecia;

public class ZTlo 
{
    private zZmianaTla tlo = zZmianaTla.BLACK;
    private zZmianaPlafa plf = zZmianaPlafa.METAL;
    private zZmianaJezyka jez = zZmianaJezyka.POLSKI;
    private zZmianaZdjecia zdj = zZmianaZdjecia.PENTAGO;
    private List _listeners = new ArrayList();
    
    public synchronized void black() 
    {
    	tlo = zZmianaTla.BLACK ;
            _fireMoodEvent();

    }
    
    public synchronized void green() 
    {
    	tlo = zZmianaTla.GREEN ;
        _fireMoodEvent();
    }
    
    public synchronized void pink() 
    {
    	tlo = zZmianaTla.PINK ;
        _fireMoodEvent();
    }
    
    public synchronized void metal() 
    {
    	plf = zZmianaPlafa.METAL ;
            _firePlafEvent();

    }
    public synchronized void system() 
    {
    	plf = zZmianaPlafa.SYSTEM ;
        _firePlafEvent();
    }
    
    public synchronized void windows() 
    {
    	plf = zZmianaPlafa.WINDOWS ;
        _firePlafEvent();
    }
    
    public synchronized void polski() 
    {
    	jez = zZmianaJezyka.POLSKI ;
        _fireJezykEvent();
    }
    
    public synchronized void angielski() 
    {
    	jez = zZmianaJezyka.ANGIELSKi ;
        _fireJezykEvent();
    }
    
    public synchronized void pentago() 
    {
    	zdj = zZmianaZdjecia.PENTAGO ;
            _fireZdjecieEvent();

    }
    public synchronized void nature() 
    {
    	zdj = zZmianaZdjecia.NATURE ;
        _fireZdjecieEvent();
    }
    
    public synchronized void lake() 
    {
    	zdj = zZmianaZdjecia.LAKE ;
        _fireZdjecieEvent();
    }
    
    public synchronized void addMoodListener( InterfejsUstawieniaGry l ) 
    {
        _listeners.add( l );
    }
    
    public synchronized void removeMoodListener( InterfejsUstawieniaGry l )
    {
        _listeners.remove( l );
    }
     
    private synchronized void _fireMoodEvent() 
    {
        EventZmianaTla mood = new EventZmianaTla( this, tlo );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) 
        {
            ( (InterfejsUstawieniaGry) listeners.next() ).ZmienTlo( mood );
        }
    }
    
    private synchronized void _fireJezykEvent() 
    {
        EventZmianaJezyka mood = new EventZmianaJezyka( this, jez );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) 
        {
            ( (InterfejsUstawieniaGry) listeners.next() ).ZmienJezyk( mood );
        }
    }
    
    private synchronized void _firePlafEvent() 
    {
        EventZmianaPlafa mood = new EventZmianaPlafa( this, plf );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) 
        {
            ( (InterfejsUstawieniaGry) listeners.next() ).ZmienPlaf( mood );
        }
    }
    
    private synchronized void _fireZdjecieEvent() 
    {
        EventZmianaZdjecia mood = new EventZmianaZdjecia( this, zdj );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) 
        {
            ( (InterfejsUstawieniaGry) listeners.next() ).ZmienZdjecie( mood );
        }
    }
}
