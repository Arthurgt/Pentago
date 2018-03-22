package events;

public class ZObrotPlanszy 
{
	public static final ZObrotPlanszy OBROT   = new ZObrotPlanszy("0");

    
    private String ktore;
    
    public String toString() 
    {
        return ktore;
    }
    
    private ZObrotPlanszy( String kt )
    {
        ktore = kt;
    }
}
