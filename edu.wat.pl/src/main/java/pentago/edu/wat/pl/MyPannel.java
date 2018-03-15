package pentago.edu.wat.pl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MyPannel extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame okno;
    private JButton Obrotl1, Obrotp1, Obrotl2, Obrotp2, Obrotl3, Obrotp3, Obrotl4, Obrotp4; // przyciski do obrotu planszy
    
    private JLabel gracz1 = new JLabel("Gracz 1"); // Napisy do interfejsu gry
    private JLabel gracz2 = new JLabel("Gracz 2");
    private JLabel ruch1 = new JLabel("Ruch pionka");
    private JLabel ruch2 = new JLabel("Ruch pionka");
    private JLabel obrot1 = new JLabel("Obrot planszy");
    private JLabel obrot2 = new JLabel("Obrot planszy");
    private JLabel wygralgN = new JLabel("Wygral gracz pierwszy!");
    private JLabel wygralgC = new JLabel("Wygral gracz drugi!");
    private JLabel remis = new JLabel("Remis!");
    
    Game gra = Game.getInstance(); // pobranie instancji klasy Game(singleton)

	public MyPannel(JFrame fr) 
	{
		SpringLayout layout = new SpringLayout();
		this.okno=fr;
		setLayout(layout);
		addMouseListener(this);
	    addMouseMotionListener(this);
	    gra.wypelnijPlansze(); // wypelnienie planszy bialymi polami
		
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
		layout.putConstraint(SpringLayout.WEST, Obrotl2, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotl2, 49, SpringLayout.NORTH, this);
		add(Obrotl2);
		
		Obrotp2 = new JButton("Prawo");
		Obrotp2.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotp2, 455, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotp2, 49, SpringLayout.NORTH, this);
		add(Obrotp2); 
		
		Obrotl3 = new JButton("Lewo");
		Obrotl3.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotl3, 75, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotl3, 525, SpringLayout.NORTH, this);
		add(Obrotl3);
		
		Obrotp3 = new JButton("Prawo");
		Obrotp3.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotp3, 230, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotp3, 525, SpringLayout.NORTH, this);
		add(Obrotp3); 
		
		Obrotl4 = new JButton("Lewo");
		Obrotl4.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotl4, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotl4, 525, SpringLayout.NORTH, this);
		add(Obrotl4);
		
		Obrotp4 = new JButton("Prawo");
		Obrotp4.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Obrotp4, 455, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Obrotp4, 525, SpringLayout.NORTH, this);
		add(Obrotp4); 
		
		//font do interfejsu gry
		int style = Font.BOLD | Font.ITALIC;
        Font font = new Font ("Garamond", style , 50);
        Font font2 = new Font ("Garamond", style, 30);
		
        //ustawienie interfejsu gry
		layout.putConstraint(SpringLayout.WEST, gracz1, 620, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, gracz1, 40, SpringLayout.NORTH, this);	
        gracz1.setFont(font);
		add(gracz1);
		
		layout.putConstraint(SpringLayout.WEST, gracz2, 620, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, gracz2, 330, SpringLayout.NORTH, this);	
        gracz2.setFont(font);
		add(gracz2);
		
		layout.putConstraint(SpringLayout.WEST, ruch1, 620, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ruch1, 100, SpringLayout.NORTH, this);	
        ruch1.setFont(font2);
		add(ruch1);
		
		layout.putConstraint(SpringLayout.WEST, obrot1, 620, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, obrot1, 135, SpringLayout.NORTH, this);	
        obrot1.setFont(font2);
		add(obrot1);
		
		layout.putConstraint(SpringLayout.WEST, ruch2, 620, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ruch2, 390, SpringLayout.NORTH, this);	
        ruch2.setFont(font2);
		add(ruch2);
		
		layout.putConstraint(SpringLayout.WEST, obrot2, 620, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, obrot2, 425, SpringLayout.NORTH, this);	
        obrot2.setFont(font2);
		add(obrot2);
		
		layout.putConstraint(SpringLayout.WEST, wygralgN, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, wygralgN, 600, SpringLayout.NORTH, this);	
		wygralgN.setFont(font2);
		add(wygralgN);
		
		layout.putConstraint(SpringLayout.WEST, wygralgC, 700, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, wygralgC, 600, SpringLayout.NORTH, this);	
		wygralgC.setFont(font2);
		add(wygralgC);
		
		layout.putConstraint(SpringLayout.WEST, remis, 253, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, remis, 600, SpringLayout.NORTH, this);	
		remis.setFont(font2);
		add(remis);
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		gra.przyjmij(Obrotl1, Obrotp1, Obrotl2, Obrotp2, Obrotl3, Obrotp3, Obrotl4, Obrotp4);
		gra.przyciski(source);
		repaint();
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(75, 75, 225, 225);
		g.fillRect(75, 300, 225, 225);
		g.fillRect(300, 300, 225, 225);
		g.fillRect(300, 75, 225, 225);
		for(int i=1; i<5; i++)
		{	
			g.setColor(Color.BLACK);
			g.drawLine(75, i*75, 300, i*75);
			g.drawLine(i*75, 75, i*75, 300);
			
			g.drawLine(75, 300 + i*75, 300, 300 + i*75);
			g.drawLine(i*75, 300, i*75, 600);
			
			g.drawLine(300, 300 + i*75, 600, 300 + i*75);
			g.drawLine(300 + i*75, 300, 300 + i*75, 600);
			
			g.drawLine(300, i*75, 600, i*75);
			g.drawLine(300 + i*75, 75, 300 + i*75, 300);
		}	
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(gra.BPlansza1[i][j]==true)
				{
					g.setColor(gra.KPlansza1[i][j]);
					g.fillOval((int) (gra.Plansza1[i][j].getX()+13), (int) (gra.Plansza1[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (gra.Plansza1[i][j].getX()+13), (int) (gra.Plansza1[i][j].getY()+13), 50, 50);
				}
				if(gra.BPlansza2[i][j]==true)
				{
					g.setColor(gra.KPlansza2[i][j]);
					g.fillOval((int) (gra.Plansza2[i][j].getX()+13), (int) (gra.Plansza2[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (gra.Plansza2[i][j].getX()+13), (int) (gra.Plansza2[i][j].getY()+13), 50, 50);
				}
				if(gra.BPlansza3[i][j]==true)
				{
					g.setColor(gra.KPlansza3[i][j]);
					g.fillOval((int) (gra.Plansza3[i][j].getX()+13), (int) (gra.Plansza3[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (gra.Plansza3[i][j].getX()+13), (int) (gra.Plansza3[i][j].getY()+13), 50, 50);
				}
				if(gra.BPlansza4[i][j]==true)
				{
					g.setColor(gra.KPlansza4[i][j]);
					g.fillOval((int) (gra.Plansza4[i][j].getX()+13), (int) (gra.Plansza4[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (gra.Plansza4[i][j].getX()+13), (int) (gra.Plansza4[i][j].getY()+13), 50, 50);
				}
			}
		}
		
		if(!gra.gracz)
		{	
			if(gra.faza==0)
			{
				gracz1.setForeground(Color.BLUE);
				gracz2.setForeground(Color.WHITE);
				ruch1.setForeground(Color.BLUE);
				obrot1.setForeground(Color.WHITE);
				ruch2.setForeground(Color.WHITE);
				obrot2.setForeground(Color.WHITE);
			}
			else
			{
				gracz1.setForeground(Color.BLUE);
				gracz2.setForeground(Color.WHITE);
				ruch1.setForeground(Color.WHITE);
				obrot1.setForeground(Color.BLUE);
				ruch2.setForeground(Color.WHITE);
				obrot2.setForeground(Color.WHITE);
			}
		}
		else
		{
			if(gra.faza==0)
			{
				gracz1.setForeground(Color.WHITE);
				gracz2.setForeground(Color.RED);
				ruch1.setForeground(Color.WHITE);
				obrot1.setForeground(Color.WHITE);
				ruch2.setForeground(Color.RED);
				obrot2.setForeground(Color.WHITE);
			}
			else
			{
				gracz1.setForeground(Color.WHITE);
				gracz2.setForeground(Color.RED);
				ruch1.setForeground(Color.WHITE);
				obrot1.setForeground(Color.WHITE);
				ruch2.setForeground(Color.WHITE);
				obrot2.setForeground(Color.RED);
			}
		}
		
		if(gra.wygrana==1)
		{
			wygralgN.setForeground(Color.BLUE);
		}
		else if(gra.wygrana==2)
		{
			wygralgC.setForeground(Color.RED);
		}
		else if (gra.wygrana==0)
		{
			wygralgN.setForeground(Color.BLACK);
			wygralgC.setForeground(Color.BLACK);	
			remis.setForeground(Color.BLACK);
		}
		else if(gra.wygrana==3)
		{
			remis.setForeground(Color.GREEN);
		}
	}


	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseClicked(MouseEvent e) 
	{
		gra.myszka(e.getX(), e.getY());
		repaint();
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
