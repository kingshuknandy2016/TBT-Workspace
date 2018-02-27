package com.spi.exception.wrap;

public class ExceptionWrapDemo {

	
	public void exceDemo() throws Exception{
		throw new Exception();
	}
	
	public void exceDemoOne() {
		try {
			exceDemo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e); // Exception Wrap...
			//throw e; // 
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ExceptionWrapDemo().exceDemoOne(); 
	}

}
