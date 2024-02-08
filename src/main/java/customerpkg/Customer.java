/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customerpkg;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ahmed yehia
 */
public class Customer {
     private String First_Name,Last_Name,
            Id,Gender,Phone;
    private byte[] Photo;
    public Customer(){
        
    }
     public Customer(ResultSet rs) throws SQLException{
        First_Name =rs.getString("First_Name");
        Last_Name=rs.getString("Last_Name");
        Phone =rs.getString("Phone");
        Id =rs.getString("Id");
        Gender =rs.getString("Gender");
        Photo = rs.getBytes("Photo");
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public byte[] getPhoto() {
        return Photo;
    }

    public void setPhoto(byte[] Photo) {
        this.Photo = Photo;
    }
     

}
