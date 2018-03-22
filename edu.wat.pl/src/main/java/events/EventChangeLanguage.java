package events;

import java.util.EventObject;

public class EventChangeLanguage extends EventObject
{
    private CChangeLanguage language;
    
    public EventChangeLanguage( Object source, CChangeLanguage lg ) 
    {
        super( source );
        language = lg;
    }
    public CChangeLanguage mood() 
    {
        return language;
    }
}
