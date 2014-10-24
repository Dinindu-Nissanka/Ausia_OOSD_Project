
package Business_Logic_Layer;

/**
 *
 * @author Dinindu
 */
public class Medicine {
    private String medicineName;
    private String medicineBrand;
    private long barcodeNumber;
    private double price;
    private int quantity;
    private String supplier;

    public Medicine(String medicineName, String medicineBrand, long barcodeNumber, double price, int quantity,String supplier) {
        this.medicineName = medicineName;
        this.medicineBrand = medicineBrand;
        this.barcodeNumber = barcodeNumber;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineBrand() {
        return medicineBrand;
    }

    public void setMedicineBrand(String medicineBrand) {
        this.medicineBrand = medicineBrand;
    }

    public long getBarcodeNumber() {
        return barcodeNumber;
    }

    public void setBarcodeNumber(long barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
