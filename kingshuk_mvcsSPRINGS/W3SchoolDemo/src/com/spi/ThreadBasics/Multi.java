package com.spi.ThreadBasics;

public class Multi extends Thread {

	public Multi() {
		System.out.println("Main thread will be alive till the child thread is alive");
	}

	
	public void run(){  
		//System.out.println("thread is running...");
		for (int i = 0; i < 10; i++) {
			int j=i+1;
			System.out.println("print the count "+j);
			/*Multi t2=new Multi();
			if(t2.isAlive()==true){
				System.out.println("Main thread will be alive till the child thread is alive");
			}*/
			
		}
		}  
		public static void main(String args[]){  
		Multi t1=new Multi(); 
		/*System.out.print("my thread created");
		t1.setName("my extending thread");
		
		System.out.println(t1);*/
		t1.start();
		
		Multi t2=new Multi();
		t2.start();
		
		
		 }  

}
