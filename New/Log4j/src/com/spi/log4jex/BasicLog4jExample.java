package com.spi.log4jex;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicLog4jExample {
	
	public static void main(String[] args) {
        Logger logger = Logger.getLogger(BasicLog4jExample.class);
        BasicConfigurator.configure();
        logger.info("This is my first log4j's statement");
    }
	
}
