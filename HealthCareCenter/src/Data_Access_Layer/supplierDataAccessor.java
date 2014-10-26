/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Layer;
import Business_Logic_Layer.Patient;
import Business_Logic_Layer.supplier;
import Data_Access_Layer.DatabaseConnector;
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
public class supplierDataAccessor {
    
    private Statement stmnt=null;
    private Connection  databaseConnector=null;
    private DatabaseConnector myConnector=new DatabaseConnector();
    private List<supplier> supplierList=new ArrayList();
    private ResultSet dataSet=null;
    private supplier tempSupplier=null;
    String SQLQuery=null;
    
    String name;
    String contactDetails;
    int phnNo;
    String mail;
    float amount;
    
    
    public List<supplier> retrieveSupplierData() throws SQLException{
        
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.supplier";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                name=dataSet.getString("Name");
                contactDetails=dataSet.getString("ContactDetails");
                phnNo=dataSet.getInt("phnNo");
                mail=dataSet.getString("mail");
                amount=dataSet.getFloat("Amount");
                tempSupplier=new supplier(name, contactDetails, phnNo, mail);
                tempSupplier.setAmount(amount);
                supplierList.add(tempSupplier);
                
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
        
        return supplierList;
    }
    
    
    public void insertSupplierData(supplier tempSupplier) throws SQLException{  
        
            try {
                databaseConnector = myConnector.getConnection();
                 
                SQLQuery = "INSERT INTO familydoctor.supplier "+"VALUES(?,?,?,?,?)";
                PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            
                preparedStatement.setString(1, tempSupplier.getName());
                preparedStatement.setString(2, tempSupplier.getContactDetails());
                preparedStatement.setInt(3, tempSupplier.getPhnNo());
                preparedStatement.setString(4, tempSupplier.getMail());
                preparedStatement.setFloat(5,0);
                preparedStatement.executeUpdate(); 
            
            } 
            catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
          
            finally {
                if (stmnt != null) {
                    stmnt.close();
                }
                if (databaseConnector != null) {
                    databaseConnector.close();
                }
            }
    }
    
    public void insertSupplierAmount(supplier tempSupplier) throws SQLException{  
        
            try {
                databaseConnector = myConnector.getConnection();
                 
                SQLQuery = "INSERT INTO familydoctor.supplier "+"VALUES(?,?,?,?)";
                PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            
                preparedStatement.setString(1, tempSupplier.getName());
                preparedStatement.setString(2, tempSupplier.getContactDetails());
                preparedStatement.setInt(3, tempSupplier.getPhnNo());
                preparedStatement.setString(4, tempSupplier.getMail());
                preparedStatement.executeUpdate(); 
            
            } 
            catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
          
            finally {
                if (stmnt != null) {
                    stmnt.close();
                }
                if (databaseConnector != null) {
                    databaseConnector.close();
                }
            }
    }
    
    public supplier browseSupplier(String supplierName) throws SQLException{
        supplier searchedSupplier=null;
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
        
            SQLQuery="SELECT * FROM familydoctor.supplier WHERE Name="+"'"+supplierName+"'";
            
            System.out.println(SQLQuery);
            dataSet=stmnt.executeQuery(SQLQuery);
            
            while(dataSet.next()){
                name=dataSet.getString("Name");
                contactDetails=dataSet.getString("ContactDetails");
                phnNo=dataSet.getInt("phnNo");
                mail=dataSet.getString("mail");
                amount= dataSet.getFloat("Amount");
                searchedSupplier=new supplier(name, contactDetails, phnNo, mail);
                searchedSupplier.setAmount(amount);
                
            }
            
  
        }
        
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        finally {
            if (stmnt != null) {
                stmnt.close();
            }
            if (databaseConnector != null) {
                databaseConnector.close();
            }
        }
        
        return searchedSupplier; //return the raws as a resultSet
    }
    
    public List<String> databaseInfo(String columnName) throws SQLException{
        
        List<String> supplierInfo=new ArrayList();
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.supplier";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                name=dataSet.getString(columnName);
                supplierInfo.add(name);
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
        
        return supplierInfo;
    }
    
    public List<String> databaseMedicineInfo(String columnName) throws SQLException{
        
        List<String> medicineName=new ArrayList();
        List<Float> medicinePrice=new ArrayList();
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.medicine";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                name=dataSet.getString(columnName);
                medicineName.add(name);
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
        
        return medicineName;
    }
    
    public List<Float> databaseMedicinePrices(String columnName) throws SQLException{
        
        //List<String> medicineName=new ArrayList();
        float amount=0;
        List<Float> medicinePrice=new ArrayList();
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.medicine";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                amount=dataSet.getFloat("Price");
                medicinePrice.add(amount);
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
        
        return medicinePrice;
    }
    
    public float retrieveSupplierAmount(String supName) throws SQLException{
        float getAmount = 0;
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT Amount FROM familydoctor.supplier WHERE Name="+"'"+supName+"'";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                getAmount=dataSet.getFloat("Amount");
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
        
        return getAmount;
    }
}
