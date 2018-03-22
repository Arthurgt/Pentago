package pentago.edu.wat.pl;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import frames.FrameMenu;
import log.CLog;
import xml.XmlParser;

public class CMain 
{
	public static Logger log;
	
    public static void main(String[] args) 
    {
    	XmlParser.Parse();
    	log = CLog.setLog();
    	log.info("Program start");
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new FrameMenu();
            }
        });
    }
}
