package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import pentago.edu.wat.pl.ZMain;
import swingworker.SWdatabaseDRAW;
import swingworker.SWdatabaseLOSE;
import swingworker.SWdatabaseWIN;
import xml.ZxmlParser;

public class ZDataBase 
{
	private static String url;
	private static String user;
	private static String password;

	 public static Connection connect() throws SQLException, FileNotFoundException // metoda do łączenia się za bazą
	 {
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
	 
	 public static ArrayList<Integer> getWins() throws FileNotFoundException
	 { 
	        String SQL = "SELECT *"
	        		   + "FROM public.\"Pentago\""
	        		   + "ORDER BY \"Wygrane\"-\"Przegrane\" DESC "
	        		   + "LIMIT 15;";
	        ArrayList<Integer> wygrane = new ArrayList<Integer>();
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {
	        	while(rs.next()) 
	        	{
	        		wygrane.add(rs.getInt(1));
				}
	        }
	        catch (SQLException ex) 
	        {
	            
	        }
	        return wygrane;
	        
	  }
	 
	 public static ArrayList<Integer> getDraws() throws FileNotFoundException
	 { 
		 String SQL = "SELECT *"
      		   + "FROM public.\"Pentago\""
      		   + "ORDER BY \"Wygrane\"-\"Przegrane\" DESC "
      		 + "LIMIT 15;";
	        ArrayList<Integer> remisy = new ArrayList<Integer>();

	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	       {
	        	while(rs.next()) 
	        	{
	        		remisy.add(rs.getInt(2));
				}
	        }
	        catch (SQLException ex) 
	       {
	            
	        }
	        return remisy;
	  }
	 
	 public static ArrayList<Integer> getLoses() throws FileNotFoundException
	 { 
		 String SQL = "SELECT *"
      		   + "FROM public.\"Pentago\""
      		   + "ORDER BY \"Wygrane\"-\"Przegrane\" DESC "
      		 + "LIMIT 15;";
	        ArrayList<Integer> przegrane = new ArrayList<Integer>();
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {
	        	while(rs.next()) 
	        	{
	        		przegrane.add(rs.getInt(3));
				}
	        }
	        catch (SQLException ex) 
	        {
	            
	        }
	        return przegrane;
	  }
	 
	 public static ArrayList<String> getName() throws FileNotFoundException
	 {
		 String SQL = "SELECT *"
      		   + "FROM public.\"Pentago\""
      		   + "ORDER BY \"Wygrane\"-\"Przegrane\" DESC "
      		 + "LIMIT 15;";
	        ArrayList<String> nicki = new ArrayList<String>();
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {
	        	while(rs.next()) 
	        	{
	        		nicki.add(rs.getString(4));
				}
	        }
	        catch (SQLException ex) 
	        {
	            
	        }
	        return nicki;
	  }
	 
	 public static void checkName(String niczek) throws FileNotFoundException
	 { 
		 int czyistnieje=0;
		 String SQL = "SELECT *"
      		   + "FROM public.\"Pentago\""
				 +"WHERE \"Nick\"='"+niczek+"'";
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {
	        	while(rs.next()) 
	        	{
	        		if(!rs.getString(4).isEmpty())
	        		{	
	        			czyistnieje=1;
	        		}
				}
	        }
	        catch (SQLException ex) 
	        {
	            
	        }
	        if(czyistnieje==0)
        	{
        		String SQL2 = "INSERT INTO public.\"Pentago\"(\r\n" + 
        				"            \"Wygrane\", \"Remisy\", \"Przegrane\", \"Nick\")\r\n" + 
        				"    VALUES ('0', '0', '0', '"+niczek+"');";
        		ZMain.log.info("Dodano nowego uzytkownika do bazy");
        		 try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL2)) 
     	        {
        			 
     	        }
     	        catch (SQLException ex) 
     	        {
     	        }
        	}	        
	  }
	 
	 public static void updateWin(String niczek) throws FileNotFoundException
	 { 
		 String SQL = "UPDATE public.\"Pentago\"\r\n" + 
			 		"   SET \"Wygrane\"=\"Wygrane\"+'1'\r\n" + 
			 		" WHERE \"Nick\"='"+niczek+"';";
		 SWdatabaseWIN sw1 = new SWdatabaseWIN(SQL);
		 sw1.execute();
	  }
	 
	 public static void updateLose(String niczek) throws FileNotFoundException
	 { 
		 String SQL = "UPDATE public.\"Pentago\"\r\n" + 
			 		"   SET \"Przegrane\"=\"Przegrane\"+'1'\r\n" + 
			 		" WHERE \"Nick\"='"+niczek+"';";
		 SWdatabaseLOSE sw2 = new SWdatabaseLOSE(SQL);
		 sw2.execute();
	  }
	 
	 public static void updateDraw(String niczek) throws FileNotFoundException
	 { 
		 String SQL = "UPDATE public.\"Pentago\"\r\n" + 
		 		"   SET \"Remisy\"=\"Remisy\"+'1'\r\n" + 
		 		" WHERE \"Nick\"='"+niczek+"';";
		 SWdatabaseDRAW sw3 = new SWdatabaseDRAW(SQL);
		 sw3.execute();
	  }
}
