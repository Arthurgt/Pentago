package events;

import java.util.EventObject;

public class EventZmianaZdjecia extends EventObject 
{
    private zZmianaZdjecia zdjecie;
    
    public EventZmianaZdjecia( Object source, zZmianaZdjecia tl ) 
    {
        super( source );
        zdjecie = tl;
    }
    public zZmianaZdjecia mood() 
    {
        return zdjecie;
    }
    
}
