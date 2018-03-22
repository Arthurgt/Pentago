package events;

import java.util.EventObject;

public class EventObrotPlanszy extends EventObject
{
    private ZObrotPlanszy tlo;
    
    public EventObrotPlanszy( Object source, ZObrotPlanszy tl ) 
    {
        super( source );
        tlo = tl;
    }
    public ZObrotPlanszy mood() 
    {
        return tlo;
    }
}
