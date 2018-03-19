package pentago.edu.wat.pl;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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
	        } 
	        catch (SQLException e) 
	        {
	            //System.out.println(e.getMessage());
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
	            //System.out.println(ex.getMessage());
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
	            System.out.println(ex.getMessage());
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
	            System.out.println(ex.getMessage());
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
	            System.out.println(ex.getMessage());
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
	            System.out.println(ex.getMessage());
	        }
	        if(czyistnieje==0)
        	{
        		System.out.println("Uzytkownik nie istnieje");
        		String SQL2 = "INSERT INTO public.\"Pentago\"(\r\n" + 
        				"            \"Wygrane\", \"Remisy\", \"Przegrane\", \"Nick\")\r\n" + 
        				"    VALUES ('0', '0', '0', '"+niczek+"');";
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
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {

	        }
	        catch (SQLException ex) 
	        {
	            System.out.println(ex.getMessage());
	        }
	  }
	 
	 public static void updateLose(String niczek) throws FileNotFoundException
	 { 
		 String SQL = "UPDATE public.\"Pentago\"\r\n" + 
			 		"   SET \"Przegrane\"=\"Przegrane\"+'1'\r\n" + 
			 		" WHERE \"Nick\"='"+niczek+"';";
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {

	        }
	        catch (SQLException ex) 
	        {
	        	
	        }
	  }
	 
	 public static void updateDraw(String niczek) throws FileNotFoundException
	 { 
		 String SQL = "UPDATE public.\"Pentago\"\r\n" + 
		 		"   SET \"Remisy\"=\"Remisy\"+'1'\r\n" + 
		 		" WHERE \"Nick\"='"+niczek+"';";
	 
	        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) 
	        {

	        }
	        catch (SQLException ex) 
	        {

	        }
	  }
}
