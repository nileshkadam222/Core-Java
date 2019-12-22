package common;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
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
public class registerApplication {
    public static void main(String args[]){
        createCommonProp();
        createSqlProperties();
    }
    
    //create common properties
    public static void createCommonProp(){
        String fileLocaton = getApplicationPath() + File.separator +"application\\applicationConfig.properties";
        try (OutputStream out = new FileOutputStream(fileLocaton)) {
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
                        properties.setProperty("licenseDays","360");
                        properties.store(out, "This is a sample for java properties");
                        System.out.println("common propertes register successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static void createSqlProperties(){
         String fileLocaton = getApplicationPath() + File.separator +"application\\allQuery.properties";
		try (OutputStream out = new FileOutputStream(fileLocaton)) {
			Properties properties = new Properties();
			Map<String ,String> listOfQuery = new HashMap<>();
                        listOfQuery = getQueries();
                       for (Map.Entry<String, String> entry : listOfQuery.entrySet()) {
                            properties.setProperty(entry.getKey(), entry.getValue());
                        }
                       properties.store(out, "This is a sample for java properties");
                       System.out.println("sql properties set successfully");
                       out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
                    
                }
    }
    
      public static String getApplicationPath(){
        return System.getenv("applicationPath");
    }
      
     public static Map<String,String> getQueries(){
            Map<String,String> queryMap = new HashMap<>();
            //put your query in this map and run this program
            queryMap.put("getAllCustomerList","select distinct c.customer_id ,c.customer_name as \"Name\", a.account_number as \"Account Number\",c.vehicle_number as \"Vechicle Number\",a.loan_amount as \"Loan Amount\", case when cast(julianday('now') - julianday(max(t.transaction_date)) as integer)  > 10 then 'Pay' else 'Paid' end status from customer c join account a on c.customer_id = a.customer_id join transactions t on t.account_number = a.account_number  group by c.customer_id");
            queryMap.put("getPendingCustomers","select distinct c.customer_id,c.customer_name as \"Name\", a.account_number as \"Account Number\",c.vehicle_number as \"Vechicle Number\",a.loan_amount as \"Loan Amount\", case when cast(julianday('now') - julianday(max(t.transaction_date)) as integer)  > 10 then 'Pay' else 'Paid' end status from customer c join account a on c.customer_id = a.customer_id join transactions t on t.account_number = a.account_number  group by c.customer_id having status = 'Pay'");
            queryMap.put("getHomepageData","select (select count(1) from customer) as customer_count, (select sum(amount) from transactions where amount_type = 'Installment') as received, (select sum(amount) from transactions where amount_type = 'Recovery') as recovery, (select sum(amount) from transactions where amount_type = 'Interest') as interest, (select sum(amount) from transactions where amount_type = 'Fine') as fine, (select sum(expense_amount) from expenses where expense_type = 'loan_amount') as invested, (select sum(expense_amount) from expenses where expense_type = 'others') as expense");
            queryMap.put("getCustomerDetails", "select * from  customer inner join account  on customer.customer_id = account.customer_id where customer.customer_id =");
            queryMap.put("getOverallReport", "select distinct c.customer_name as \"Name\", a.account_number as \"Account Number\", c.vehicle_number as \"Vechicle Number\", a.account_opening_date, a.account_closing_date, a.loan_amount as \"Loan Amount\", sum(t.amount) as \"Received Amount\", case when sum(t.amount)=a.loan_amount then '-' else a.loan_amount-sum(t.amount) end \"Pending\", case t.amount_type when 'Fine' then t.amount else '-' end \"Fine\" from customer c join account a on c.customer_id = a.customer_id join transactions t on t.account_number = a.account_number");
            queryMap.put("getExpensesReport", "select * from expenses");
            queryMap.put("getRecoveryReport", "select distinct c.customer_name as \"Name\", a.account_number as \"Account Number\", c.vehicle_number as \"Vechicle Number\", a.account_opening_date, a.account_closing_date, a.loan_amount as \"Loan Amount\", sum(t.amount) as \"Received Amount\", case when sum(t.amount)=a.loan_amount then '-' else a.loan_amount-sum(t.amount) end \"Pending\", t.amount as \"Recovery\" from customer c join account a on c.customer_id = a.customer_id join transactions t on t.account_number = a.account_number where t.amount_type = \"Recovery\"");
            queryMap.put("getDailyReport", "select distinct c.customer_name as \"Name\", a.account_number as \"Account Number\", t.transaction_date as \"Entry Date\", t.amount as \"Amount\", case t.amount_type when 'Fine' then t.amount else '-' end \"Fine\" from customer c join account a on c.customer_id = a.customer_id join transactions t on t.account_number = a.account_number");
            return queryMap;
        }   
}
