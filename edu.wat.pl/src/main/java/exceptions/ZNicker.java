package exceptions;

import java.awt.Color;
import java.sql.SQLException;

public class ZNicker 
{
	public static int dobrze=0;
	
	public static int sprawdz(String nick1, String nick2) throws ExceptionEmptyNick, ExceptionTooLongNick, ExceptionSCiNick
	{
		if(nick1.equals("")  || nick2.equals(""))
		{
			dobrze=0;
			throw new ExceptionEmptyNick("Pusty nick");
		}
		if(nick1.length()>15 || nick2.length()>15)
		{
			dobrze=0;
			throw new ExceptionTooLongNick("Za dlugi nick");
		}
		if(nick1.contains(" ") || nick2.contains(" "))
		{
			dobrze=0;
			throw new ExceptionSCiNick("Spacje w nicku");
		}
		else
		{
			dobrze = 1;
		}
		return dobrze;
	}
}
