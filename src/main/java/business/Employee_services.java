/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import Database.Employee;
import Database.EmployeeDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed yehia
 */
public class Employee_services {
    static public void SaveEmployee(String First_NameTXT, String Last_NameTXT, String IdTXT, String PasswordTXT, String PhoneTXT,
            String Path, String GenderBOX) throws IOException, FileNotFoundException, SQLException {
        Employee temp=new Employee();
            temp.setFirst_Name(First_NameTXT);
            temp.setLast_Name(Last_NameTXT);
            temp.setId(IdTXT);
            temp.setPassword(PasswordTXT);
            temp.setPhone(PhoneTXT);
            temp.setPhoto(Path);
        temp.setGender(GenderBOX);
     
        EmployeeDAO.AdingEmployee(temp);
       
    }
    static public void UpdateEmployee(String First_NameTXT, String Last_NameTXT, String IdTXT, String PasswordTXT, String PhoneTXT,
            String path, String GenderBOX,Employee employee) throws IOException, FileNotFoundException, SQLException {
        Employee temp=new Employee();
            temp.setFirst_Name(First_NameTXT);
            temp.setLast_Name(Last_NameTXT);
            temp.setId(IdTXT);
            temp.setPassword(PasswordTXT);
            temp.setPhone(PhoneTXT);
        if (path.length() > 0) {
            temp.setPhoto(path);
        } else {
            temp.setPhoto(employee.getPhoto());
        }
          temp.setGender(GenderBOX);
        EmployeeDAO.UpdateEmployee(temp);
    }
    
}
