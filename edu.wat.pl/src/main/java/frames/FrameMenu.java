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

import events.InterfaceSettings;
import events.IsListener;
import panels.PanelMenu;
import pentago.edu.wat.pl.CMain;
import pentago.edu.wat.pl.CSettingsChanger;
import properties.CProperties;

public class FrameMenu extends JFrame 
{
	public String[] skin = {"1.png","2.png","3.png"};
	public static int choiceskin;
	public static int img;
	
    public FrameMenu() 
    {
    	choiceskin=CProperties.getskin();
    	img=CProperties.getimage();
    	BufferedImage myImage = null;
		try 
		{
			myImage = ImageIO.read(new File(skin[img]));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
    	JFrame frame = new JFrame("Pentago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CMain.log.info("Entered menu");
        PanelMenu newContentPane = new PanelMenu(frame, myImage);
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(CProperties.framewidth(), CProperties.frameheight());
        frame.setLocation(CProperties.getbuttxlocation(),CProperties.getbuttylocation());
        frame.setResizable(false);
    }
}
