package frames;

import java.awt.Color;

import javax.swing.JFrame;

import panels.PanelGame;
import pentago.edu.wat.pl.CMain;
import properties.CProperties;

public class FrameGame extends JFrame 
{
	public Color[] skin = {Color.BLACK,Color.GREEN,Color.MAGENTA};
	public static int choiceskin;
	
    public FrameGame(String nick1, String nick2) 
    {
    	choiceskin=CProperties.getskin();
    	JFrame frame = new JFrame("Pentago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CMain.log.info("Game started");
        PanelGame newContentPane = new PanelGame(frame, choiceskin, nick1, nick2);
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
