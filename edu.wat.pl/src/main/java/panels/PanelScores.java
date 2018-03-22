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
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
import database.DataBase;
import frames.FrameMenu;
import properties.CProperties;

public class PanelScores extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame frame;
    public MyButton Back;
    public MyJlabel Description;
    public MyJlabel2 jezyczek;
    public static int language;
    public String Descriptionek;
    public ArrayList<String> nicks = new ArrayList<String>();
    public ArrayList<Integer> wonn = new ArrayList<Integer>();
    public ArrayList<Integer> draww = new ArrayList<Integer>();
    public ArrayList<Integer> lostt = new ArrayList<Integer>();
    public ArrayList<Integer> ratio = new ArrayList<Integer>();
    private String[] s = {"polish.png" , "english.png"};
    private String[] t = {"Nick Wygrane Remisy Porazki Bilans" , "Nick Wins Draws Loses Ratio"};

	public PanelScores(JFrame fr) 
	{
		language = CProperties.getlanguage();
		this.frame=fr;
		addMouseListener(this);
	    addMouseMotionListener(this);
	    SpringLayout layout = new SpringLayout();
	    setLayout(layout);
	    
	    DataBase lacz = new DataBase();
    	try 
    	{
			nicks=lacz.getName();
			wonn=lacz.getWon();
			draww=lacz.getDraws();
			lostt=lacz.getLost();
		} 
    	catch (FileNotFoundException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Descriptionek = "<html> " + t[language] + " <br/> <html>";
    	for(int i=0; i<nicks.size(); i++)
    	{
    		ratio.add(wonn.get(i) - lostt.get(i));
    		Descriptionek = Descriptionek + "<html>";
    		Descriptionek = Descriptionek + nicks.get(i);
    		Descriptionek = Descriptionek + " ";
    		Descriptionek = Descriptionek + wonn.get(i);
    		Descriptionek = Descriptionek + " ";
    		Descriptionek = Descriptionek + draww.get(i);
    		Descriptionek = Descriptionek + " ";
    		Descriptionek = Descriptionek + lostt.get(i);
    		Descriptionek = Descriptionek + " ";
    		Descriptionek = Descriptionek + ratio.get(i);
    		Descriptionek = Descriptionek + "<br/> <html> ";
    	}
    	
	    Back = new MyButton("menu");
		Back.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Back, 430, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Back, 580, SpringLayout.NORTH, this);
		add(Back);
		
		Description = new MyJlabel(Descriptionek);
		layout.putConstraint(SpringLayout.WEST, Description, 170, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Description, 10, SpringLayout.NORTH, this);
		add(Description);
		
		jezyczek = new MyJlabel2(s[language]);
		layout.putConstraint(SpringLayout.WEST, jezyczek, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, jezyczek, 10, SpringLayout.NORTH, this);
		add(jezyczek);
		
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
