/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic_Layer;
import Data_Access_Layer.chequeDataAccessor;
import Data_Access_Layer.bankDataAccessor;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruchi
 */
public class chequeTableUpdate {
    chequeDataAccessor newChequeData=new chequeDataAccessor();
    bankDataAccessor newBankData=new bankDataAccessor();
    List<cheque> chequeList=new ArrayList();
    String current;
    
    public void getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	//get current date time with Date()
	Date date = new Date();
        current= dateFormat.format(date);
        System.out.println(current);
    }
    
    public chequeTableUpdate() {
        try {
            chequeList=newChequeData.retriveChequeinfo();
        } catch (SQLException ex) {
            Logger.getLogger(chequeTableUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getCurrentDate();
    }
    
    public void checkAndUpdate(){
        for (int i = 0; i < chequeList.size(); i++) {
            if(chequeList.get(i).chequeDateCheck(current)){
                
            }
            else{
                try {
                    newBankData.updateBankAmount(chequeList.get(i).getBankName(),newBankData.RetrieveBankAccountBalance(chequeList.get(i).getBankName())-chequeList.get(i).getChequeAmount());
                    newChequeData.deleteCheque(i);
                } catch (SQLException ex) {
                    Logger.getLogger(chequeTableUpdate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
