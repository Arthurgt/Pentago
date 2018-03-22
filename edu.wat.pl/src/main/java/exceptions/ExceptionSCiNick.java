package exceptions;

public class ExceptionSCiNick extends Exception 
{
	public ExceptionSCiNick() { super(); }
	  public ExceptionSCiNick(String message) { super(message); }
	  public ExceptionSCiNick(String message, Throwable cause) { super(message, cause); }
	  public ExceptionSCiNick(Throwable cause) { super(cause); }
}
