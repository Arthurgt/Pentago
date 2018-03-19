package pentago.edu.wat.pl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
 
public class ZProperties
{
    private static File f = new File("config.properties");
    private static Properties properties = new Properties();
    public static ZProperties pt = new ZProperties();
 
    public ZProperties() 
    {
        
    }
 
    public static void loadProperties()
    {
        InputStream is;
        try 
        {
            is = new FileInputStream(f);
            properties.load(is);
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static int getwskin()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("wskin"));
    }
    
    public static int getjezyk()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("jezyk"));
    }
    
    public static int getlookifeel()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("lookifeel"));
    }
    
    public static int geti()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("i"));
    }
    
    public static void saveProperties(String key, String value)
    {
        OutputStream os;
        try 
        {
            os = new FileOutputStream(f);
            properties.setProperty(key, value);
            properties.store(os, null);
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
