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

import pentago.edu.wat.pl.CMain;
import swingworker.SWdatabaseDRAW;
import swingworker.SWdatabaseLOSE;
import swingworker.SWdatabaseWIN;
import xml.XmlParser;

public class DataBase 
{
	private static String url;
	private static String user;
	private static String password;

	 public static Connection connect() throws SQLException, FileNotFoundException
	 {
		 	XmlParser.Parse();
		 	url = XmlParser.getUrl();
		 	user = XmlParser.getUser();
		 	password = XmlParser.getPassword();
 
	        Connection conn = null;
	        try 
	        {
	            conn = DriverManager.getConnection(url, user, password);
	            CMain.log.info("Connected to the Data Base");
	        } 
	        catch (SQLException e) 
	        {
	            
	        }
	 
	        return conn;
	 }
	 
	 public static ArrayList<Integer> getWon() throws FileNotFoundException
	 { 
	        String SQL = "SELECT *"
	        		   + "FROM public.\"Pentago\""
	        		   + "ORDER BY \"Wygrane\"-\"Przegrane\" DESC "
	        		   + "LIMIT 15;";
	        ArrayList<Integer> won = new ArrayList<Integer>();
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {
	        	while(rs.next()) 
	        	{
	        		won.add(rs.getInt(1));
				}
	        }
	        catch (SQLException ex) 
	        {
	            
	        }
	        return won;
	        
	  }
	 
	 public static ArrayList<Integer> getDraws() throws FileNotFoundException
	 { 
		 String SQL = "SELECT *"
      		   + "FROM public.\"Pentago\""
      		   + "ORDER BY \"Wygrane\"-\"Przegrane\" DESC "
      		 + "LIMIT 15;";
	        ArrayList<Integer> draws = new ArrayList<Integer>();

	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	       {
	        	while(rs.next()) 
	        	{
	        		draws.add(rs.getInt(2));
				}
	        }
	        catch (SQLException ex) 
	       {
	            
	        }
	        return draws;
	  }
	 
	 public static ArrayList<Integer> getLost() throws FileNotFoundException
	 { 
		 String SQL = "SELECT *"
      		   + "FROM public.\"Pentago\""
      		   + "ORDER BY \"Wygrane\"-\"Przegrane\" DESC "
      		 + "LIMIT 15;";
	        ArrayList<Integer> lost = new ArrayList<Integer>();
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {
	        	while(rs.next()) 
	        	{
	        		lost.add(rs.getInt(3));
				}
	        }
	        catch (SQLException ex) 
	        {
	            
	        }
	        return lost;
	  }
	 
	 public static ArrayList<String> getName() throws FileNotFoundException
	 {
		 String SQL = "SELECT *"
      		   + "FROM public.\"Pentago\""
      		   + "ORDER BY \"Wygrane\"-\"Przegrane\" DESC "
      		 + "LIMIT 15;";
	        ArrayList<String> nicks = new ArrayList<String>();
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {
	        	while(rs.next()) 
	        	{
	        		nicks.add(rs.getString(4));
				}
	        }
	        catch (SQLException ex) 
	        {
	            
	        }
	        return nicks;
	  }
	 
	 public static void checkName(String nick) throws FileNotFoundException
	 { 
		 int exsist=0;
		 String SQL = "SELECT *"
      		   + "FROM public.\"Pentago\""
				 +"WHERE \"Nick\"='"+nick+"'";
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {
	        	while(rs.next()) 
	        	{
	        		if(!rs.getString(4).isEmpty())
	        		{	
	        			exsist=1;
	        		}
				}
	        }
	        catch (SQLException ex) 
	        {
	            
	        }
	        if(exsist==0)
        	{
        		String SQL2 = "INSERT INTO public.\"Pentago\"(\r\n" + 
        				"            \"Wygrane\", \"Remisy\", \"Przegrane\", \"Nick\")\r\n" + 
        				"    VALUES ('0', '0', '0', '"+nick+"');";
        		CMain.log.info("Dodano nowego uzytkownika do bazy");
        		 try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL2)) 
     	        {
        			 
     	        }
     	        catch (SQLException ex) 
     	        {
     	        }
        	}	        
	  }
	 
	 public static void updateWin(String nick) throws FileNotFoundException
	 { 
		 String SQL = "UPDATE public.\"Pentago\"\r\n" + 
			 		"   SET \"Wygrane\"=\"Wygrane\"+'1'\r\n" + 
			 		" WHERE \"Nick\"='"+nick+"';";
		 SWdatabaseWIN sw1 = new SWdatabaseWIN(SQL);
		 sw1.execute();
	  }
	 
	 public static void updateLose(String nick) throws FileNotFoundException
	 { 
		 String SQL = "UPDATE public.\"Pentago\"\r\n" + 
			 		"   SET \"Przegrane\"=\"Przegrane\"+'1'\r\n" + 
			 		" WHERE \"Nick\"='"+nick+"';";
		 SWdatabaseLOSE sw2 = new SWdatabaseLOSE(SQL);
		 sw2.execute();
	  }
	 
	 public static void updateDraw(String nick) throws FileNotFoundException
	 { 
		 String SQL = "UPDATE public.\"Pentago\"\r\n" + 
		 		"   SET \"Remisy\"=\"Remisy\"+'1'\r\n" + 
		 		" WHERE \"Nick\"='"+nick+"';";
		 SWdatabaseDRAW sw3 = new SWdatabaseDRAW(SQL);
		 sw3.execute();
	  }
}
