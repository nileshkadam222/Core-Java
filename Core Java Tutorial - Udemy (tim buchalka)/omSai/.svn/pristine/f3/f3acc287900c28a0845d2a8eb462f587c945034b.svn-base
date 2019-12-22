

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerExample {

	//private static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());
       
	public static void main(String[] args) throws SecurityException, IOException {

		 Logger logger = Logger.getLogger("MyLog");  
            FileHandler fh;  

    try {  

        // This block configure the logger with handler and formatter  
        fh = new FileHandler("C:\\Users\\Nilesh\\Documents\\NetBeansProjects\\MyLogFile.txt");  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  

        // the following statement is used to log any messages  
        logger.info("My first log");  

    } catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    }  

	}

}
