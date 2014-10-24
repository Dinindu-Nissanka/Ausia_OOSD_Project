

package Business_Logic_Layer;

import Data_Access_Layer.MedicineDataAccessor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinindu
 */
public class MedicineBusinessLogic {
    private String medicineName;
    private String medicineBrand;
    private long barcodeNumber;
    private double price;
    private int quantity;
    private String supplier;
    private Medicine medicine=null;
    private List<Medicine> medicineList=new ArrayList();
    
    public List<Medicine> retrieveStockData() throws SQLException{
        MedicineDataAccessor medicineAccessor = new MedicineDataAccessor();
        ResultSet dataSet = medicineAccessor.retrieveStockData();
        while(dataSet.next()){
                medicineName=dataSet.getString("Medicine_Name");
                medicineBrand=dataSet.getString("Brand_Name");
                barcodeNumber=dataSet.getInt("Barcode_Number");
                price=dataSet.getDouble("Price");
                quantity=dataSet.getInt("Quantity");
                supplier = dataSet.getString("Supplier");
                
                medicine=new Medicine(medicineName,medicineBrand,barcodeNumber,price,quantity,supplier);
                medicineList.add(medicine);
            }
        return medicineList;
    }
    
    public void insertMedicine(String medicineName, String medicineBrand, long barcodeNumber, double price, int quantity,String supplier) throws SQLException{
        medicine = new Medicine(medicineName,medicineBrand,barcodeNumber,price,quantity,supplier);
        MedicineDataAccessor medicineAccessor = new MedicineDataAccessor();
        medicineAccessor.insertMedicineData(medicine);
    }
}
