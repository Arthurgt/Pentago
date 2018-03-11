package pentago.edu.wat.pl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MyPannel extends JPanel implements ActionListener 
{
    public static JFrame frame;
    private JButton Obrotl1, Obrotp1, Obrotl2, Obrotp2, Obrotl3, Obrotp3, Obrotl4, Obrotp4;

	public MyPannel(JFrame fr) 
	{
		SpringLayout layout = new SpringLayout();
		this.frame=fr;
		setLayout(layout);
		
		
		//Przyciski do obracania planszy
		Obrotl1 = new JButton("Lewo");
		Obrotl1.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotl1, 75, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotl1, 49, SpringLayout.NORTH, this);
		add(Obrotl1);
		
		Obrotp1 = new JButton("Prawo");
		Obrotp1.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotp1, 230, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotp1, 49, SpringLayout.NORTH, this);
		add(Obrotp1); 
		
		Obrotl2 = new JButton("Lewo");
		Obrotl2.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotl2, 375, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotl2, 49, SpringLayout.NORTH, this);
		add(Obrotl2);
		
		Obrotp2 = new JButton("Prawo");
		Obrotp2.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotp2, 530, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotp2, 49, SpringLayout.NORTH, this);
		add(Obrotp2); 
		
		Obrotl3 = new JButton("Lewo");
		Obrotl3.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotl3, 75, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotl3, 350, SpringLayout.NORTH, this);
		add(Obrotl3);
		
		Obrotp3 = new JButton("Prawo");
		Obrotp3.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotp3, 230, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotp3, 350, SpringLayout.NORTH, this);
		add(Obrotp3); 
		
		Obrotl4 = new JButton("Lewo");
		Obrotl4.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotl4, 375, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotl4, 350, SpringLayout.NORTH, this);
		add(Obrotl4);
		
		Obrotp4 = new JButton("Prawo");
		Obrotp4.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotp4, 530, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotp4, 350, SpringLayout.NORTH, this);
		add(Obrotp4); 
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(75, 75, 225, 225);
		g.fillRect(75, 375, 225, 225);
		g.fillRect(375, 375, 225, 225);
		g.fillRect(375, 75, 225, 225);
		for(int i=1; i<5; i++)
		{	
			g.setColor(Color.BLACK);
			g.drawLine(75, i*75, 300, i*75);
			g.drawLine(i*75, 75, i*75, 300);
			
			g.drawLine(75, 300 + i*75, 300, 300 + i*75);
			g.drawLine(i*75, 375, i*75, 600);
			
			g.drawLine(375, 300 + i*75, 600, 300 + i*75);
			g.drawLine(300 + i*75, 375, 300 + i*75, 600);
			
			g.drawLine(375, i*75, 600, i*75);
			g.drawLine(300 + i*75, 75, 300 + i*75, 300);
		}	
	}

}
