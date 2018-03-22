package events;

public class zZmianaJezyka 
{
	public static final zZmianaJezyka POLSKI   = new zZmianaJezyka("0");
    public static final zZmianaJezyka ANGIELSKi = new zZmianaJezyka("1");
    
    private String ktore;
    
    public String toString() 
    {
        return ktore;
    }
    
    private zZmianaJezyka( String kt )
    {
        ktore = kt;
    }
}
