package events;

import java.util.EventObject;

public class EventChangeBackground extends EventObject 
{
    private CChangeBackground background;
    
    public EventChangeBackground( Object source, CChangeBackground bg ) 
    {
        super( source );
        background = bg;
    }
    public CChangeBackground mood() 
    {
        return background;
    }
    
}
