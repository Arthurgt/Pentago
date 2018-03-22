package panels;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SpringLayout;

import actions.ActionLanguage;
import actions.ActionMenu;
import database.ZDataBase;
import pentago.edu.wat.pl.ZGame;
import pentago.edu.wat.pl.ZMain;
import properties.ZProperties;

public class PannelGame extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame okno;
    public JPanel panel;
    public static int jezyk;
    private JButton Obrotl1, Obrotp1, Obrotl2, Obrotp2, Obrotl3, Obrotp3, Obrotl4, Obrotp4; // przyciski do obrotu planszy
    public Color[] skin = {Color.BLACK,Color.GREEN,Color.MAGENTA};
	public static int wskin;
	public ZDataBase lacz;
    
    private String[] gr1 = {"Gracz 1", "Player1"};
    private String[] gr2 = {"Gracz 2", "Player2"};
    private String[] r1 = {"Ruch pionka", "Pawn's move"};
    private String[] o1 = {"Obrot planszy", "Rotation of the board"};
    private String[] wn = {"Wygral gracz1", "The Player 1 won"};
    private String[] wc = {"Wygral gracz2", "The Player 2 won"};
    private String[] r = {"Remis!", "Draw!"};
    private String[] k1 = {"Lewo", "Left"};
    private String[] k2 = {"Prawo", "Right"};
    private String[] minimenu = {"Gra", "Game"};
    private String[] mmo1 = {"Jezyk", "Language"};
    private String[] spolski = {"Polski", "Polish"};
    private String[] sangielski = {"Angielski", "English"};
    private String nick1;
    private String nick2;
    
    private JLabel gracz1 = new JLabel(gr1[jezyk]); // Napisy do interfejsu gry
    private JLabel gracz2 = new JLabel(gr2[jezyk]);
    private JLabel ruch1 = new JLabel(r1[jezyk]);
    private JLabel ruch2 = new JLabel(r1[jezyk]);
    private JLabel obrot1 = new JLabel(o1[jezyk]);
    private JLabel obrot2 = new JLabel(o1[jezyk]);
    private JLabel wygralgN = new JLabel(wn[jezyk]);
    private JLabel wygralgC = new JLabel(wc[jezyk]);
    private JLabel remis = new JLabel(r[jezyk]);

    
    private JMenuBar PasekMenu; // menu podreczne
    private JMenu menu, submenu;
    private JMenuItem menuItem;
    private JRadioButtonMenuItem rbMenuItem;
    private JCheckBoxMenuItem cbMenuItem;
    private JMenuItem jeden, drugi, trzeci;
    
    public SpringLayout layout = new SpringLayout();
    public int stworzone=0;
 
    
    public static ZGame gra = ZGame.getInstance(); // pobranie instancji klasy Game(singleton)

	public PannelGame(JFrame fr, int skiin, String nick1, String nick2) 
	{
		this.okno=fr; 
		this.wskin=skiin;
		this.nick1=nick1;
		this.nick2=nick2;
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
		jezyk = ZProperties.getjezyk();
		if(stworzone==0)
		{
			
			addMouseListener(this);
		    addMouseMotionListener(this);
		    setLayout(layout);
			gra.wypelnijPlansze(); // wypelnienie planszy bialymi polami
			 PasekMenu = new JMenuBar();
			    menu = new JMenu(minimenu[jezyk]);
			    PasekMenu.add(menu);
			    submenu = new JMenu(mmo1[jezyk]);
			    ActionLanguage polski = new ActionLanguage(spolski[jezyk]);
			    ActionLanguage angielski = new ActionLanguage(sangielski[jezyk]);
			    ActionMenu menuu = new ActionMenu("Menu", okno);
			    jeden = new JMenuItem(polski);
			    submenu.add(jeden);
			    drugi = new JMenuItem(angielski);
			    submenu.add(drugi);
			    trzeci = new JMenuItem(menuu);
			    menu.add(trzeci);
			    menu.add(submenu);
			    okno.setJMenuBar(PasekMenu);	
			
				Obrotl1 = new JButton(k1[jezyk]);
				Obrotl1.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, Obrotl1, 75, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, Obrotl1, 49, SpringLayout.NORTH, this);
				add(Obrotl1);
				
				Obrotp1 = new JButton(k2[jezyk]);
				Obrotp1.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, Obrotp1, 230, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, Obrotp1, 49, SpringLayout.NORTH, this);
				add(Obrotp1); 
				
				Obrotl2 = new JButton(k1[jezyk]);
				Obrotl2.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, Obrotl2, 300, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, Obrotl2, 49, SpringLayout.NORTH, this);
				add(Obrotl2);
				
				Obrotp2 = new JButton(k2[jezyk]);
				Obrotp2.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, Obrotp2, 455, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, Obrotp2, 49, SpringLayout.NORTH, this);
				add(Obrotp2); 
				
				Obrotl3 = new JButton(k1[jezyk]);
				Obrotl3.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, Obrotl3, 75, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, Obrotl3, 525, SpringLayout.NORTH, this);
				add(Obrotl3);
				
				Obrotp3 = new JButton(k2[jezyk]);
				Obrotp3.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, Obrotp3, 230, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, Obrotp3, 525, SpringLayout.NORTH, this);
				add(Obrotp3); 
				
				Obrotl4 = new JButton(k1[jezyk]);
				Obrotl4.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, Obrotl4, 300, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, Obrotl4, 525, SpringLayout.NORTH, this);
				add(Obrotl4);
				
				Obrotp4 = new JButton(k2[jezyk]);
				Obrotp4.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, Obrotp4, 455, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, Obrotp4, 525, SpringLayout.NORTH, this);
				add(Obrotp4); 
				
				//font do interfejsu gry
				int style = Font.BOLD | Font.ITALIC;
		        Font font = new Font ("Garamond", style , 50);
		        Font font2 = new Font ("Garamond", style, 30);
				
		        //ustawienie interfejsu gry
		        gracz1 = new JLabel(nick1);
		        gracz1.setFont(font);
		        layout.putConstraint(SpringLayout.WEST, gracz1, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, gracz1, 40, SpringLayout.NORTH, this);	
				add(gracz1);
				
				gracz2 = new JLabel(nick2);
				layout.putConstraint(SpringLayout.WEST, gracz2, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, gracz2, 330, SpringLayout.NORTH, this);	
		        gracz2.setFont(font);
				add(gracz2);
				
				ruch1 = new JLabel(r1[jezyk]);
				layout.putConstraint(SpringLayout.WEST, ruch1, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, ruch1, 100, SpringLayout.NORTH, this);	
		        ruch1.setFont(font2);
				add(ruch1);
				
				obrot1 = new JLabel(o1[jezyk]);
				layout.putConstraint(SpringLayout.WEST, obrot1, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, obrot1, 135, SpringLayout.NORTH, this);	
		        obrot1.setFont(font2);
				add(obrot1);
				
				ruch2= new JLabel(r1[jezyk]);
				layout.putConstraint(SpringLayout.WEST, ruch2, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, ruch2, 390, SpringLayout.NORTH, this);	
		        ruch2.setFont(font2);
				add(ruch2);
				
				obrot2 = new JLabel(o1[jezyk]);
				layout.putConstraint(SpringLayout.WEST, obrot2, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, obrot2, 425, SpringLayout.NORTH, this);	
		        obrot2.setFont(font2);
				add(obrot2);
				
				wygralgN = new JLabel(wn[jezyk]);
				layout.putConstraint(SpringLayout.WEST, wygralgN, 400, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, wygralgN, 600, SpringLayout.NORTH, this);	
				wygralgN.setFont(font2);
				add(wygralgN);
				
				wygralgC = new JLabel(wc[jezyk]);
				layout.putConstraint(SpringLayout.WEST, wygralgC, 700, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, wygralgC, 600, SpringLayout.NORTH, this);	
				wygralgC.setFont(font2);
				add(wygralgC);
				
				remis = new JLabel(r[jezyk]);
				layout.putConstraint(SpringLayout.WEST, remis, 253, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, remis, 600, SpringLayout.NORTH, this);	
				remis.setFont(font2);
				add(remis);
				stworzone=1;
		}
		Obrotl1.setText(k1[jezyk]);
		Obrotl2.setText(k1[jezyk]);
		Obrotl3.setText(k1[jezyk]);
		Obrotl4.setText(k1[jezyk]);
		Obrotp1.setText(k2[jezyk]);
		Obrotp2.setText(k2[jezyk]);
		Obrotp3.setText(k2[jezyk]);
		Obrotp4.setText(k2[jezyk]);
		ruch1.setText(r1[jezyk]);
	    ruch2.setText(r1[jezyk]);
	    obrot1.setText(o1[jezyk]);
	    obrot2.setText(o1[jezyk]);
	    wygralgN.setText(wn[jezyk]);
	    wygralgC.setText(wc[jezyk]);
	    remis.setText(r[jezyk]);
	    menu.setText(minimenu[jezyk]);
	    submenu.setText(mmo1[jezyk]);
	    jeden.setText(spolski[jezyk]);
	    drugi.setText(sangielski[jezyk]);
		
		g.setColor(Color.WHITE);
		g.fillRect(75, 75, 225, 225);
		g.fillRect(75, 300, 225, 225);
		g.fillRect(300, 300, 225, 225);
		g.fillRect(300, 75, 225, 225);
		for(int i=1; i<5; i++)
		{	
			g.setColor(skin[wskin]);
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
		
		if(gra.wygrana==1 && gra.juz==0)
		{
			wygralgN.setForeground(Color.BLUE);
			try 
			{
	        	ZMain.log.info("Zanotowano wygrana gracza 1");
				lacz.updateWin(nick1);
				lacz.updateLose(nick2);
				gra.juz = 1;
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
		}
		else if(gra.wygrana==2 && gra.juz==0)
		{
			wygralgC.setForeground(Color.RED);
			try 
			{
				ZMain.log.info("Zanotowano wygrana gracza 2");
				lacz.updateWin(nick2);
				lacz.updateLose(nick1);
				gra.juz = 1;
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
		}
		else if (gra.wygrana==0 && gra.juz==0)
		{
			wygralgN.setForeground(skin[wskin]);
			wygralgC.setForeground(skin[wskin]);	
			remis.setForeground(skin[wskin]);
		}
		else if(gra.wygrana==3 && gra.juz==0)
		{
			remis.setForeground(Color.ORANGE);
			try 
			{
				ZMain.log.info("Zanotowano remis");
				lacz.updateDraw(nick1);
				lacz.updateDraw(nick2);
				gra.juz = 1;
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
		}
		gra.reset();
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
