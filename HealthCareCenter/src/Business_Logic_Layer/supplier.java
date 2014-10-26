/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic_Layer;

/**
 *
 * @author Ruchi
 */
public class supplier {
    
    private String name;
    private String contactDetails;
    private int phnNo;
    private String mail;
    private float amount;
    
    public supplier(String name,String contactDetails,int phnNo,String mail){
        this.name=name;
        this.contactDetails=contactDetails;
        this.phnNo=phnNo;
        this.mail=mail;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the contactDetails
     */
    public String getContactDetails() {
        return contactDetails;
    }

    /**
     * @return the phnNo
     */
    public int getPhnNo() {
        return phnNo;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @return the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }
    
}
