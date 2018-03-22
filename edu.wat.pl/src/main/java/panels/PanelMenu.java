package panels;

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

import actions.ActionLanguage;
import actions.ActionSkin;
import components.MyButton;
import events.InterfaceSettings;
import events.IsListener;
import frames.FrameHelp;
import frames.FrameLogin;
import frames.FrameMenu;
import frames.FrameScores;
import lookandfeel.CLookAndFeel;
import pentago.edu.wat.pl.CMain;
import pentago.edu.wat.pl.CSettingsChanger;
import properties.CProperties;

public class PanelMenu extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame frame;
    public int created=0;
    public JButton Start, Skinss, End, Scoress, Helpp;
    public static int language;
    private String[] s = {"Graj", "Play"};
    private String[] p = {"Pomoc", "Help"};
    private String[] k = {"Wyjdz", "Exit"};
    private String[] z = {"Skorki", "Skins"};
    private String[] w = {"Wyniki", "Scores"};
    private String[] minimenu = {"Gra", "Game"};
    private String[] mmo1 = {"Jezyk", "Language"};
    private String[] spolish = {"Polski", "Polish"};
    private String[] senglish = {"Angielski", "English"};
    
    private JMenuBar MenuBarr; // menu podreczne
    private JMenu menu, submenu;
    private JMenuItem menuItem;
    private JRadioButtonMenuItem rbMenuItem;
    private JCheckBoxMenuItem cbMenuItem;
    private JMenuItem frist;
    private JMenuItem second;
    private Image image;
    public int i=0;

	public PanelMenu(JFrame fr, Image image) 
	{
		this.image = image;
		this.frame=fr;
		addMouseListener(this);
	    addMouseMotionListener(this);
	    GridBagLayout layout = new GridBagLayout();
	    setLayout(layout);
	    
	    MenuBarr = new JMenuBar();
	    menu = new JMenu(minimenu[language]);
	    MenuBarr.add(menu);
	    submenu = new JMenu(mmo1[language]);
	    ActionLanguage polish = new ActionLanguage(spolish[language]);
	    ActionLanguage english = new ActionLanguage(senglish[language]);
	    frist = new JMenuItem(polish);
	    submenu.add(frist);
	    second = new JMenuItem(english);
	    submenu.add(second);
	    menu.add(submenu);
	    frame.setJMenuBar(MenuBarr);	
	    
	}


	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if(source==End)
		{
			CMain.log.info("Game Ended");
			frame.dispose();
		}
		else if(source==Skinss)
		{
			CLookAndFeel.initLookAndFeel();
			EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                new FrameMenu();
	            }
	        });
			frame.dispose();
		}
		else if(source==Start)
		{
			EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                new FrameLogin();
	            }
	        });
			frame.dispose();
		}
		else if(source==Helpp)
		{
			EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                new FrameHelp();
	            }
	        });
			frame.dispose();
		}
		else if(source==Scoress)
		{
			EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                new FrameScores();
	            }
	        });
			frame.dispose();
		}
		repaint();
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		language = CProperties.getlanguage();
		if(created==0)
		{
	    Dimension dimension = new Dimension(200,100);
	    GridBagConstraints borders = new GridBagConstraints();
	    borders.insets = new Insets(10, 10, 10, 10);
	    borders.gridx = 0;
	    borders.gridy = 0;
	    
	    Start = new JButton(s[language]);
	    Start.setPreferredSize(dimension);
		Start.addActionListener(this);
		add(Start, borders);
		
		 borders.gridx = 1;
		 
		ActionSkin noy = new ActionSkin();
		Skinss = new JButton(noy);
		Skinss.setPreferredSize(dimension);
		Skinss.addActionListener(this);
		add(Skinss, borders);
		
		borders.gridx = 0;
		borders.gridy = 2;
		
		End = new JButton(k[language]);
		End.setPreferredSize(dimension);
		End.addActionListener(this);
		add(End, borders);
		
		borders.gridx = 1;
		borders.gridy = 1;
		
		Scoress = new JButton(w[language]);
		Scoress.setPreferredSize(dimension);
		Scoress.addActionListener(this);
		add(Scoress, borders);
		
		borders.gridx = 0;
		borders.gridy = 1;
		
		Helpp = new JButton(p[language]);
		Helpp.setPreferredSize(dimension);
		Helpp.addActionListener(this);
		add(Helpp, borders);
		
		created=1;
		}
		g.drawImage(image, 0, 0, this);
	    menu.setText(minimenu[language]);
	    submenu.setText(mmo1[language]);
	    frist.setText(spolish[language]);
	    second.setText(senglish[language]);
	    Start.setText(s[language]);
	    End.setText(k[language]);
	    Skinss.setText(z[language]);
	    Scoress.setText(w[language]);
	    Helpp.setText(p[language]);
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
