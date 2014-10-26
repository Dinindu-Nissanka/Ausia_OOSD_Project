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
public class cheque {
    private int chequeID;
    private String bankName;
    private float chequeAmount;
    private String inputDate;
    private int year;
    private int month;
    private int date;
    private int currentYear;
    private int currentMonth;
    private int currentDate;
    
    
    public cheque(int chequeID,String bankName,String inputDate,float amoount){
        this.bankName=bankName;
        this.inputDate=inputDate;
        this.chequeAmount=amoount;
        this.chequeID=chequeID;
        this.dateSplit(inputDate);
    }
    
    public cheque(String bankName,String inputDate,float amoount){
        this.bankName=bankName;
        this.inputDate=inputDate;
        this.chequeAmount=amoount;
        this.dateSplit(inputDate);
    }
    
    public void dateSplit(String datein){
        String temp[];
        temp=datein.split("/");
        year=Integer.parseInt(temp[0].trim());
        month=Integer.parseInt(temp[1].trim());
        date=Integer.parseInt(temp[2].trim());
    }
    
    public void currentDateSplit(String datein){
        String temp[];
        temp=datein.split("/");
        currentYear=Integer.parseInt(temp[0].trim());
        currentMonth=Integer.parseInt(temp[1].trim());
        currentDate=Integer.parseInt(temp[2].trim());
    }
    
    public boolean chequeDateCheck(String currentDate){
        this.currentDateSplit(currentDate);
        if(year>=this.currentYear){
            if(month>=this.currentMonth){
                if(date>=this.currentDate){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return the chequeID
     */
    public int getChequeID() {
        return chequeID;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @return the chequeAmount
     */
    public float getChequeAmount() {
        return chequeAmount;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @return the date
     */
    public int getDate() {
        return date;
    }

    /**
     * @return the inputDate
     */
    public String getInputDate() {
        return inputDate;
    }
}
