package com.kino.log4j.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4jTest {
	
	private static final Logger logger = LogManager.getLogger(Log4jTest.class);
	
	@Test
	public void testHelloWorld(){
		logger.info("HelloWorld!1111");
	}
}
