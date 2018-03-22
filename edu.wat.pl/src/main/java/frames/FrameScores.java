package frames;

import java.awt.Color;

import javax.swing.JFrame;

import panels.PanelScores;
import pentago.edu.wat.pl.CMain;
import properties.CProperties;

public class FrameScores extends JFrame 
{
	public Color[] skin = {Color.BLACK,Color.GREEN,Color.MAGENTA};
	public static int choiceskin;
	
    public FrameScores() 
    {
    	choiceskin=CProperties.getskin();
    	JFrame frame = new JFrame("Pentago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CMain.log.info("Opened scoreboard");
        PanelScores newContentPane = new PanelScores(frame);
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
