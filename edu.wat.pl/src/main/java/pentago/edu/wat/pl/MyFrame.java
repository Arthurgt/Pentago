package pentago.edu.wat.pl;

import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame 
{
 
    public MyFrame() 
    {
    	JFrame frame = new JFrame("Pentago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPannel newContentPane = new MyPannel(frame);
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 700);
        frame.setLocation(200,10);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.BLACK);
    }
}
