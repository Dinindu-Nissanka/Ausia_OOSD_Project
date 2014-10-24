
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business_Logic_Layer;

/**
 *
 * @author User
 */
public class Patient {
    
    private String name;
    private String age;
    private String ID;
    private String gender;
    private String familyName;
    private String contactNo;
   // private String specialRemarks;
    
    

    public Patient(String name, String age, String ID, String familyName,String gender, String contactNo) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.familyName = familyName;
        this.gender = gender;
        this.contactNo = contactNo;
  //      this.specialRemarks = specialRemarks;
    }

    public String getAge() {
        return age;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGender() {
        return gender;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }


    public void setAge(String age) {
        this.age = age;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setGender(String geder) {
        this.gender = geder;
    }

    public void setID(String NIC) {
        this.ID = NIC;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
