/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admindata;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Nilesh
 */
public class try12 {
    
    public static void main(String arg[]) throws ParseException
    {
 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar c = Calendar.getInstance();
c.setTime(new Date()); 
c.add(Calendar.DATE, 180); // Adding 5 days
String output = sdf.format(c.getTime());

}
}
