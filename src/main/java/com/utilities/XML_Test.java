/**
 * 
 */
package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * @author sambeetmohapatra
 *
 */
public class XML_Test  {
	
	public static void main(String[] args)  throws ParserConfigurationException, SAXException, IOException{
				
		
		 File inputFile = new File("./src/test/java/com/nLinkTest/demo.xml");
		 
		 
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		

		 Document doc = dBuilder.parse(inputFile);
		 doc.getDocumentElement().normalize();
		 
		 Scanner s = new Scanner(System.in);
		String object = s.next(); //PageName.ElementName
		 s.close();
		
		 String[] parts = object.split("/");
		 String pageName = parts[0];
		 String elementName = parts[1];

		 NodeList nList = doc.getElementsByTagName(pageName);
		 Node nNode = nList.item(0);
		 
		 Element eElement = (Element) nNode;
		 System.out.println(eElement.getElementsByTagName(elementName).item(0).getTextContent());
		 System.out.println(eElement.getElementsByTagName(elementName).item(0).getAttributes().item(0).getTextContent());

	
	
	
	}
}
