package events;

import java.util.EventObject;

public class EventCreateMenu extends EventObject
{
    private CCreateMenu menu;
    
    public EventCreateMenu( Object source, CCreateMenu mn ) 
    {
        super( source );
        menu = mn;
    }
    public CCreateMenu mood() 
    {
        return menu;
    }
}
