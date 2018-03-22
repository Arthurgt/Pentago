package pentago.edu.wat.pl;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import frames.FrameMenu;
import log.ZLogger;
import xml.ZxmlParser;

public class ZMain 
{
	public static Logger log;
	
    public static void main(String[] args) 
    {
    	ZxmlParser.Parse();
    	log = ZLogger.setLog();
    	log.info("Poczatek programu");
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new FrameMenu();
            }
        });
    }
}
