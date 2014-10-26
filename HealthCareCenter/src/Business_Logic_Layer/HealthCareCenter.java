/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business_Logic_Layer;

import View_Layer.StartForm;
import View_Layer.login;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Pathum
 */
public class HealthCareCenter {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        // TODO code application logic here
        //StartForm sForm=new StartForm();
        //sForm.setVisible(true);
        //loginPage l=new loginPage();
        //l.connect();
        //l.getPassword();
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        login login1 = new login();
        login1.setVisible(true);
        
        //sForm.setSize(400, 300);   
        
    }
    
}
