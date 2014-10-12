/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HealthCareCenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinindu
 */
public class MedicineDataAccessor {
    private Statement stmnt=null;
    private Connection  databaseConnector=null;
    private DatabaseConnector medicineConnector=new DatabaseConnector();
    private List<Medicine> medicineList=new ArrayList();
    private ResultSet dataSet=null;
    private Medicine medicine=null;
    private String SQLQuery=null;
    
    private String medicineName;
    private String medicineBrand;
    private long barcodeNumber;
    private double price;
    private int quantity;
    
    
    public List<Medicine> retrieveStockData() throws SQLException{
        
        try{
            databaseConnector=medicineConnector.getConnection();
            stmnt=databaseConnector.createStatement();
            
            SQLQuery="SELECT * FROM familydoctor.medicine";
            dataSet=stmnt.executeQuery(SQLQuery);
          
            while(dataSet.next()){
                medicineName=dataSet.getString("Medicine_Name");
                medicineBrand=dataSet.getString("Brand_Name");
                barcodeNumber=dataSet.getInt("Barcode_Number");
                price=dataSet.getDouble("Price");
                quantity=dataSet.getInt("Quantity");
                
                medicine=new Medicine(medicineName,medicineBrand,barcodeNumber,price,quantity);
                medicineList.add(medicine);
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
        
        return medicineList;
    }
    /*
    public void print(){
        if(!medicineList.isEmpty()){
            for(Medicine myMedicine : medicineList){
                medicine = myMedicine;
                System.out.println(medicine.getBarcodeNumber()+"    "+medicine.getMedicineName()+"     "+medicine.getMedicineBrand()+"  "+medicine.getPrice()+"     "+medicine.getQuantity());
            }
        }
    }
    */
    public void insertMedicineData(Medicine medicine) throws SQLException{  
        try {
            databaseConnector = medicineConnector.getConnection();
                 
            SQLQuery = "INSERT INTO familydoctor.medicine "+"VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            
            preparedStatement.setLong(1,0);
            preparedStatement.setLong(2, medicine.getBarcodeNumber());
            preparedStatement.setString(3, medicine.getMedicineName());
            preparedStatement.setString(4, medicine.getMedicineBrand());
            preparedStatement.setDouble(5,medicine.getPrice());
            preparedStatement.setInt(6, medicine.getQuantity());
            preparedStatement.executeUpdate(); 
            
        } catch (SQLException e) {
            System.out.println(e.getMessage()+" error");
        } finally {
            if (stmnt != null) {
                stmnt.close();
            }
            if (databaseConnector != null) {
                databaseConnector.close();
            }
        }
    }
    
    public List<Medicine> getMedicineDataFromName(String medicinName) throws SQLException{
        databaseConnector=medicineConnector.getConnection();
        stmnt = databaseConnector.createStatement();
        
        SQLQuery="SELECT * FROM familydoctor.medicine WHERE Medicine_Name = '"+medicinName+"'";
        dataSet=stmnt.executeQuery(SQLQuery);
        while(dataSet.next()){
                medicineName=dataSet.getString("Medicine_Name");
                medicineBrand=dataSet.getString("Brand_Name");
                barcodeNumber=dataSet.getInt("Barcode_Number");
                price=dataSet.getDouble("Price");
                quantity=dataSet.getInt("Quantity");
                
                medicine=new Medicine(medicineName,medicineBrand,barcodeNumber,price,quantity);
                medicineList.add(medicine);
            }
        return medicineList;
    }
}
