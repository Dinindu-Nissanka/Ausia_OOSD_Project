/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Layer;

import Business_Logic_Layer.bank;
import Business_Logic_Layer.supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruchi
 */
public class bankDataAccessor {
    
    private int bankID;
    private String bankName;
    private int accNo;
    private float accBalance;
    
    private Statement stmnt=null;
    private Connection  databaseConnector=null;
    private DatabaseConnector myConnector=new DatabaseConnector();
    private List<bank> bankList=new ArrayList();
    private ResultSet dataSet=null;
    private bank tempBank=null;
    String SQLQuery=null;
    
        public List<String> databaseInfo(String columnName) throws SQLException{
            String temp;
            List<String> bankInfo=new ArrayList();
            try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.bank";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                temp=dataSet.getString(columnName);
                bankInfo.add(temp);
            }
            }
        
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
            finally{
                if(stmnt!=null)
                    stmnt.close();
                if(databaseConnector!=null)
                    databaseConnector.close();
            }
        
        return bankInfo;
        }
    
        public List<bank> retriveBankinfo() throws SQLException{
        
        List<bank> bankInfo=new ArrayList();
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.bank";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                bankID=dataSet.getInt("bankID");
                bankName=dataSet.getString("bankName");
                accNo=dataSet.getInt("accNo");
                accBalance=dataSet.getFloat("accBalance");
                
                tempBank=new bank(bankID, bankName, accNo, accBalance);
                bankInfo.add(tempBank);
            }
        }
        
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        finally{
            if(stmnt!=null)
                stmnt.close();
            if(databaseConnector!=null)
                databaseConnector.close();
        }
        
        return bankInfo;
        }
        
        public float RetrieveBankAccountBalance(String bankName) throws SQLException{
            String temp;
            float amount = 0;
            
            
            try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.bank WHERE bankName="+"'"+bankName+"'";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                amount=dataSet.getFloat("accBalance");
                
            }
            }
        
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
            finally{
                if(stmnt!=null)
                    stmnt.close();
                if(databaseConnector!=null)
                    databaseConnector.close();
            }
            System.out.println("Amount "+amount);
        return amount;
        }
    
        
        public void updateBankAmount(String bankName,float newAmount) throws SQLException{
        
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="UPDATE familydoctor.bank SET accBalance="+newAmount+" WHERE bankName="+"'"+bankName+"'";
            stmnt.executeUpdate(SQLQuery);
          
            
        }
        
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        finally{
            if(stmnt!=null)
                stmnt.close();
            if(databaseConnector!=null)
                databaseConnector.close();
        }
    }
    
}
