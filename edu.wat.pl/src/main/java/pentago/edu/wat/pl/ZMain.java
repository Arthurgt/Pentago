package pentago.edu.wat.pl;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ZMain 
{
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new FrameMenu();
            }
        });
    }
}
