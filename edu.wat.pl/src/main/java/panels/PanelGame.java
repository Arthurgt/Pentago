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
import database.DataBase;
import pentago.edu.wat.pl.CGameLogic;
import pentago.edu.wat.pl.CMain;
import properties.CProperties;

public class PanelGame extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame frame;
    public JPanel panel;
    public static int language;
    private JButton rotatel1, rotatep1, rotatel2, rotatep2, rotatel3, rotatep3, rotatel4, rotatep4; // przyciski do rotateu planszy
    public Color[] skin = {Color.BLACK,Color.GREEN,Color.MAGENTA};
	public static int choiceskin;
	public DataBase connnect;
    
    private String[] pl1 = {"Gracz 1", "Player1"};
    private String[] pl2 = {"Gracz 2", "Player2"};
    private String[] r1 = {"Ruch pionka", "Pawn's move"};
    private String[] o1 = {"Obrot planszy", "Rotation of the board"};
    private String[] wn = {"Wygral player1!", "The Player 1 won!"};
    private String[] wc = {"Wygral player2!", "The Player 2 won!"};
    private String[] r = {"Remis!", "Draw!"};
    private String[] k1 = {"Lewo", "Left"};
    private String[] k2 = {"Prawo", "Right"};
    private String[] minimenu = {"Gra", "Game"};
    private String[] mmo1 = {"Jezyk", "Language"};
    private String[] spolish = {"Polski", "Polish"};
    private String[] senglish = {"Angielski", "English"};
    private String nick1;
    private String nick2;
    
    private JLabel player1 = new JLabel(pl1[language]); // Napisy do interfejsu gry
    private JLabel player2 = new JLabel(pl2[language]);
    private JLabel move1 = new JLabel(r1[language]);
    private JLabel move2 = new JLabel(r1[language]);
    private JLabel rotate1 = new JLabel(o1[language]);
    private JLabel rotate2 = new JLabel(o1[language]);
    private JLabel BlueWin = new JLabel(wn[language]);
    private JLabel RedWin = new JLabel(wc[language]);
    private JLabel draw = new JLabel(r[language]);

    
    private JMenuBar MenuBar; // menu podreczne
    private JMenu menu, submenu;
    private JMenuItem menuItem;
    private JRadioButtonMenuItem rbMenuItem;
    private JCheckBoxMenuItem cbMenuItem;
    private JMenuItem frist, second, third;
    
    public SpringLayout layout = new SpringLayout();
    public int created=0;
 
    
    public static CGameLogic game = CGameLogic.getInstance(); // pobranie instancji klasy Game(singleton)

	public PanelGame(JFrame fr, int skiin, String nick1, String nick2) 
	{
		this.frame=fr; 
		this.choiceskin=skiin;
		this.nick1=nick1;
		this.nick2=nick2;
	}


	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		game.getbuttons(rotatel1, rotatep1, rotatel2, rotatep2, rotatel3, rotatep3, rotatel4, rotatep4);
		game.buttons(source);
		repaint();	
	}
	
	public void paint (Graphics g)
	{	
		super.paint(g);
		language = CProperties.getlanguage();
		if(created==0)
		{
			
			addMouseListener(this);
		    addMouseMotionListener(this);
		    setLayout(layout);
			game.fillBoard(); // wypelnienie planszy bialymi polami
			 MenuBar = new JMenuBar();
			    menu = new JMenu(minimenu[language]);
			    MenuBar.add(menu);
			    submenu = new JMenu(mmo1[language]);
			    ActionLanguage polishh = new ActionLanguage(spolish[language]);
			    ActionLanguage englishh = new ActionLanguage(senglish[language]);
			    ActionMenu menuu = new ActionMenu("Menu", frame);
			    frist = new JMenuItem(polishh);
			    submenu.add(frist);
			    second = new JMenuItem(englishh);
			    submenu.add(second);
			    third = new JMenuItem(menuu);
			    menu.add(third);
			    menu.add(submenu);
			    frame.setJMenuBar(MenuBar);	
			
				rotatel1 = new JButton(k1[language]);
				rotatel1.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, rotatel1, 75, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, rotatel1, 49, SpringLayout.NORTH, this);
				add(rotatel1);
				
				rotatep1 = new JButton(k2[language]);
				rotatep1.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, rotatep1, 230, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, rotatep1, 49, SpringLayout.NORTH, this);
				add(rotatep1); 
				
				rotatel2 = new JButton(k1[language]);
				rotatel2.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, rotatel2, 300, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, rotatel2, 49, SpringLayout.NORTH, this);
				add(rotatel2);
				
				rotatep2 = new JButton(k2[language]);
				rotatep2.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, rotatep2, 455, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, rotatep2, 49, SpringLayout.NORTH, this);
				add(rotatep2); 
				
				rotatel3 = new JButton(k1[language]);
				rotatel3.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, rotatel3, 75, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, rotatel3, 525, SpringLayout.NORTH, this);
				add(rotatel3);
				
				rotatep3 = new JButton(k2[language]);
				rotatep3.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, rotatep3, 230, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, rotatep3, 525, SpringLayout.NORTH, this);
				add(rotatep3); 
				
				rotatel4 = new JButton(k1[language]);
				rotatel4.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, rotatel4, 300, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, rotatel4, 525, SpringLayout.NORTH, this);
				add(rotatel4);
				
				rotatep4 = new JButton(k2[language]);
				rotatep4.addActionListener(this);
				layout.putConstraint(SpringLayout.WEST, rotatep4, 455, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, rotatep4, 525, SpringLayout.NORTH, this);
				add(rotatep4); 
				
				int style = Font.BOLD | Font.ITALIC;
		        Font font = new Font ("Garamond", style , 50);
		        Font font2 = new Font ("Garamond", style, 30);
				
		        player1 = new JLabel(nick1);
		        player1.setFont(font);
		        layout.putConstraint(SpringLayout.WEST, player1, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, player1, 40, SpringLayout.NORTH, this);	
				add(player1);
				
				player2 = new JLabel(nick2);
				layout.putConstraint(SpringLayout.WEST, player2, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, player2, 330, SpringLayout.NORTH, this);	
		        player2.setFont(font);
				add(player2);
				
				move1 = new JLabel(r1[language]);
				layout.putConstraint(SpringLayout.WEST, move1, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, move1, 100, SpringLayout.NORTH, this);	
		        move1.setFont(font2);
				add(move1);
				
				rotate1 = new JLabel(o1[language]);
				layout.putConstraint(SpringLayout.WEST, rotate1, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, rotate1, 135, SpringLayout.NORTH, this);	
		        rotate1.setFont(font2);
				add(rotate1);
				
				move2= new JLabel(r1[language]);
				layout.putConstraint(SpringLayout.WEST, move2, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, move2, 390, SpringLayout.NORTH, this);	
		        move2.setFont(font2);
				add(move2);
				
				rotate2 = new JLabel(o1[language]);
				layout.putConstraint(SpringLayout.WEST, rotate2, 620, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, rotate2, 425, SpringLayout.NORTH, this);	
		        rotate2.setFont(font2);
				add(rotate2);
				
				BlueWin = new JLabel(wn[language]);
				layout.putConstraint(SpringLayout.WEST, BlueWin, 400, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, BlueWin, 600, SpringLayout.NORTH, this);	
				BlueWin.setFont(font2);
				add(BlueWin);
				
				RedWin = new JLabel(wc[language]);
				layout.putConstraint(SpringLayout.WEST, RedWin, 700, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, RedWin, 600, SpringLayout.NORTH, this);	
				RedWin.setFont(font2);
				add(RedWin);
				
				draw = new JLabel(r[language]);
				layout.putConstraint(SpringLayout.WEST, draw, 253, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, draw, 600, SpringLayout.NORTH, this);	
				draw.setFont(font2);
				add(draw);
				created=1;
		}
		rotatel1.setText(k1[language]);
		rotatel2.setText(k1[language]);
		rotatel3.setText(k1[language]);
		rotatel4.setText(k1[language]);
		rotatep1.setText(k2[language]);
		rotatep2.setText(k2[language]);
		rotatep3.setText(k2[language]);
		rotatep4.setText(k2[language]);
		move1.setText(r1[language]);
	    move2.setText(r1[language]);
	    rotate1.setText(o1[language]);
	    rotate2.setText(o1[language]);
	    BlueWin.setText(wn[language]);
	    RedWin.setText(wc[language]);
	    draw.setText(r[language]);
	    menu.setText(minimenu[language]);
	    submenu.setText(mmo1[language]);
	    frist.setText(spolish[language]);
	    second.setText(senglish[language]);
		
		g.setColor(Color.WHITE);
		g.fillRect(75, 75, 225, 225);
		g.fillRect(75, 300, 225, 225);
		g.fillRect(300, 300, 225, 225);
		g.fillRect(300, 75, 225, 225);
		for(int i=1; i<5; i++)
		{	
			g.setColor(skin[choiceskin]);
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
				if(game.BBoard1[i][j]==true)
				{
					g.setColor(game.KBoard1[i][j]);
					g.fillOval((int) (game.Board1[i][j].getX()+13), (int) (game.Board1[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (game.Board1[i][j].getX()+13), (int) (game.Board1[i][j].getY()+13), 50, 50);
				}
				if(game.BBoard2[i][j]==true)
				{
					g.setColor(game.KBoard2[i][j]);
					g.fillOval((int) (game.Board2[i][j].getX()+13), (int) (game.Board2[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (game.Board2[i][j].getX()+13), (int) (game.Board2[i][j].getY()+13), 50, 50);
				}
				if(game.BBoard3[i][j]==true)
				{
					g.setColor(game.KBoard3[i][j]);
					g.fillOval((int) (game.Board3[i][j].getX()+13), (int) (game.Board3[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (game.Board3[i][j].getX()+13), (int) (game.Board3[i][j].getY()+13), 50, 50);
				}
				if(game.BBoard4[i][j]==true)
				{
					g.setColor(game.KBoard4[i][j]);
					g.fillOval((int) (game.Board4[i][j].getX()+13), (int) (game.Board4[i][j].getY()+13), 50, 50);
				}
				else
				{
					g.setColor(Color.WHITE);
					g.fillOval((int) (game.Board4[i][j].getX()+13), (int) (game.Board4[i][j].getY()+13), 50, 50);
				}
			}
		}
		
		if(!game.player)
		{	
			if(game.state==0)
			{
				player1.setForeground(Color.BLUE);
				player2.setForeground(Color.WHITE);
				move1.setForeground(Color.BLUE);
				rotate1.setForeground(Color.WHITE);
				move2.setForeground(Color.WHITE);
				rotate2.setForeground(Color.WHITE);
			}
			else
			{
				player1.setForeground(Color.BLUE);
				player2.setForeground(Color.WHITE);
				move1.setForeground(Color.WHITE);
				rotate1.setForeground(Color.BLUE);
				move2.setForeground(Color.WHITE);
				rotate2.setForeground(Color.WHITE);
			}
		}
		else
		{
			if(game.state==0)
			{
				player1.setForeground(Color.WHITE);
				player2.setForeground(Color.RED);
				move1.setForeground(Color.WHITE);
				rotate1.setForeground(Color.WHITE);
				move2.setForeground(Color.RED);
				rotate2.setForeground(Color.WHITE);
			}
			else
			{
				player1.setForeground(Color.WHITE);
				player2.setForeground(Color.RED);
				move1.setForeground(Color.WHITE);
				rotate1.setForeground(Color.WHITE);
				move2.setForeground(Color.WHITE);
				rotate2.setForeground(Color.RED);
			}
		}
		
		if(game.win==1 && game.now==0)
		{
			BlueWin.setForeground(Color.BLUE);
			try 
			{
	        	CMain.log.info("Zanotowano win playera 1");
				connnect.updateWin(nick1);
				connnect.updateLose(nick2);
				game.now = 1;
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
		}
		else if(game.win==2 && game.now==0)
		{
			RedWin.setForeground(Color.RED);
			try 
			{
				CMain.log.info("Zanotowano win playera 2");
				connnect.updateWin(nick2);
				connnect.updateLose(nick1);
				game.now = 1;
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
		}
		else if (game.win==0 && game.now==0)
		{
			BlueWin.setForeground(skin[choiceskin]);
			RedWin.setForeground(skin[choiceskin]);	
			draw.setForeground(skin[choiceskin]);
		}
		else if(game.win==3 && game.now==0)
		{
			draw.setForeground(Color.ORANGE);
			try 
			{
				CMain.log.info("Zanotowano draw");
				connnect.updateDraw(nick1);
				connnect.updateDraw(nick2);
				game.now = 1;
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
		}
		game.reset();
		}


	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseClicked(MouseEvent e) 
	{
			game.mouse(e.getX(), e.getY());
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
