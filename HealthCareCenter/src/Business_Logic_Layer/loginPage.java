/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business_Logic_Layer;

import Data_Access_Layer.LoginPageAccessor;
import View_Layer.login;
import java.sql.ResultSet;
import java.sql.SQLException;


public class loginPage {
    private String userName="testing";
    private String password="testing pass";
    
    LoginPageAccessor login1=new LoginPageAccessor();
    
    public void start() throws SQLException{
        System.out.println("starting");
        ResultSet dataset = login1.retrieveLoginPageData();
        
        while(dataset.next()){
            //userName=dataset.getString("UserName");
            System.out.println("Username "+userName);
            //password=dataset.getString("Password");
            System.out.println("Password "+password);
        }
        //System.out.println("Username "+userName);
        //System.out.println("Password "+password);
    }
    public boolean getPassword(String temp){
        
        if(temp==password){
            
            return true;
        }
        else 
            return false;
    }
    public boolean getUserName(String temp){
        if(temp==userName){
            return true;
        }
        else
            return false;
    }
}