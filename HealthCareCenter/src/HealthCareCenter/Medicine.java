
package HealthCareCenter;

/**
 *
 * @author Dinindu
 */
public class Medicine {
    private String medicineName;
    private String medicineBrand;
    private int barcodeNumber;
    private double price;
    private int quantity;

    public Medicine(String medicineName, String medicineBrand, int barcodeNumber, double price, int quantity) {
        this.medicineName = medicineName;
        this.medicineBrand = medicineBrand;
        this.barcodeNumber = barcodeNumber;
        this.price = price;
        this.quantity = quantity;
    }
    
    public void Update(){
    }
    
    public void MonthlyReport(){
    }
    
    public void Search(){
    }
    
}
