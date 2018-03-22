package frames;

import java.awt.Color;

import javax.swing.JFrame;

import panels.PannelHelp;
import pentago.edu.wat.pl.ZMain;
import properties.ZProperties;

public class FrameHelp extends JFrame 
{
	public Color[] skin = {Color.BLACK,Color.GREEN,Color.MAGENTA};
	public static int wskin;
	
    public FrameHelp() 
    {
    	wskin=ZProperties.getwskin();
    	JFrame frame = new JFrame("Pentago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ZMain.log.info("Uruchomiono help");
        PannelHelp newContentPane = new PannelHelp(frame);
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 700);
        frame.setLocation(200,10);
        frame.setResizable(false);
        frame.getContentPane().setBackground(skin[wskin]);
    }
}
