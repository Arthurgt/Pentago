package swingworker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingWorker;

import pentago.edu.wat.pl.CMain;
import xml.XmlParser;

public class SWdatabaseLOSE extends SwingWorker<Connection, Object>
{
	private static String url;
	private static String user;
	private static String password;
	private static String SQL;
	
	public SWdatabaseLOSE(String sqql)
	{
		this.SQL=sqql;
	}
	
	@Override
	protected Connection doInBackground() throws Exception 
	{
		//lista.clear();
		XmlParser.Parse();
	 	url = XmlParser.getUrl();
	 	user = XmlParser.getUser();
	 	password = XmlParser.getPassword();

        Connection conn = null;
        try 
        {
            conn = DriverManager.getConnection(url, user, password);
            CMain.log.info("Connected to the data base");
        } 
        catch (SQLException e) 
        {
            
        }
        return conn;
	}
	
	protected void done() 
	{
        try 
        {
        	Statement stmt = get().createStatement(); ResultSet rs = stmt.executeQuery(SQL);
        } 
        catch (Exception ignore) 
        {
        	
        }
    }
}
