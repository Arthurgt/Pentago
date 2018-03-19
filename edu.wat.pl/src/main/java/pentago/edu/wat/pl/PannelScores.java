package pentago.edu.wat.pl;

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

public class PannelScores extends JPanel implements ActionListener, MouseListener, MouseMotionListener 
{
    public static JFrame okno;
    public MyButton Powrot;
    public MyJlabel opis;
    public MyJlabel2 jezyczek;
    public static int jezyk;
    public String opisek;
    public ArrayList<String> nicki = new ArrayList<String>();
    public ArrayList<Integer> wygrane = new ArrayList<Integer>();
    public ArrayList<Integer> remisy = new ArrayList<Integer>();
    public ArrayList<Integer> przegrane = new ArrayList<Integer>();
    public ArrayList<Integer> wspolczynnik = new ArrayList<Integer>();
    private String[] s = {"polish.png" , "english.png"};
    private String[] t = {"Nick Wygrane Remisy Porazki Bilans" , "Nick Wins Draws Loses Ratio"};

	public PannelScores(JFrame fr) 
	{
		jezyk = ZProperties.getjezyk();
		this.okno=fr;
		addMouseListener(this);
	    addMouseMotionListener(this);
	    SpringLayout layout = new SpringLayout();
	    setLayout(layout);
	    
	    ZDataBase lacz = new ZDataBase();
    	try 
    	{
			nicki=lacz.getName();
			wygrane=lacz.getWins();
			remisy=lacz.getDraws();
			przegrane=lacz.getLoses();
		} 
    	catch (FileNotFoundException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	opisek = "<html> " + t[jezyk] + " <br/> <html>";
    	for(int i=0; i<nicki.size(); i++)
    	{
    		wspolczynnik.add(wygrane.get(i) - przegrane.get(i));
    		opisek = opisek + "<html>";
    		opisek = opisek + nicki.get(i);
    		opisek = opisek + " ";
    		opisek = opisek + wygrane.get(i);
    		opisek = opisek + " ";
    		opisek = opisek + remisy.get(i);
    		opisek = opisek + " ";
    		opisek = opisek + przegrane.get(i);
    		opisek = opisek + " ";
    		opisek = opisek + wspolczynnik.get(i);
    		opisek = opisek + "<br/> <html> ";
    	}
    	
	    Powrot = new MyButton("menu");
		Powrot.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, Powrot, 430, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Powrot, 580, SpringLayout.NORTH, this);
		add(Powrot);
		
		opis = new MyJlabel(opisek);
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
