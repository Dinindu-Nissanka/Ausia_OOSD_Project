/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Layer;

import Business_Logic_Layer.bank;
import Business_Logic_Layer.cheque;
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
public class chequeDataAccessor {
    private Statement stmnt=null;
    private Connection  databaseConnector=null;
    private DatabaseConnector myConnector=new DatabaseConnector();
    private List<cheque> orderList=new ArrayList();
    private ResultSet dataSet=null;
    private cheque tempCheque=null;
    String SQLQuery=null;
    
    private int chequeID;
    private String bankName;
    private float chequeAmount;
    private String inputDate;
    private int year;
    private int month;
    private int date;
    
    public void insertChequeData(cheque inputCheque) throws SQLException{  
        
            try {
                databaseConnector = myConnector.getConnection();
                 
                SQLQuery = "INSERT INTO familydoctor.cheque "+"VALUES(?,?,?,?)";
                PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2, inputCheque.getBankName());
                preparedStatement.setString(3, inputCheque.getInputDate());
                preparedStatement.setFloat(4, inputCheque.getChequeAmount());
             
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
    
    public List<cheque> retriveChequeinfo() throws SQLException{
        
        List<cheque> chequeInfo=new ArrayList();
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.cheque";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                chequeID=dataSet.getInt("chequeID");
                bankName=dataSet.getString("bankName");
                inputDate=dataSet.getString("chequeDate");
                chequeAmount=dataSet.getFloat("chequeAmount");
                
                tempCheque=new cheque(chequeID,bankName, inputDate, chequeAmount);
                
                chequeInfo.add(tempCheque);
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
        
        return chequeInfo;
        }
    
    public void deleteCheque(int chequeID) throws SQLException{
        try{
            databaseConnector=myConnector.getConnection();
            stmnt=(Statement) databaseConnector.createStatement();
            SQLQuery="DELETE FROM familydoctor.cheque WHERE chequeID="+"'"+chequeID+"'";
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
