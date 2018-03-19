package pentago.edu.wat.pl;

public class ExceptionTooLongNick extends Exception
{
	public ExceptionTooLongNick() { super(); }
	  public ExceptionTooLongNick(String message) { super(message); }
	  public ExceptionTooLongNick(String message, Throwable cause) { super(message, cause); }
	  public ExceptionTooLongNick(Throwable cause) { super(cause); }
}
