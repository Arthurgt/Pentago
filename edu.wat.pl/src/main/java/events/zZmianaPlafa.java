package events;

public class zZmianaPlafa 
{
	public static final zZmianaPlafa METAL   = new zZmianaPlafa("0");
    public static final zZmianaPlafa SYSTEM = new zZmianaPlafa("1");
    public static final zZmianaPlafa WINDOWS   = new zZmianaPlafa("2");
    
    private String ktore;
    
    public String toString() 
    {
        return ktore;
    }
    
    private zZmianaPlafa( String kt )
    {
        ktore = kt;
    }
}
