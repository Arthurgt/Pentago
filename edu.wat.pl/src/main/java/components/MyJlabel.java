package components;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyJlabel extends JLabel
{  
    public MyJlabel(String text) 
    {
    	int style = Font.BOLD | Font.ITALIC;
        Font font = new Font ("Garamond", style , 30);
        super.setFont(font);
        super.setText(text);
        setOpaque(false); 
    }
    protected void paintComponent(Graphics g) 
    {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) 
    {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    
    public void repaints(String text)
    {
    	super.setText(text);
    }
}
