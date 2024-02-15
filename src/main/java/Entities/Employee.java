package Entities;

import Services.Validation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ahmed yehia
 */
public class Employee {
    private String Password,First_Name,Last_Name,
            Id,Gender,Phone;
    private byte[] Photo;
    public Employee(){
        
    }
     public Employee(ResultSet rs) throws SQLException{
        Password =rs.getString("password");
        First_Name =rs.getString("First_Name");
        Last_Name=rs.getString("Last_Name");
        Phone =rs.getString("Phone");
        Id =rs.getString("Employee_Id");
        Gender =rs.getString("Gender");
        Photo = rs.getBytes("Photo");
    }

    public String getPassword() {
        return Password;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public String getId() {
        return Id;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public byte[] getPhoto() {
        return Photo;
    }

    public void setPassword(String Password) throws SQLException {
        if(!Validation.Password(Password))
             throw new SQLException("Invalid Password. Please enter a valid Password.");
        this.Password = Password;
    }

    public void setFirst_Name(String First_Name) throws SQLException {
        if(!Validation.Name(First_Name))
             throw new SQLException("Invalid First Name. Please enter a valid First Name.");
        this.First_Name = First_Name;
    }

    public void setLast_Name(String Last_Name) throws SQLException {
         if(!Validation.Name(Last_Name))
             throw new SQLException("Invalid Last Name. Please enter a valid Last Name.");
        this.Last_Name = Last_Name;
    }

    public void setId(String Id) throws SQLException {
         if(!Validation.Number(Id))
             throw new SQLException("Invalid Id. Please enter a valid Id.");
        this.Id = Id;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setPhone(String Phone) throws SQLException {
         if(!Validation.Phone(Phone))
             throw new SQLException("Invalid phone. Please enter a valid phone.");
        this.Phone = Phone;
    }

    public void setPhoto(byte[] Photo) {
        this.Photo = Photo;
    }
    public void setPhoto(String s) throws SQLException {
        if (!Validation.Photo(s)) {
            throw new SQLException("Invalid Path. Please enter a valid Path.");
        }
        try {
            File file = new File(s);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            this.Photo = data;
        } catch (FileNotFoundException ex) {
            throw new SQLException("Invalid Path. Please enter a valid Path.");
        } catch (IOException ex) {
            throw new SQLException("Invalid Path. Please enter a valid Path.");
        }

    }

    
}
