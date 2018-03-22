package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SpringLayout;

import components.MyButton;
import components.MyJlabel;
import components.MyJlabel2;
import frames.FrameMenu;
import properties.ZProperties;

public class PannelHelp extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame okno;
    public MyButton Powrot;
    public MyJlabel opis;
    public MyJlabel2 jezyczek;
    public static int jezyk;
    private String[] s = {"polish.png" , "english.png"};
    private String[] p = {"<html>Celem obu graczy jest ułożenie w rzędzie <br/> "
    		+ "lub po skosie 5 kulek swojego koloru, analogicznie <br/>"
    		+ "do gry kółko i krzyżyk. Gracze po kolei <br/>"
    		+ "oddają ruch składający się z 2 elementów: <br/>"
    		+ "dołożenia nowej kulki oraz obrócenia części <br/>"
    		+ "planszy o 90 stopni w dowolnym kierunku. <br/>"
    		+ "Plansza składa się z 4 ruchomych części, <br/>"
    		+ "które można obracać. Każda część zawiera <br/>"
    		+ "9 miejsc na kulki więc cała plansza mieści <br/>"
    		+ "ich 36 (6×6).<html>"
    					 ,"<html>The game is played on a 6×6 board divided <br/> "
    	    + "into four 3×3 sub-boards (or quadrants). Taking turns<br/> "
    	    + "the two players place a marble of their color<br/> "
    	    + "(either black or white) onto an unoccupied space<br/> "
    	    + "on the board, and then rotate one of the sub-boards<br/> "
    	    + "by 90 degrees either clockwise or anti-clockwise. <br/> "
    	    + "A player wins by getting five of their marbles in <br/>"
    	    + "a vertical, horizontal or diagonal row. <br/>"
    	    + "If all 36 spaces on the board are occupied without <br/>"
    	    + "a row of five being formed then the game is a draw."};

	public PannelHelp(JFrame fr) 
	{
		jezyk = ZProperties.getjezyk();
		this.okno=fr;
		addMouseListener(this);
	    addMouseMotionListener(this);
	    SpringLayout layout = new SpringLayout();
	    setLayout(layout);
	    
	    Powrot = new MyButton("menu");
		Powrot.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Powrot, 430, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Powrot, 550, SpringLayout.NORTH, this);
		add(Powrot);
		
		opis = new MyJlabel(p[jezyk]);
		layout.putConstraint(SpringLayout.WEST, opis, 170, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, opis, 10, SpringLayout.NORTH, this);
		add(opis);
		
		jezyczek = new MyJlabel2(s[jezyk]);
		layout.putConstraint(SpringLayout.WEST, jezyczek, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, jezyczek, 10, SpringLayout.NORTH, this);
		add(jezyczek);
		
	}


	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if(source == Powrot)
		{
			EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                new FrameMenu();
	            }
	        });
			okno.dispose();
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
