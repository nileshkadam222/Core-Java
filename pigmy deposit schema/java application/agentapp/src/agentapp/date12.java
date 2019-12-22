/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentapp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Nilesh
 */
public class date12 
{


public static void main(String args[]) 
{
String dt = "2008-12-01";  // Start date
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar c = Calendar.getInstance();
    try {
        c.setTime(sdf.parse(dt));
    } catch (ParseException ex) {
        Logger.getLogger(date12.class.getName()).log(Level.SEVERE, null, ex);
    }
c.add(Calendar.DATE, 180);  // number of days to add
dt = sdf.format(c.getTime());  // dt is now the new date
System.out.println(dt);
}
}
