
import common.commonUtility;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nilesh
 */
public class testLicense {
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
    String registerMacAddress = "20-68-9D-A5-F0-86";            //properties.getProperty("registerMacAddress");
    String registerDate = "01/11/2018";                                      //properties.getProperty("registerDate");
    int numberOFDays =  1;                    //Integer.parseInt(properties.getProperty("licenseDays"));
     
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = sdf.format(cal.getTime());
    Date licenseDate=new SimpleDateFormat("dd/MM/yyyy").parse(registerDate);
    Date current=new SimpleDateFormat("dd/MM/yyyy").parse(strDate); 
    //check mac address
    String currentMacAddress = getMacAddress();
    int diffDays = getDifferenceDays(licenseDate,currentDate);
    if(diffDays > 0 && (numberOFDays - diffDays > 0)){
        if(currentMacAddress.equalsIgnoreCase(registerMacAddress)){
        //check days wise validation
        return true;
        }
    }
    return false;
}

public static void main(String args[]) throws ParseException{
    boolean a = isValidLicense();
    System.out.println("valiate license"  + a );
}
}
