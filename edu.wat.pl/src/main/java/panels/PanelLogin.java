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
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import components.MyButton;
import database.DataBase;
import exceptions.ExceptionEmptyNick;
import exceptions.ExceptionSpaceInNick;
import exceptions.ExceptionTooLongNick;
import exceptions.CNickChecker;
import frames.FrameGame;
import frames.FrameMenu;
import properties.CProperties;

public class PanelLogin extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame frame;
    public MyButton Back;
    public MyButton Play;
    public JTextField nick1,nick2;
    public JLabel player1, player2, errorrr;
    public static int language;
    public String Description;
    private String[] g = {"Graj" , "play"};
    private String[] gr1 = {"player1" , "player1"};
    private String[] gr2 = {"player2" , "player2"};
    private String[] bl = {"Zly nick" , "Wrong nick"};
    public Color[] skin = {Color.BLACK,Color.GREEN,Color.MAGENTA};
	public static int choiceskin;

	public PanelLogin(JFrame fr) 
	{
		choiceskin=CProperties.getskin();
		language = CProperties.getlanguage();
		this.frame=fr;
		addMouseListener(this);
	    addMouseMotionListener(this);
	    SpringLayout layout = new SpringLayout();
	    setLayout(layout);
	    
	    int style = Font.BOLD | Font.ITALIC;
        Font font = new Font ("Garamond", style , 50);
        Dimension rozmiar = new Dimension(200,50);
        
        player1 = new JLabel(gr1[language]);
        player1.setForeground(Color.BLUE);
        player1.setFont(font);
        layout.putConstraint(SpringLayout.WEST, player1, 230, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, player1, 140, SpringLayout.NORTH, this);	
		add(player1);
    	
	    nick1 = new JTextField("");
	    nick1.addActionListener(this);
	    nick1.setPreferredSize(rozmiar);
		layout.putConstraint(SpringLayout.WEST, nick1, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nick1, 200, SpringLayout.NORTH, this);
		add(nick1);
		
		player2 = new JLabel(gr2[language]);
        player2.setForeground(Color.RED);
        player2.setFont(font);
        layout.putConstraint(SpringLayout.WEST, player2, 600, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, player2, 140, SpringLayout.NORTH, this);	
		add(player2);
    	
	    nick2 = new JTextField("");
	    nick2.addActionListener(this);
	    nick2.setPreferredSize(rozmiar);
		layout.putConstraint(SpringLayout.WEST, nick2, 570, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nick2, 200, SpringLayout.NORTH, this);
		add(nick2);
		
		errorrr = new JLabel(bl[language]);
		errorrr.setForeground(skin[choiceskin]);
		errorrr.setFont(font);
        layout.putConstraint(SpringLayout.WEST, errorrr, 370, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, errorrr, 50, SpringLayout.NORTH, this);	
		add(errorrr);
	    
	    Back = new MyButton("menu");
		Back.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Back, 390, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Back, 550, SpringLayout.NORTH, this);
		add(Back);
		
		Play = new MyButton(g[language]);
		Play.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Play, 480, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Play, 550, SpringLayout.NORTH, this);
		add(Play);
		
	}


	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if(source == Back)
		{
			EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                new FrameMenu();
	            }
	        });
			frame.dispose();
		}
		else if(source == Play)
		{
			try 
			{
				int i = CNickChecker.check(nick1.getText(),nick2.getText());
				DataBase lacz = new DataBase();
					try 
					{
						lacz.checkName(nick1.getText());
						lacz.checkName(nick2.getText());
					} 
					catch (FileNotFoundException s) 
					{

						s.printStackTrace();
					}
					
					EventQueue.invokeLater(new Runnable() 
					{
						public void run() 
						{
							new FrameGame(nick1.getText(), nick2.getText());
						}
					});
					frame.dispose();
			} 
			catch (ExceptionEmptyNick e1) 
			{
				errorrr.setForeground(Color.ORANGE);
				e1.printStackTrace();
			} 
			catch (ExceptionTooLongNick e2) 
			{
				errorrr.setForeground(Color.ORANGE);
				e2.printStackTrace();
			} 
			catch (ExceptionSpaceInNick e2) 
			{
				errorrr.setForeground(Color.ORANGE);
				e2.printStackTrace();
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