package pentago.edu.wat.pl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PannelMenu extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame okno;
    public int stworzone=0;
    public JButton Start, Skorki, Koniec, Wyniki, Pomoc;
    public MyButton przyciskk;
    public static int jezyk;
    private String[] s = {"Graj", "Play"};
    private String[] p = {"Pomoc", "Help"};
    private String[] k = {"Wyjdz", "Exit"};
    private String[] z = {"Skorki", "Skins"};
    private String[] w = {"Wyniki", "Scores"};
    private String[] minimenu = {"Gra", "Game"};
    private String[] mmo1 = {"Jezyk", "Language"};
    private String[] spolski = {"Polski", "Polish"};
    private String[] sangielski = {"Angielski", "English"};
    
    private JMenuBar PasekMenu; // menu podreczne
    private JMenu menu, submenu;
    private JMenuItem menuItem;
    private JRadioButtonMenuItem rbMenuItem;
    private JCheckBoxMenuItem cbMenuItem;
    private JMenuItem jeden;
    private JMenuItem drugi;
    private Image image;
    public int i=0;

	public PannelMenu(JFrame fr, Image image) 
	{
		this.image = image;
		this.okno=fr;
		addMouseListener(this);
	    addMouseMotionListener(this);
	    GridBagLayout layout = new GridBagLayout();
	    setLayout(layout);
	    
	    PasekMenu = new JMenuBar();
	    menu = new JMenu(minimenu[jezyk]);
	    PasekMenu.add(menu);
	    submenu = new JMenu(mmo1[jezyk]);
	    ActionLanguage polski = new ActionLanguage(spolski[jezyk]);
	    ActionLanguage angielski = new ActionLanguage(sangielski[jezyk]);
	    jeden = new JMenuItem(polski);
	    submenu.add(jeden);
	    drugi = new JMenuItem(angielski);
	    submenu.add(drugi);
	    menu.add(submenu);
	    okno.setJMenuBar(PasekMenu);	
	    
	}


	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if(source==Koniec)
		{
			okno.dispose();
		}
		else if(source==Skorki)
		{
			ZLookAndFeel.initLookAndFeel();
			EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                new FrameMenu();
	            }
	        });
			okno.dispose();
		}
		else if(source==Start)
		{
			EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                new FrameGame();
	            }
	        });
			okno.dispose();
		}
		else if(source==Pomoc)
		{
			EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                new FrameHelp();
	            }
	        });
			okno.dispose();
		}
		repaint();
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		jezyk = ZProperties.getjezyk();
		if(stworzone==0)
		{
	    Dimension rozmiar = new Dimension(200,100);
	    GridBagConstraints ogranicznik = new GridBagConstraints();
	    ogranicznik.insets = new Insets(10, 10, 10, 10);
	    ogranicznik.gridx = 0;
	    ogranicznik.gridy = 0;
	    
	    Start = new JButton(s[jezyk]);
	    Start.setPreferredSize(rozmiar);
		Start.addActionListener(this);
		add(Start, ogranicznik);
		
		 ogranicznik.gridx = 1;
		 
		ActionSkin noy = new ActionSkin();
		Skorki = new JButton(noy);
		Skorki.setPreferredSize(rozmiar);
		Skorki.addActionListener(this);
		add(Skorki, ogranicznik);
		
		ogranicznik.gridx = 0;
		ogranicznik.gridy = 2;
		
		Koniec = new JButton(k[jezyk]);
		Koniec.setPreferredSize(rozmiar);
		Koniec.addActionListener(this);
		add(Koniec, ogranicznik);
		
		ogranicznik.gridx = 1;
		ogranicznik.gridy = 1;
		
		Wyniki = new JButton(w[jezyk]);
		Wyniki.setPreferredSize(rozmiar);
		Wyniki.addActionListener(this);
		add(Wyniki, ogranicznik);
		
		ogranicznik.gridx = 0;
		ogranicznik.gridy = 1;
		
		Pomoc = new JButton(p[jezyk]);
		Pomoc.setPreferredSize(rozmiar);
		Pomoc.addActionListener(this);
		add(Pomoc, ogranicznik);
		
		stworzone=1;
		}
		g.drawImage(image, 0, 0, this);
	    menu.setText(minimenu[jezyk]);
	    submenu.setText(mmo1[jezyk]);
	    jeden.setText(spolski[jezyk]);
	    drugi.setText(sangielski[jezyk]);
	    Start.setText(s[jezyk]);
	    Koniec.setText(k[jezyk]);
	    Skorki.setText(z[jezyk]);
	    Wyniki.setText(w[jezyk]);
	    Pomoc.setText(p[jezyk]);
	}


	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseClicked(MouseEvent e) 
	{
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
