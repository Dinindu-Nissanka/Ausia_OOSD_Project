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
public class login {
    private String userName;
    private String password;
    private String actualPassword;
    
    public login(String userName,String Password){
        this.userName=userName;
        this.password=Password;
    }
    
    public boolean validate(){
        if(this.getPassword().equals(this.getActualPassword())){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the actualPassword
     */
    public String getActualPassword() {
        return actualPassword;
    }

    /**
     * @param actualPassword the actualPassword to set
     */
    public void setActualPassword(String actualPassword) {
        this.actualPassword = actualPassword;
    }
}
