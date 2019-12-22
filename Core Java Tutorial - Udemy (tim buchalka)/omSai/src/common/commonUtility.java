/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nilesh
 */
public class commonUtility {
    
    /**
     *
     */
    
    public static String getApplicationPath(){
        return System.getenv("applicationPath");
    }
    public static Properties getProperties(){
        Properties prop = new Properties();
         InputStream in;
        try {
            String appPath = getApplicationPath();
            in = new FileInputStream(appPath+"/application/applicationConfig.properties");
             prop.load(in);
             System.out.println(prop.getProperty("applcationPath"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(commonUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(commonUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return prop;
    }
    
        public static Properties getQueryProperties(){
        Properties prop = new Properties();
         InputStream in;
        try {
            String appPath = getApplicationPath();
            in = new FileInputStream(appPath+"/application/allQuery.properties");
             prop.load(in);
             System.out.println(prop.getProperty("applcationPath"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(commonUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(commonUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return prop;
    }
    
    
  
public static void backupDatabaseInApplicaton(String ParentFolderPath) throws IOException {
    String appPath = getApplicationPath();
    InputStream is = null;
    OutputStream os = null;
    try {
       
        Date date= new Date();
        long time = date.getTime();
         Properties properties = commonUtility.getProperties();
         String folderName = properties.getProperty("backupFolderName")+"_database"+time;
               
        File newFolder = new File(ParentFolderPath+"/"+folderName);
        boolean created =  newFolder.mkdir();
        
        if(created){
           is = new FileInputStream(appPath+"/application/storage/"+properties.getProperty("databaseName"));
           os = new FileOutputStream(ParentFolderPath+"/"+folderName+"/"+properties.getProperty("databaseName"));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            }else{

            }
        
    } finally {
        is.close();
        os.close();
    }
}

public static Boolean createFolder(String folderPath){
        
        File newFolder = new File(folderPath);
        boolean created =  newFolder.mkdir();
        System.out.println("common.commonUtility.createFolder()"+created);
        System.out.println("folder path"+folderPath);
        return  created;
}
public static void backupDatabaseInUserLoaction(String folderPath) throws IOException {
    String appPath = getApplicationPath();
    InputStream is = null;
    OutputStream os = null;
    try {
        
        Date date= new Date();
        long time = date.getTime();
        Properties properties = commonUtility.getProperties();
        String folderName = properties.getProperty("backupFolderName")+"_database"+time;
        
        File newFolder = new File(folderPath +"/"+folderName);
        boolean created =  newFolder.mkdir();
        
        if(created){
        is = new FileInputStream(appPath+"/application/storage/"+properties.getProperty("databaseName"));
        os = new FileOutputStream(folderPath+"/"+folderName+"/"+properties.getProperty("databaseName"));
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        }else{
            
        }
        
    } finally {
        is.close();
        os.close();
    }
}

public static String getMacAddress(){
    InetAddress ip;
    String macAddress = null;
	try {
			
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
			
		System.out.print("Current MAC address : ");
			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
                macAddress = sb.toString();
		System.out.println(sb.toString());
			
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
        return macAddress;
}
public static int getDifferenceDays(Date d1, Date d2) {
    int daysdiff = 0;
    long diff = d2.getTime() - d1.getTime();
    long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
    daysdiff = (int) diffDays;
    return daysdiff;
}
public static boolean isValidLicense() throws ParseException{
    //check mac addre
    Properties properties = commonUtility.getProperties();
    Date currentDate = new Date();
    String isLicenseCheck = properties.getProperty("isLicenseEnable");
    if(isLicenseCheck == null){
        return false;
    }
    if(isLicenseCheck.equalsIgnoreCase("true")){
        String registerMacAddress = properties.getProperty("registerMacAddress");
    String registerDate = properties.getProperty("registerDate");
    int numberOFDays = Integer.parseInt(properties.getProperty("licenseDays"));
     
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = sdf.format(cal.getTime());
    Date licenseDate=new SimpleDateFormat("dd/MM/yyyy").parse(registerDate);
    Date current=new SimpleDateFormat("dd/MM/yyyy").parse(strDate); 
    //check mac address
    String currentMacAddress = getMacAddress();
        System.out.print("MAC Address:" + currentMacAddress);
    int diffDays = getDifferenceDays(licenseDate,currentDate);
    if(diffDays > 0 && (numberOFDays - diffDays > 0)){
        if(currentMacAddress.equalsIgnoreCase(registerMacAddress)){
        //check days wise validation
        return true;
        }
    }
    return false;
    }
    return true;
}

public static List<Date> getDaysBetweenDates(Date startdate, Date enddate)
{
    List<Date> dates = new ArrayList<Date>();
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(startdate);

    while (calendar.getTime().before(enddate))
    {
        Date result = calendar.getTime();
        dates.add(result);
        calendar.add(Calendar.DATE, 1);
    }
    return dates;
}

   
}
