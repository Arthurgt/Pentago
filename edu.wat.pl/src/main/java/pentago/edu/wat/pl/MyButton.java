package pentago.edu.wat.pl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton 
{
    public MyButton(String label) 
    {
        super(label);
        Dimension size = new Dimension(100,60);
        setPreferredSize(size);
        setContentAreaFilled(false);
    }
 
    protected void paintComponent(Graphics g) 
    {
    if (getModel().isArmed()) 
    {
            g.setColor(Color.lightGray);
    } 
    else 
    {
            g.setColor(getBackground());
    }
    g.fillOval(0, 0, getSize().width-1, getSize().height-1);
    super.paintComponent(g);
    }
 
    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width-1, getSize().height-1);
    }
}
