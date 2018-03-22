package events;

import java.util.EventObject;

public class EventZmianaJezyka extends EventObject
{
    private zZmianaJezyka tlo;
    
    public EventZmianaJezyka( Object source, zZmianaJezyka tl ) 
    {
        super( source );
        tlo = tl;
    }
    public zZmianaJezyka mood() 
    {
        return tlo;
    }
}
