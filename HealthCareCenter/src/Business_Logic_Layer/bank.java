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
public class bank {
    private int bankID;
    private String bankName;
    private int accNo;
    private float accBalance;
    
    public bank(int ID,String bankName,int accNo,float accBlance){
        this.bankID=ID;
        this.bankName=bankName;
        this.accNo=accNo;
        this.accBalance=accBlance;
    }

    /**
     * @return the bankID
     */
    public int getBankID() {
        return bankID;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @return the accNo
     */
    public int getAccNo() {
        return accNo;
    }

    /**
     * @return the accBalance
     */
    public float getAccBalance() {
        return accBalance;
    }
    
}
