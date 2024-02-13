package Employee;

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

    public void setPassword(String Password) {
        
        this.Password = Password;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setPhoto(byte[] Photo) {
        this.Photo = Photo;
    }
    
}
