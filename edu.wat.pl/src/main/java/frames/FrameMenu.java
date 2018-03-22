package frames;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import events.InterfejsUstawieniaGry;
import events.zWyborTla;
import panels.PannelMenu;
import pentago.edu.wat.pl.ZMain;
import pentago.edu.wat.pl.ZTlo;
import properties.ZProperties;

public class FrameMenu extends JFrame 
{
	public String[] skin = {"1.png","2.png","3.png"};
	public static int wskin;
	public static int zdje;
	
    public FrameMenu() 
    {
    	wskin=ZProperties.getwskin();
    	zdje=ZProperties.getzdje();
    	BufferedImage myImage = null;
		try 
		{
			myImage = ImageIO.read(new File(skin[zdje]));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
    	JFrame frame = new JFrame("Pentago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ZMain.log.info("Uruchomiono menu");
        PannelMenu newContentPane = new PannelMenu(frame, myImage);
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 700);
        frame.setLocation(200,10);
        frame.setResizable(false);
    }
}
