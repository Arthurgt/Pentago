package pentago.edu.wat.pl;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ZxmlParser 
{
	private static String url,user,password;
	
	public static void Parse()
	{
	   try 
	   {
	         File inputFile = new File("danebd.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         NodeList nList = doc.getElementsByTagName("bazakonto");
	         
	         for (int temp = 0; temp < nList.getLength(); temp++) 
	         {
	            Node nNode = nList.item(temp);          
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) 
	            {
	               Element eElement = (Element) nNode;
	               url = eElement.getElementsByTagName("url").item(0).getTextContent();
	               user = eElement.getElementsByTagName("user").item(0).getTextContent();
	               password = eElement.getElementsByTagName("password").item(0).getTextContent();
	            }
	         }
	      } 
	   catch (Exception e) 
	   {
		   e.printStackTrace();
	   }
	}
	
	public static String getUrl()
	{
		return url;
	}
	public static String getUser() 
	{
		return user;
	}
	public static String getPassword() 
	{
		return password;
	}
}
