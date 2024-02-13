package Database;

import Employee.Employee;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.util.Base64;
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 *
 * @author Ahmed yehia
 */
public class EmployeeDAO extends ConnectDB{
    
    private Connection myconnection;

    public EmployeeDAO() throws FileNotFoundException, IOException, SQLException{
        myconnection=EmployeeDAO.getConnect();
    }

   public void DeleteEmploye(String Id) throws SQLException{
       PreparedStatement statement = null;
        try {
            statement=myconnection.prepareStatement("delete from Employee where Employee_Id=?");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        statement.setString(1, Id);
        statement.executeQuery();
               
   }
    public ArrayList<Employee> Search(String s) throws SQLException{
        
        ArrayList<Employee> lst;
        lst = new ArrayList<>();
        s="%"+s+"%";
        PreparedStatement statement;
        ResultSet result;
        if(s.length()>2){
        statement = myconnection.prepareStatement("select * from Employee where First_Name like ? or Last_Name like ? or"
                + " Employee_Id like ?");
        statement.setString(1, s);
        statement.setString(2, s);
        statement.setString(3, s);
        }
        else {
            statement = myconnection.prepareStatement("select * from Employee");
        }
        result=statement.executeQuery();
        while(result.next()){
            Employee temp=new Employee(result);
            lst.add(temp);
        }
        statement.close();
        return lst;
        
    }
    public void AdingEmployee(Employee employee) throws SQLException{
        PreparedStatement statement;
        statement = myconnection.prepareStatement("insert into Employee (First_Name, Last_Name, Employee_Id,"
                + " Photo, Phone, Gender, Password) values ('"+employee.getFirst_Name()+"',"
                        + " '"+employee.getLast_Name()+"','"+employee.getId()+"', ?, '"+employee.getPhone()+"', '"+employee.getGender()+"', '"+employee.getPassword()+"')");
        statement.setBytes(1, employee.getPhoto());
        statement.executeUpdate();
        statement.close();
    }
    public void UpdateEmployee(Employee employee) throws SQLException{
        PreparedStatement statement;
        statement = myconnection.prepareStatement("update Employee "
                + "set First_Name='"+employee.getFirst_Name()+"', Last_Name='"+employee.getLast_Name()+"',"
                + " Photo = ? , Phone = '"+employee.getPhone()+"', Gender ='"+employee.getGender()+"' , Password = '"+employee.getPassword()+"' where Employee_Id='"+employee.getId()+"'");
        statement.setBytes(1, employee.getPhoto());
        statement.executeUpdate();
        statement.close();
    }
     public ArrayList<Employee> get(String s) throws SQLException{
        
        ArrayList<Employee> lst;
        lst = new ArrayList<>();
        PreparedStatement statement;
        ResultSet result;
        
        statement = myconnection.prepareStatement("select * from Employee where "
                + " Employee_Id = ?");
        statement.setString(1, s);
     
        result=statement.executeQuery();
        while(result.next()){
            Employee temp=new Employee(result);
            lst.add(temp);
        }
        statement.close();
        return lst;
        
    }
    public boolean checkPassword(String id,String pass) throws SQLException{
        ArrayList<Employee> temp=get(id);
        return !(temp.size()!=1 || !temp.get(0).getPassword().equals(pass));
    }
    private static String encrypt(String data, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decrypt(String encryptedData, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
}
