package exceptions;

public class ExceptionSpaceInNick extends Exception 
{
	public ExceptionSpaceInNick() { super(); }
	  public ExceptionSpaceInNick(String message) { super(message); }
	  public ExceptionSpaceInNick(String message, Throwable cause) { super(message, cause); }
	  public ExceptionSpaceInNick(Throwable cause) { super(cause); }
}
