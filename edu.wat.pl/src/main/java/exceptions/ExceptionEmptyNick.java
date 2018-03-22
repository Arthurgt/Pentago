package exceptions;

public class ExceptionEmptyNick extends Exception 
{
	public ExceptionEmptyNick() { super(); }
	  public ExceptionEmptyNick(String message) { super(message); }
	  public ExceptionEmptyNick(String message, Throwable cause) { super(message, cause); }
	  public ExceptionEmptyNick(Throwable cause) { super(cause); }
}
