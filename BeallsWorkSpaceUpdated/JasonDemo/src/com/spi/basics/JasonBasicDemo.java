package com.spi.basics;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author kingshuk.nandy
 *
 */
public class JasonBasicDemo {

	
	public static void main(String[] args) {
		
   JSONObject obj=new JSONObject();
     obj.put("Firstname", "Kingshuk");
     obj.put("Lastname", "Nandy");
   
     JSONArray list=new JSONArray();
    list.add("42/222");
    list.add("East End Park");
    list.add("Kol-39");
    obj.put("Address", list );
     
    try {
		FileWriter file = new FileWriter("C:\\WorkSpace\\BeallsWorkSpaceUpdated\\JasonDemo\\OutPut\\test.json");
		file.write(obj.toJSONString());
		file.flush();
		file.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    JasonBasicDemo.JasonRead();
	}
	
	
	public static void JasonWrite(){
		
	}
	
	public static void JasonRead(){
		JSONParser parser=new JSONParser();
		
		try {
			Object obj=parser.parse(new FileReader("C:\\WorkSpace\\BeallsWorkSpaceUpdated\\JasonDemo\\OutPut\\test.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			String firstname=(String) jsonObject.get("Firstname");
			String lastname=(String) jsonObject.get("Lastname");
			System.out.println("Firstname"+firstname+"\t"+"Lastname"+lastname);
			 JSONArray listout=(JSONArray) jsonObject.get("Address");
			 Iterator ite=listout.iterator();
			 while (ite.hasNext()) {
				 System.out.println(ite.next());
				
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
