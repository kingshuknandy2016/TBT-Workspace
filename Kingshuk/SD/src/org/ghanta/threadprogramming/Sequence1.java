package org.ghanta.threadprogramming;

public class Sequence1 implements Runnable{

	public void run() {
		for (int i=1; i<=10; i++) {
			System.out.println("i= "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
