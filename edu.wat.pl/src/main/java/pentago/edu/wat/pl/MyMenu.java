package pentago.edu.wat.pl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class MyMenu extends JFrame 
{
	public String[] skin = {"1.png","2.png","3.png"};
	public static int wskin=0;
	
    public MyMenu() 
    {
    	BufferedImage myImage = null;
		try 
		{
			myImage = ImageIO.read(new File(skin[wskin]));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
    	JFrame frame = new JFrame("Pentago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuPannel newContentPane = new MenuPannel(frame, myImage);
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 700);
        frame.setLocation(200,10);
        frame.setResizable(false);
    }
}
