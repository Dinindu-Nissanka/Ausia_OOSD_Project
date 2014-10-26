/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic_Layer;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *
 * @author Ruchi
 */
public class order {
    
    private int orderID;
    private String supplierName;
    private String orderDate;
    private String orderInfo;
    private float orderAmount;
    
    public order(){
        
    }
    
    public order(String supName,String orderDate,String orderinfo,float Amount){
        this.supplierName=supName;
        this.orderDate=orderDate;
        this.orderInfo=orderinfo;
        this.orderAmount=Amount;
    }
    
    public order(int orderID,String supName,String orderDate,String orderinfo,float Amount){
        this.orderID=orderID;
        this.supplierName=supName;
        this.orderDate=orderDate;
        this.orderInfo=orderinfo;
        this.orderAmount=Amount;
    }
    
    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	//get current date time with Date()
	Date date = new Date();
        return dateFormat.format(date);
    }
    public String createOrderString(String supName,String orderDate,String itemName,String itemquantity,String Amount){
        String temp="";
        String element="";
        temp=supName+this.spaceCreater(supName,15)+orderDate+this.spaceCreater(orderDate,15)+itemName+this.spaceCreater(itemName,20)
                +itemquantity+this.spaceCreater(itemquantity,4)+Amount+this.spaceCreater(Amount,7);
        return temp;
    }
    
    public String spaceCreater(String element,int count){
        String space="";
        //if(element.length()<count){
            
            for (int i = 0; i < (count-element.length()); i++) {
                space=space+" ";
            }
            //System.out.println(element+" "+count+" "+element.length()+" "+(count-element.length())+" "+space.length());
        //}
        return space;
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @return the orderInfo
     */
    public String getOrderInfo() {
        return orderInfo;
    }

    /**
     * @return the orderAmount
     */
    public float getOrderAmount() {
        return orderAmount;
    }

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }
    
}
