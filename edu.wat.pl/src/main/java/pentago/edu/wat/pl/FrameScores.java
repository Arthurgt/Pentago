package pentago.edu.wat.pl;

import java.awt.Color;

import javax.swing.JFrame;

public class FrameScores extends JFrame 
{
	public Color[] skin = {Color.BLACK,Color.GREEN,Color.MAGENTA};
	public static int wskin;
	
    public FrameScores() 
    {
    	wskin=ZProperties.getwskin();
    	JFrame frame = new JFrame("Pentago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PannelScores newContentPane = new PannelScores(frame);
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