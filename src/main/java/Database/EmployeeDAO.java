package Database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ahmed yehia
 */
public class EmployeeDAO extends ConnectDB{
    
    static public Connection myconnection;

    public EmployeeDAO() throws FileNotFoundException, IOException, SQLException{
        myconnection=EmployeeDAO.getConnect();
    }

  static public void DeleteEmploye(String Id) throws SQLException, IOException{
        myconnection=EmployeeDAO.getConnect();
       PreparedStatement statement = null;
        try {
            statement=myconnection.prepareStatement("delete from Employee where Employee_Id=?");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        statement.setString(1, Id);
        statement.executeQuery();
               
   }
   static public ArrayList<Employee> Search(String s) throws SQLException, IOException{
        myconnection=EmployeeDAO.getConnect();
        ArrayList<Employee> lst;
        lst = new ArrayList<>();
        String[] name=s.split(" ");
         PreparedStatement statement;
        ResultSet result;
        if(name.length==1){
        s="%"+s+"%";
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
        }
        else {
            name[0]="%"+name[0]+"%";
            name[1]="%"+name[1]+"%";
        statement = myconnection.prepareStatement("select * from Employee where First_Name like ? and Last_Name like ?");
        statement.setString(1, name[0]);
        statement.setString(2, name[1]);
        }
        result=statement.executeQuery();
        while(result.next()){
            Employee temp=new Employee(result);
            lst.add(temp);
        }
        statement.close();
        
        return lst;
        
    }
    static public void AdingEmployee(Employee employee) throws SQLException, IOException{
        myconnection=EmployeeDAO.getConnect();
        PreparedStatement statement;
        statement = myconnection.prepareStatement("insert into Employee (First_Name, Last_Name, Employee_Id,"
                + " Photo, Phone, Gender, Password) values ('"+employee.getFirst_Name()+"',"
                        + " '"+employee.getLast_Name()+"','"+employee.getId()+"', ?, '"+employee.getPhone()+"', '"+employee.getGender()+"', '"+employee.getPassword()+"')");
        statement.setBytes(1, employee.getPhoto());
        statement.executeUpdate();
        statement.close();
    }
   static public void UpdateEmployee(Employee employee) throws SQLException, IOException{
       myconnection=EmployeeDAO.getConnect();
        PreparedStatement statement;
        statement = myconnection.prepareStatement("update Employee "
                + "set First_Name='"+employee.getFirst_Name()+"', Last_Name='"+employee.getLast_Name()+"',"
                + " Photo = ? , Phone = '"+employee.getPhone()+"', Gender ='"+employee.getGender()+"' , Password = '"+employee.getPassword()+"' where Employee_Id='"+employee.getId()+"'");
        statement.setBytes(1, employee.getPhoto());
        statement.executeUpdate();
        statement.close();
    }
    static public ArrayList<Employee> get(String s) throws SQLException, IOException{
        myconnection=EmployeeDAO.getConnect();
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
    static public boolean checkPassword(String id,String pass) throws SQLException, IOException{
        
        ArrayList<Employee> temp=EmployeeDAO.get(id);
        return !(temp.size()!=1 || !temp.get(0).getPassword().equals(pass));
    }
   
}
