package exceptions;

public class ExceptionNotMove extends Exception 
{
	  public ExceptionNotMove() { super(); }
	  public ExceptionNotMove(String message) { super(message); }
	  public ExceptionNotMove(String message, Throwable cause) { super(message, cause); }
	  public ExceptionNotMove(Throwable cause) { super(cause); }
}
