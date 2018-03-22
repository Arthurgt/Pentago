package events;

public interface InterfejsUstawieniaGry 
{
	public void ZmienTlo(EventZmianaTla event);
	public void ZmienJezyk(EventZmianaJezyka event);
	public void ZmienPlaf(EventZmianaPlafa event);
	public void ZmienZdjecie(EventZmianaZdjecia event);
}
