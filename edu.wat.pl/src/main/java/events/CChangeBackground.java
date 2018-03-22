package events;

import java.util.ArrayList;
import java.util.List;

public class CChangeBackground 
{
	   	public static final CChangeBackground BLACK   = new CChangeBackground("0");
	    public static final CChangeBackground GREEN = new CChangeBackground("1");
	    public static final CChangeBackground PINK   = new CChangeBackground("2");
	    
	    private String which;
	    
	    public String toString() 
	    {
	        return which;
	    }
	    
	    private CChangeBackground( String kt )
	    {
	    	which = kt;
	    }
	    
}
