package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ZLogger 
{
	public static final Logger log=Logger.getLogger(ZLogger.class.getName());
	
	public static Logger setLog()
	{
		try 
		{
			FileHandler fh;
			int limit = 5242880;
			fh = new FileHandler("Pentago.log", limit, 3, true);
			log.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} 
		catch (SecurityException | IOException e) 
		{
			e.printStackTrace();
		}
		return log;
	}
}
