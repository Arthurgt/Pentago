package events;

import java.util.ArrayList;
import java.util.List;

public class zZmianaTla 
{
	   	public static final zZmianaTla BLACK   = new zZmianaTla("0");
	    public static final zZmianaTla GREEN = new zZmianaTla("1");
	    public static final zZmianaTla PINK   = new zZmianaTla("2");
	    
	    private String ktore;
	    
	    public String toString() 
	    {
	        return ktore;
	    }
	    
	    private zZmianaTla( String kt )
	    {
	        ktore = kt;
	    }
	    
}
