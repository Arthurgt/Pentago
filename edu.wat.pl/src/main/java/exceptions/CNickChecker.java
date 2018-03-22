package exceptions;

import java.awt.Color;
import java.sql.SQLException;

import pentago.edu.wat.pl.CMain;

public class CNickChecker 
{
	public static int good=0;
	
	public static int check(String nick1, String nick2) throws ExceptionEmptyNick, ExceptionTooLongNick, ExceptionSpaceInNick
	{
		if(nick1.equals("")  || nick2.equals(""))
		{
			good=0;
			CMain.log.info("Empty nick");
			throw new ExceptionEmptyNick("Empty nick");
		}
		if(nick1.length()>15 || nick2.length()>15)
		{
			good=0;
			CMain.log.info("Too long nick");
			throw new ExceptionTooLongNick("Too long nick");
		}
		if(nick1.contains(" ") || nick2.contains(" "))
		{
			good=0;
			CMain.log.info("Spaces in nick");
			throw new ExceptionSpaceInNick("Spaces in nick");
		}
		else
		{
			good = 1;
		}
		return good;
	}
}
