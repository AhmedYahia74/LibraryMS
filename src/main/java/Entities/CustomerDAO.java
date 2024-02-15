/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Ahmed yehia
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ahmed yehia
 */
public class CustomerDAO extends ConnectDB{
    
    static public Connection myconnection;
   
    
    public CustomerDAO() throws FileNotFoundException, IOException, SQLException{
        
        myconnection=CustomerDAO.getConnect();
    }

  static public void DeleteCustomer(String Id) throws SQLException, IOException{
      myconnection=CustomerDAO.getConnect();
       PreparedStatement statement = null;
        try {
            statement=myconnection.prepareStatement("delete from Customer where Id=?");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        statement.setString(1, Id);
        statement.executeQuery();
               
   }
  static public ArrayList<Customer>returnCustomerWithIdS(String s) throws SQLException, IOException{
         myconnection=CustomerDAO.getConnect();
        ArrayList<Customer> lst;
        lst = new ArrayList<>();
        PreparedStatement statement;
        ResultSet result,res;
        
         statement = myconnection.prepareStatement("select COUNT(*) AS cnt from Customer where Id = ?");
         statement.setString(1, s);
         res=statement.executeQuery();
         if(res.next()){
             if(res.getInt("cnt")!=1)return lst;
         }
        statement = myconnection.prepareStatement("select * from Customer where"
                + " Id = ?");
     
        statement.setString(1, s);
        result=statement.executeQuery();
        while(result.next()){
            Customer temp=new Customer(result);
            lst.add(temp);
        }
     
        return lst;
        
    }
    static public ArrayList<Customer>Search(String s) throws SQLException, IOException{
        myconnection=CustomerDAO.getConnect();
        ArrayList<Customer> lst;
        lst = new ArrayList<>();
        s="%"+s+"%";
        PreparedStatement statement;
        ResultSet result;
        if(s.length()>2){
        statement = myconnection.prepareStatement("select * from Customer where First_Name like ? or Last_Name like ? or"
                + " Id like ?");
        statement.setString(1, s);
        statement.setString(2, s);
        statement.setString(3, s);
        }
        else {
            statement = myconnection.prepareStatement("select * from Customer");
        }
        result=statement.executeQuery();
        while(result.next()){
            Customer temp=new Customer(result);
            lst.add(temp);
        }
        statement.close();
        return lst;
        
    }
    static public void AdingCustomer(Customer customer) throws SQLException, IOException{
        myconnection=CustomerDAO.getConnect();
        PreparedStatement statement;
        statement = myconnection.prepareStatement("insert into Customer (First_Name, Last_Name, Id,"
                + " Photo, Phone, Gender) values ('"+customer.getFirst_Name()+"',"
                        + " '"+customer.getLast_Name()+"','"+customer.getId()+"', ?, '"+customer.getPhone()+"', '"+customer.getGender()+"')");
        statement.setBytes(1, customer.getPhoto());
        statement.executeUpdate();
        statement.close();
    }
    static public void UpdateCustomer(Customer customer) throws SQLException, IOException{
        myconnection=CustomerDAO.getConnect();
        PreparedStatement statement;
        statement = myconnection.prepareStatement("update Customer "
                + "set First_Name='"+customer.getFirst_Name()+"', Last_Name='"+customer.getLast_Name()+"',"
                + " Photo = ? , Phone = '"+customer.getPhone()+"', Gender ='"+customer.getGender()+"' where Id='"+customer.getId()+"'");
        statement.setBytes(1, customer.getPhoto());
        statement.executeUpdate();
        statement.close();
    }
   
}
