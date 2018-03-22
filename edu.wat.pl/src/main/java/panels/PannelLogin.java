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
import database.ZDataBase;
import exceptions.ExceptionEmptyNick;
import exceptions.ExceptionSCiNick;
import exceptions.ExceptionTooLongNick;
import exceptions.ZNicker;
import frames.FrameGame;
import frames.FrameMenu;
import properties.ZProperties;

public class PannelLogin extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame okno;
    public MyButton Powrot;
    public MyButton Graj;
    public JTextField nick1,nick2;
    public JLabel gracz1, gracz2, blad;
    public static int jezyk;
    public String opisek;
    private String[] g = {"graj" , "play"};
    private String[] gr1 = {"gracz1" , "player1"};
    private String[] gr2 = {"gracz2" , "player2"};
    private String[] bl = {"Zly nick" , "Wrong nick"};
    public Color[] skin = {Color.BLACK,Color.GREEN,Color.MAGENTA};
	public static int wskin;

	public PannelLogin(JFrame fr) 
	{
		wskin=ZProperties.getwskin();
		jezyk = ZProperties.getjezyk();
		this.okno=fr;
		addMouseListener(this);
	    addMouseMotionListener(this);
	    SpringLayout layout = new SpringLayout();
	    setLayout(layout);
	    
	    int style = Font.BOLD | Font.ITALIC;
        Font font = new Font ("Garamond", style , 50);
        Dimension rozmiar = new Dimension(200,50);
        
        gracz1 = new JLabel(gr1[jezyk]);
        gracz1.setForeground(Color.BLUE);
        gracz1.setFont(font);
        layout.putConstraint(SpringLayout.WEST, gracz1, 230, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, gracz1, 140, SpringLayout.NORTH, this);	
		add(gracz1);
    	
	    nick1 = new JTextField("");
	    nick1.addActionListener(this);
	    nick1.setPreferredSize(rozmiar);
		layout.putConstraint(SpringLayout.WEST, nick1, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nick1, 200, SpringLayout.NORTH, this);
		add(nick1);
		
		gracz2 = new JLabel(gr2[jezyk]);
        gracz2.setForeground(Color.RED);
        gracz2.setFont(font);
        layout.putConstraint(SpringLayout.WEST, gracz2, 600, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, gracz2, 140, SpringLayout.NORTH, this);	
		add(gracz2);
    	
	    nick2 = new JTextField("");
	    nick2.addActionListener(this);
	    nick2.setPreferredSize(rozmiar);
		layout.putConstraint(SpringLayout.WEST, nick2, 570, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nick2, 200, SpringLayout.NORTH, this);
		add(nick2);
		
		blad = new JLabel(bl[jezyk]);
		blad.setForeground(skin[wskin]);
		blad.setFont(font);
        layout.putConstraint(SpringLayout.WEST, blad, 370, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, blad, 50, SpringLayout.NORTH, this);	
		add(blad);
	    
	    Powrot = new MyButton("menu");
		Powrot.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Powrot, 390, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Powrot, 550, SpringLayout.NORTH, this);
		add(Powrot);
		
		Graj = new MyButton(g[jezyk]);
		Graj.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Graj, 480, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Graj, 550, SpringLayout.NORTH, this);
		add(Graj);
		
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
		else if(source == Graj)
		{
			try 
			{
				int i = ZNicker.sprawdz(nick1.getText(),nick2.getText());
				ZDataBase lacz = new ZDataBase();
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
					okno.dispose();
			} 
			catch (ExceptionEmptyNick e1) 
			{
				blad.setForeground(Color.ORANGE);
				e1.printStackTrace();
			} 
			catch (ExceptionTooLongNick e2) 
			{
				blad.setForeground(Color.ORANGE);
				e2.printStackTrace();
			} 
			catch (ExceptionSCiNick e2) 
			{
				blad.setForeground(Color.ORANGE);
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