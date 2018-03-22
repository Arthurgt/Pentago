package events;

public class CChangePlaf 
{
	public static final CChangePlaf METAL   = new CChangePlaf("0");
    public static final CChangePlaf SYSTEM = new CChangePlaf("1");
    public static final CChangePlaf WINDOWS   = new CChangePlaf("2");
    
    private String which;
    
    public String toString() 
    {
        return which;
    }
    
    private CChangePlaf( String kt )
    {
    	which = kt;
    }
}
