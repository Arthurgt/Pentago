package events;

public class zZmianaZdjecia
{
	public static final zZmianaZdjecia PENTAGO   = new zZmianaZdjecia("0");
    public static final zZmianaZdjecia NATURE = new zZmianaZdjecia("1");
    public static final zZmianaZdjecia LAKE   = new zZmianaZdjecia("2");
    
    private String ktore;
    
    public String toString() 
    {
        return ktore;
    }
    
    private zZmianaZdjecia( String kt )
    {
        ktore = kt;
    }
}
