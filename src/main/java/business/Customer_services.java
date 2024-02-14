/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import Database.Customer;
import Database.CustomerDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Ahmed yehia
 */
public class Customer_services {
    static public void SaveCustomer(String First_NameTXT, String Last_NameTXT, String IdTXT, String PhoneTXT,
            String Path, String GenderBOX) throws IOException, FileNotFoundException, SQLException {
        Customer temp=new Customer();
            temp.setFirst_Name(First_NameTXT);
            temp.setLast_Name(Last_NameTXT);
            temp.setId(IdTXT);
            temp.setPhone(PhoneTXT);
            temp.setPhoto(Path);
        temp.setGender(GenderBOX);
     
        CustomerDAO.AdingCustomer(temp);
       
    }
     static public void UpdateCustomer(String First_NameTXT, String Last_NameTXT, String IdTXT, String PhoneTXT,
            String path, String GenderBOX,Customer employee) throws IOException, FileNotFoundException, SQLException {
        Customer temp=new Customer();
            temp.setFirst_Name(First_NameTXT);
            temp.setLast_Name(Last_NameTXT);
            temp.setId(IdTXT);
            temp.setPhone(PhoneTXT);
        if (path.length() > 0) {
            temp.setPhoto(path);
        } else {
            temp.setPhoto(employee.getPhoto());
        }
          temp.setGender(GenderBOX);
        CustomerDAO.UpdateCustomer(temp);
    }
}
