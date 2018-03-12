package pentago.edu.wat.pl;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MyPannel extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame okno;
    private JButton Obrotl1, Obrotp1, Obrotl2, Obrotp2, Obrotl3, Obrotp3, Obrotl4, Obrotp4;
    public int x, y;
    public boolean gracz=false;
    public Point Plansza1[][] = new Point[3][3];
    public boolean BPlansza1[][] = new boolean[3][3];
    public Color KPlansza1[][] = new Color[3][3];
    public Point Plansza2[][] = new Point[3][3];
    public boolean BPlansza2[][] = new boolean[3][3];
    public Color KPlansza2[][] = new Color[3][3];
    public Point Plansza3[][] = new Point[3][3];
    public boolean BPlansza3[][] = new boolean[3][3];
    public Color KPlansza3[][] = new Color[3][3];
    public Point Plansza4[][] = new Point[3][3];
    public boolean BPlansza4[][] = new boolean[3][3];
    public Color KPlansza4[][] = new Color[3][3];

	public MyPannel(JFrame fr) 
	{
		SpringLayout layout = new SpringLayout();
		this.okno=fr;
		setLayout(layout);
		addMouseListener(this);
	    addMouseMotionListener(this);
	    wypelnijPlansze();
		
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
		if(source == Obrotl1)
		{
			BPlansza1 = obrot(BPlansza1);
			KPlansza1 = obrot1(KPlansza1);
			repaint();
		}
		if(source == Obrotl2)
		{
			BPlansza2 = obrot(BPlansza2);
			KPlansza2 = obrot1(KPlansza2);
			repaint();
		}
		if(source == Obrotl3)
		{
			BPlansza3 = obrot(BPlansza3);
			KPlansza3 = obrot1(KPlansza3);
			repaint();
		}
		if(source == Obrotl4)
		{
			BPlansza4 = obrot(BPlansza4);
			KPlansza4 = obrot1(KPlansza4);
			repaint();
		}
		if(source == Obrotp1)
		{
			BPlansza1 = obrot(BPlansza1);
			BPlansza1 = obrot(BPlansza1);
			BPlansza1 = obrot(BPlansza1);
			KPlansza1 = obrot1(KPlansza1);
			KPlansza1 = obrot1(KPlansza1);
			KPlansza1 = obrot1(KPlansza1);
			repaint();
		}
		if(source == Obrotp2)
		{
			BPlansza2 = obrot(BPlansza2);
			BPlansza2 = obrot(BPlansza2);
			BPlansza2 = obrot(BPlansza2);
			KPlansza2 = obrot1(KPlansza2);
			KPlansza2 = obrot1(KPlansza2);
			KPlansza2 = obrot1(KPlansza2);
			repaint();
		}
		if(source == Obrotp3)
		{
			BPlansza3 = obrot(BPlansza3);
			BPlansza3 = obrot(BPlansza3);
			BPlansza3 = obrot(BPlansza3);
			KPlansza3 = obrot1(KPlansza3);
			KPlansza3 = obrot1(KPlansza3);
			KPlansza3 = obrot1(KPlansza3);
			repaint();
		}
		if(source == Obrotp4)
		{
			BPlansza4 = obrot(BPlansza4);
			BPlansza4 = obrot(BPlansza4);
			BPlansza4 = obrot(BPlansza4);
			KPlansza4 = obrot1(KPlansza4);
			KPlansza4 = obrot1(KPlansza4);
			KPlansza4 = obrot1(KPlansza4);
			repaint();
		}
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
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(BPlansza1[i][j]==true)
				{
					g.setColor(KPlansza1[i][j]);
					g.fillOval((int) (Plansza1[i][j].getX()+13), (int) (Plansza1[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (Plansza1[i][j].getX()+13), (int) (Plansza1[i][j].getY()+13), 50, 50);
				}
				if(BPlansza2[i][j]==true)
				{
					g.setColor(KPlansza2[i][j]);
					g.fillOval((int) (Plansza2[i][j].getX()+13), (int) (Plansza2[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (Plansza2[i][j].getX()+13), (int) (Plansza2[i][j].getY()+13), 50, 50);
				}
				if(BPlansza3[i][j]==true)
				{
					g.setColor(KPlansza3[i][j]);
					g.fillOval((int) (Plansza3[i][j].getX()+13), (int) (Plansza3[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (Plansza3[i][j].getX()+13), (int) (Plansza3[i][j].getY()+13), 50, 50);
				}
				if(BPlansza4[i][j]==true)
				{
					g.setColor(KPlansza4[i][j]);
					g.fillOval((int) (Plansza4[i][j].getX()+13), (int) (Plansza4[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (Plansza4[i][j].getX()+13), (int) (Plansza4[i][j].getY()+13), 50, 50);
				}
			}
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
		x = e.getX();
		y = e.getY();
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(x>=Plansza1[i][j].getX() && x<=(Plansza1[i][j].getX()+75) && y>=Plansza1[i][j].getY() && y<=(Plansza1[i][j].getY()+75))
				{
					BPlansza1[i][j] = true;
					if(gracz==true)
					{
						KPlansza1[i][j] = Color.RED;
						gracz = false;
					}
					else if (gracz == false)
					{
						KPlansza1[i][j] = Color.BLACK;
						gracz = true;
					}
				}
				if(x>=Plansza2[i][j].getX() && x<=(Plansza2[i][j].getX()+75) && y>=Plansza2[i][j].getY() && y<=(Plansza2[i][j].getY()+75))
				{
					BPlansza2[i][j] = true;
					if(gracz==true)
					{
						KPlansza2[i][j] = Color.RED;
						gracz = false;
					}
					else if (gracz == false)
					{
						KPlansza2[i][j] = Color.BLACK;
						gracz = true;
					}
				}
				if(x>=Plansza3[i][j].getX() && x<=(Plansza3[i][j].getX()+75) && y>=Plansza3[i][j].getY() && y<=(Plansza3[i][j].getY()+75))
				{
					BPlansza3[i][j] = true;
					if(gracz==true)
					{
						KPlansza3[i][j] = Color.RED;
						gracz = false;
					}
					else if (gracz == false)
					{
						KPlansza3[i][j] = Color.BLACK;
						gracz = true;
					}
				}
				if(x>=Plansza4[i][j].getX() && x<=(Plansza4[i][j].getX()+75) && y>=Plansza4[i][j].getY() && y<=(Plansza4[i][j].getY()+75))
				{
					BPlansza4[i][j] = true;
					if(gracz==true)
					{
						KPlansza4[i][j] = Color.RED;
						gracz = false;
					}
					else if (gracz == false)
					{
						KPlansza4[i][j] = Color.BLACK;
						gracz = true;
					}
				}
				repaint();
			}
		}
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
	
	public void wypelnijPlansze()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				Plansza1[i][j] = new Point(75*(j+1),75*(i+1));
				Plansza3[i][j] = new Point(75*(j+1),300 + 75*(i+1));
				Plansza2[i][j] = new Point(300 + 75*(j+1),75*(i+1));
				Plansza4[i][j] = new Point(300 + 75*(j+1),300 + 75*(i+1));
				BPlansza1[i][j] = false;
				BPlansza2[i][j] = false;
				BPlansza3[i][j] = false;
				BPlansza4[i][j] = false;
				KPlansza1[i][j] = Color.WHITE;
				KPlansza2[i][j] = Color.WHITE;
				KPlansza3[i][j] = Color.WHITE;
				KPlansza4[i][j] = Color.WHITE;
			}
		}
	}
	
	public boolean[][] obrot(boolean P[][])
	{
		boolean N[][] = new boolean[3][3];
		boolean K[] = new boolean[3];
		for(int j=0; j<3; j++)
		{
		 K[2] = P[j][0];
		 K[1] = P[j][1];
		 K[0] = P[j][2];
		 N[0][j] = K[0];
		 N[1][j] = K[1];
		 N[2][j] = K[2];
		}
		return N;
	}
	
	public Color[][] obrot1(Color P[][])
	{
		Color N[][] = new Color[3][3];
		Color K[] = new Color[3];
		for(int j=0; j<3; j++)
		{
		 K[2] = P[j][0];
		 K[1] = P[j][1];
		 K[0] = P[j][2];
		 N[0][j] = K[0];
		 N[1][j] = K[1];
		 N[2][j] = K[2];
		}
		return N;
	}
}
