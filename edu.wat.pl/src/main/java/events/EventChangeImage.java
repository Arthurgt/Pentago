package events;

import java.util.EventObject;

public class EventChangeImage extends EventObject 
{
    private CChangeImage image;
    
    public EventChangeImage( Object source, CChangeImage img ) 
    {
        super( source );
        image = img;
    }
    public CChangeImage mood() 
    {
        return image;
    }
    
}
