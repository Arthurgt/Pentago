package frames;

import java.awt.Color;

import javax.swing.JFrame;

import panels.PanelLogin;
import pentago.edu.wat.pl.CMain;
import properties.CProperties;

public class FrameLogin extends JFrame 
{
	public Color[] skin = {Color.BLACK,Color.GREEN,Color.MAGENTA};
	public static int choiceskin;
	
    public FrameLogin() 
    {
    	choiceskin=CProperties.getskin();
    	JFrame frame = new JFrame("Pentago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CMain.log.info("Entered login pannel");
        PanelLogin newContentPane = new PanelLogin(frame);
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(CProperties.framewidth(), CProperties.frameheight());
        frame.setLocation(CProperties.getbuttxlocation(),CProperties.getbuttylocation());
        frame.setResizable(false);
        frame.getContentPane().setBackground(skin[choiceskin]);
    }
}
