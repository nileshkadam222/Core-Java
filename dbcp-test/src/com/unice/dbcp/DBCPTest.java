package com.unice.dbcp;

import org.apache.log4j.Logger;

public class DBCPTest {
	private static Logger log = Logger.getLogger(DBCPTest.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int noOfThreads = 1;
		if(args == null) 
			log.info("Args is null, starting only one Thread");
		else 
			noOfThreads = Integer.parseInt(args[0]);
		
		for(int i = 0; i < noOfThreads; i++) {
			new Thread(new DBCPThread("Thread_" + i)).start();
		}

	}

}
