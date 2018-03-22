package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import properties.CProperties;

public class MyJlabel2 extends JLabel
{
	public MyJlabel2(String label) 
    {
        BufferedImage myImage = null;
		try 
		{
			myImage = ImageIO.read(new File(label));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
        super.setIcon(new ImageIcon(myImage));
        Dimension size = new Dimension(CProperties.getbuttwidth(),CProperties.getbuttheight());
        setPreferredSize(size);
    }
}
