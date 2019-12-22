/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nilesh
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesExample {

	public static void main(String[] s) throws IOException {

		//////saving properties into example.properties file/////////
		try (OutputStream out = new FileOutputStream("C:\\Users\\Nilesh\\Documents\\NetBeansProjects\\omSai\\application\\applicationConfig.properties")) {
			Properties properties = new Properties();
			
			properties.setProperty("databaseName", "omsai.db");
			properties.setProperty("projectName", "Om Sai");
			properties.setProperty("databaseDrivers", "jdbc:sqlite");
                        properties.setProperty("backupFolderName","Om_Sai_Auto_Backup");
                        properties.setProperty("loderImage", "C:\\Users\\Nilesh\\Documents\\NetBeansProjects\\omSai\\application\\images\\loader\\loader.gif");
			properties.setProperty("exportDefaultFolder", "D:");
                        properties.setProperty("isLicenseEnable", "true");
                        properties.setProperty("pendingFileName", "pendingAllRecords");
                        properties.setProperty("registerMacAddress", "20-68-9D-A5-F0-86");
                        properties.setProperty("registerDate","01/11/2018");
                        properties.setProperty("licenseDays","180");
                        properties.store(out, "This is a sample for java properties");
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
		///////////////////////////////////////////////////////////////



	}
}