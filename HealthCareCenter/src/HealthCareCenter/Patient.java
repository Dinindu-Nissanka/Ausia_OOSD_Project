/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HealthCareCenter;

/**
 *
 * @author User
 */
public class Patient {
    
    private String name;
    private String age;
    private String NIC;
    private String gender;
    private String familyName;
    private String contactNo;
    private String specialRemarks;
    
    

    public Patient(String name, String age, String NIC, String familyName,String gender, String contactNo, String specialRemarks) {
        this.name = name;
        this.age = age;
        this.NIC = NIC;
        this.familyName = familyName;
        this.gender = gender;
        this.contactNo = contactNo;
        this.specialRemarks = specialRemarks;
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

    public String getNIC() {
        return NIC;
    }

    public String getName() {
        return name;
    }

    public String getSpecialRemarks() {
        return specialRemarks;
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

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialRemarks(String specialRemarks) {
        this.specialRemarks = specialRemarks;
    }

    
}
