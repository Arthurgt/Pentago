package events;

import java.util.EventObject;

public class EventZmianaPlafa extends EventObject
{
    private zZmianaPlafa tlo;
    
    public EventZmianaPlafa( Object source, zZmianaPlafa tl ) 
    {
        super( source );
        tlo = tl;
    }
    public zZmianaPlafa mood() 
    {
        return tlo;
    }
}
