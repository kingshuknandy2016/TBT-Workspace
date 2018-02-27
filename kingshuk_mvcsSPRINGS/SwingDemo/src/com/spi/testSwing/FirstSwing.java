package com.spi.testSwing;

import javax.swing.*;
import javax.swing.JFrame;

public class FirstSwing {

	/**
	 * @param args
	 */
	public FirstSwing()
	{
		JFrame f=new JFrame();  
		JButton b=new JButton(new ImageIcon("b.jpg"));  
		b.setBounds(130,100,100, 40);  
		      
		f.add(b);  
		          
		f.setSize(300,400);  
		f.setLayout(null);  
		f.setVisible(true);  
		          
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
	public static void main(String[] args) {
/*		JFrame f=new JFrame();//creating instance of JFrame  
        
		JButton b=new JButton("click");//creating instance of JButton  
		b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
		          
		f.add(b);//adding button in JFrame  
		          
		f.setSize(400,500);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
*/
		 new FirstSwing();  	
	}

}
