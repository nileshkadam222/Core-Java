/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Nilesh
 */
public class logger {
              
    public static void log(String logText,String logType) throws IOException {
        Logger logger = Logger.getLogger("MyLog");  
        FileHandler fh; 
        
        fh = new FileHandler(commonUtility.getApplicationPath()+"/application/log/applicationLog.log");  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);
        logger.warning(logText);

      }
         
          
    
    
}
