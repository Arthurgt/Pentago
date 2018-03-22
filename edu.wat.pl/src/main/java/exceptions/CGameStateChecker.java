package exceptions;

public class CGameStateChecker 
{
	public static void ifRotate(int state, int win) throws ExceptionNotRotate
	{
		if(state == 1 && win == 0)
		{
			
		}
		else
		{
			throw new ExceptionNotRotate("It's not rotate time");
		}
	}
	public static void ifPaw(int state) throws ExceptionNotMove
	{
		if(state == 0)
		{
			
		}
		else
		{
			throw new ExceptionNotMove("It's not paw's move time");
		}
	}
}
