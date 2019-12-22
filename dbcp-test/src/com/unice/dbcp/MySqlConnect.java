package com.unice.dbcp;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class MySqlConnect {		
	public static  BasicDataSource basicDataSource = null;
	
	public static BasicDataSource getEmailToSmsSource() {
		try {
			if(basicDataSource == null) {
				InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties");
				Properties properties = new Properties();
				properties.load(inputStream);
				basicDataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(properties);
			}
		} catch (IOException e){
			e.printStackTrace();			
		} catch (Exception e) {			
			e.printStackTrace();
		}

		return basicDataSource;
	}

}
