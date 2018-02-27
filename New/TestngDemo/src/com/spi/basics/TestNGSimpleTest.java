package com.spi.basics;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;





public class TestNGSimpleTest {

	 @Test
	 public void testAdd() {
	      String str = "TestNG is working fine";
	      AssertJUnit.assertEquals("TestNG is working fine", str);
	   }
}
