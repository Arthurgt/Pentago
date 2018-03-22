package events;

public class CChangeLanguage 
{
	public static final CChangeLanguage POLISH   = new CChangeLanguage("0");
    public static final CChangeLanguage ENGLISH = new CChangeLanguage("1");
    
    private String which;
    
    public String toString() 
    {
        return which;
    }
    
    private CChangeLanguage( String kt )
    {
    	which = kt;
    }
}
