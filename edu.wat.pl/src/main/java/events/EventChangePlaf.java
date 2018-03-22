package events;

import java.util.EventObject;

public class EventChangePlaf extends EventObject
{
    private CChangePlaf plaf;
    
    public EventChangePlaf( Object source, CChangePlaf plf ) 
    {
        super( source );
        plaf = plf;
    }
    public CChangePlaf mood() 
    {
        return plaf;
    }
}
