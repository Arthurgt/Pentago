package swingworker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingWorker;

import pentago.edu.wat.pl.ZMain;
import xml.ZxmlParser;

public class SWdatabaseWIN extends SwingWorker<Connection, Object>
{
	private static String url;
	private static String user;
	private static String password;
	private static String SQL;
	
	public SWdatabaseWIN(String sqql)
	{
		this.SQL=sqql;
	}
	
	@Override
	protected Connection doInBackground() throws Exception 
	{
		//lista.clear();
		ZxmlParser.Parse();
	 	url = ZxmlParser.getUrl();
	 	user = ZxmlParser.getUser();
	 	password = ZxmlParser.getPassword();

        Connection conn = null;
        try 
        {
            conn = DriverManager.getConnection(url, user, password);
            ZMain.log.info("Polaczono sie z Baza Danych");
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
