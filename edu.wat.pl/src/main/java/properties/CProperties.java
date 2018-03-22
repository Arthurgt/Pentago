package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
 
public class CProperties
{
    private static File f = new File("config.properties");
    private static Properties properties = new Properties();
    public static CProperties pt = new CProperties();
 
    public CProperties() 
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
    
    public static int getskin()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("skin"));
    }
    
    public static int getlanguage()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("language"));
    }
    
    public static int getlookandfeel()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("lookandfeel"));
    }
    
    public static int geti()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("i"));
    }
    
    public static int getwhich()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("which"));
    }
    
    public static int getimage()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("image"));
    }
    
    public static int getbuttwidth()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("buttwidth"));
    }
    
    public static int framewidth()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("framewidth"));
    }
    
    public static int frameheight()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("frameheight"));
    }
    
    public static int getbuttheight()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("buttheight"));
    }
    
    public static int getbuttxlocation()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("buttxlocation"));
    }
    
    public static int getbuttylocation()
    {
    	System.setProperty("file.encoding", "UTF-8"); 
        pt.loadProperties();
        return Integer.parseInt(pt.properties.getProperty("buttylocation"));
    }
    
    
    
    public static void saveproperties(String key, String value)
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
