package org.ghanta.threadprogramming;

public class Sequence3 extends Thread{
	public void run() {
		for (int k=1001; k<=1010; k++) {
			System.out.println("k= "+k);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
