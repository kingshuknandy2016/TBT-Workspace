package com.tutorialspoint.xml;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("+++++++++++++++++++++++++++");
		 try {	
	         File inputFile = new File("input.txt");
	         
	         //----Create a DocumentBuilder
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();//Creates a new instance of a DocumentBuilder using the currently configured parameters.
	         Document doc = dBuilder.parse(inputFile);
	       
	        
	         doc.getDocumentElement().normalize();
	         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName("student");
	         System.out.println("----------------------------");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            System.out.println("\nCurrent Element :"  + nNode.getNodeName());
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               
	               NamedNodeMap pat= eElement.getAttributes();
	               System.out.println("-------------"+pat.getLength());
	               System.out.println("Student roll no : " + eElement.getAttribute("rollno"));
	               System.out.println("First Name : "  + eElement.getElementsByTagName("firstname").item(0).getTextContent());
	               System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
	               System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
	               System.out.println("Marks : "  + eElement.getElementsByTagName("marks").item(0).getTextContent());
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	}

}
