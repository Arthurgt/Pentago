package pentago.edu.wat.pl;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class ZLookAndFeel 
{
	public static int i=0;
	public static void initLookAndFeel() 
	{
		i = ZProperties.getlookifeel();
            if (i==0) 
            {
            	try 
            	{
					UIManager.setLookAndFeel(new MetalLookAndFeel());
					MetalLookAndFeel.setCurrentTheme(new OceanTheme());
				} 
            	catch (UnsupportedLookAndFeelException e) 
            	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            	i=1;
            }
            
            else if (i==1) 
            {
            	try 
            	{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} 
            	catch (ClassNotFoundException e) 
            	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            	catch (InstantiationException e) 
            	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            	catch (IllegalAccessException e) 
            	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            	catch (UnsupportedLookAndFeelException e) 
            	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	i=2;
            } 
            
            else if (i==2) 
            {
            	try 
            	{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} 
            	catch (ClassNotFoundException e) 
            	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	catch (InstantiationException e) 
            	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            	catch (IllegalAccessException e) 
            	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            	catch (UnsupportedLookAndFeelException e) 
            	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	i=0;
            } 
        }
    }
