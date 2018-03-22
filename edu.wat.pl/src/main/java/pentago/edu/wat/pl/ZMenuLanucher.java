package pentago.edu.wat.pl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import events.EventObrotPlanszy;
import events.EventZmianaJezyka;
import events.EventZmianaPlafa;
import events.EventZmianaTla;
import events.EventZmianaZdjecia;
import events.InterfejsLogikiGry;
import events.InterfejsUstawieniaGry;
import events.ZObrotPlanszy;
import events.zZmianaJezyka;
import events.zZmianaPlafa;
import events.zZmianaTla;
import events.zZmianaZdjecia;

public class ZMenuLanucher 
{
    private ZObrotPlanszy tlo = ZObrotPlanszy.OBROT;
    private List _listeners = new ArrayList();
    
    public synchronized void obrot() 
    {
    	tlo = ZObrotPlanszy.OBROT ;
            _fireMoodEvent();

    }
    
    public synchronized void addMoodListener( InterfejsLogikiGry sky ) 
    {
        _listeners.add( sky );
    }
    
    public synchronized void removeMoodListener( InterfejsLogikiGry l )
    {
        _listeners.remove( l );
    }
     
    private synchronized void _fireMoodEvent() 
    {
    	EventObrotPlanszy mood = new EventObrotPlanszy( this, tlo );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) 
        {
            ( (InterfejsLogikiGry) listeners.next() ).ObrocPlansze( mood );
        }
    }
}
