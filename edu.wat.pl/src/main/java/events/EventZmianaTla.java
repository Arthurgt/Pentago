package events;

import java.util.EventObject;

public class EventZmianaTla extends EventObject 
{
    private zZmianaTla tlo;
    
    public EventZmianaTla( Object source, zZmianaTla tl ) 
    {
        super( source );
        tlo = tl;
    }
    public zZmianaTla mood() 
    {
        return tlo;
    }
    
}
