package com.unice.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

public class DBCPThread implements Runnable {
	private static Logger log = Logger.getLogger(DBCPThread.class);
	
	private String threadName;

	public DBCPThread(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		while(true) {
			log.info("Trying to get connection " + threadName);
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				con = MySqlConnect.getEmailToSmsSource().getConnection();
				log.info("Got the connection " + threadName);
				pst = con.prepareStatement("Select * from email_logs limit 100");
				rs = pst.executeQuery();

				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (NoSuchElementException e) {
				MySqlConnect.basicDataSource = null;
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				try {
					pst.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				log.info("Closed the connection " + threadName);
			}
		}
	}

}
