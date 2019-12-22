import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nilesh
 */
public class sqlProperties {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nilesh
 */

	public static void main(String[] s) throws IOException {
		//////saving properties into example.properties file/////////
               //Enter data using BufferReader 
            BufferedReader reader =   new BufferedReader(new InputStreamReader(System.in)); 
            // Reading data using readLine 
            System.out.print("Enter path :");
            String filePath = reader.readLine(); 
                //C:\\Users\\Nilesh\\Documents\\NetBeansProjects\\omSai\\application\\applicationConfig.properties
                filePath = filePath+File.separator+"allQuery.properties";
		try (OutputStream out = new FileOutputStream(filePath)) {
			Properties properties = new Properties();
			Map<String ,String> listOfQuery = new HashMap<>();
                        listOfQuery = getQueries();
                       for (Map.Entry<String, String> entry : listOfQuery.entrySet()) {
                            properties.setProperty(entry.getKey(), entry.getValue());
                        }
                       properties.store(out, "This is a sample for java properties");
                       out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
                    
                }
		///////////////////////////////////////////////////////////////
	}
        
        public static Map<String,String> getQueries(){
            Map<String,String> queryMap = new HashMap<>();
            //put your query in this map and run this program
            queryMap.put("getAllCustomerList","select distinct c.customer_id ,c.customer_name as \"Name\", a.account_number as \"Account Number\",c.vehicle_number as \"Vechicle Number\",a.loan_amount as \"Loan Amount\", case when cast(julianday('now') - julianday(max(t.transaction_date)) as integer)  > 10 then 'Pay' else 'Paid' end status from customer c join account a on c.customer_id = a.customer_id join transactions t on t.account_number = a.account_number  group by c.customer_id");
            queryMap.put("getPendingCustomers","select distinct c.customer_id,c.customer_name as \"Name\", a.account_number as \"Account Number\",c.vehicle_number as \"Vechicle Number\",a.loan_amount as \"Loan Amount\", case when cast(julianday('now') - julianday(max(t.transaction_date)) as integer)  > 10 then 'Pay' else 'Paid' end status from customer c join account a on c.customer_id = a.customer_id join transactions t on t.account_number = a.account_number  group by c.customer_id having status = 'Pay'");
            queryMap.put("getHomepageData","select (select count(1) from customer) as customer_count, (select sum(amount) from transactions where amount_type = 'Installment') as received, (select sum(amount) from transactions where amount_type = 'Recovery') as recovery, (select sum(amount) from transactions where amount_type = 'Interest') as interest, (select sum(amount) from transactions where amount_type = 'Fine') as fine, (select sum(expense_amount) from expenses where expense_type = 'loan_amount') as invested, (select sum(expense_amount) from expenses where expense_type = 'others') as expense");
            queryMap.put("getCustomerDetails", "select * from  customer inner join account  on customer.customer_id = account.customer_id where customer.customer_id =");
            return queryMap;
        }       
}
