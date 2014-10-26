/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Layer;

import Business_Logic_Layer.order;
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
public class orderDataAccesor {
    private Statement stmnt=null;
    private Connection  databaseConnector=null;
    private DatabaseConnector myConnector=new DatabaseConnector();
    private List<order> orderList=new ArrayList();
    private ResultSet dataSet=null;
    private order tempOrder=null;
    String SQLQuery=null;
    
    int orderID=0;
    String supplierName;
    String orderDate;
    String orderInfo;
    float orderAmount;
   
    
    public void insertSupplierData(order tempOrder) throws SQLException{  
        
            try {
                databaseConnector = myConnector.getConnection();
                 
                SQLQuery = "INSERT INTO familydoctor.order "+"VALUES(?,?,?,?,?)";
                PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2, tempOrder.getSupplierName());
                preparedStatement.setString(3, tempOrder.getCurrentDate());
                preparedStatement.setString(4, tempOrder.getOrderInfo());
                preparedStatement.setFloat(5,tempOrder.getOrderAmount());
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
    
    public List<order> retrieveOrderData(String supName) throws SQLException{
        
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.order WHERE supplierName="+"'"+supName+"'";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                orderID=dataSet.getInt("orderID");
                supplierName=dataSet.getString("supplierName");
                orderDate=dataSet.getString("orderDate");
                orderInfo=dataSet.getString("orderInfo");
                orderAmount=dataSet.getFloat("orderAmount");
                tempOrder=new order(orderID,supName, orderDate, orderInfo, orderAmount);
                
                orderList.add(tempOrder);
                
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
        
        return orderList;
    }
    
    public String retrieveOrderInfo(String supName,int orderID) throws SQLException{
        String orderInfo = null;
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT orderInfo FROM familydoctor.order WHERE orderID="+"'"+orderID+"'";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                orderInfo=dataSet.getString("orderInfo");
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
        
        return orderInfo;
    }
    
    public void deleteOrderInfo(int orderID) throws SQLException{
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            SQLQuery="DELETE FROM familydoctor.order WHERE orderID="+"'"+orderID+"'";
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
