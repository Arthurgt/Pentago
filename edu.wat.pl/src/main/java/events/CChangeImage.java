package events;

public class CChangeImage
{
	public static final CChangeImage PENTAGO   = new CChangeImage("0");
    public static final CChangeImage NATURE = new CChangeImage("1");
    public static final CChangeImage LAKE   = new CChangeImage("2");
    
    private String which;
    
    public String toString() 
    {
        return which;
    }
    
    private CChangeImage( String kt )
    {
    	which = kt;
    }
}
