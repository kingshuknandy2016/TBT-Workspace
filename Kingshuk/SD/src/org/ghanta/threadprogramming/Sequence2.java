package org.ghanta.threadprogramming;

public class Sequence2 implements Runnable{
	public void run() {
		for (int j=101; j<=110; j++) {
			System.out.println("j= "+j);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
