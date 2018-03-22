package events;

public class CCreateMenu 
{
	public static final CCreateMenu MENU   = new CCreateMenu("0");

    
    private String which;
    
    public String toString() 
    {
        return which;
    }
    
    private CCreateMenu( String kt )
    {
    	which = kt;
    }
}
