/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ahmed yehia
 */
public class TransactionDAO extends ConnectDB{
      static public Connection myconnection;
   
    
    public TransactionDAO() throws FileNotFoundException, IOException, SQLException{
      myconnection=TransactionDAO.getConnect();
    }
    
   static public void Save_Transaction(Transaction transaction) throws SQLException, IOException{
         myconnection=TransactionDAO.getConnect();
          PreparedStatement statement;
        statement = myconnection.prepareStatement("insert into Transactions (Book_Id,Employee_Id,Customer_Id,Date) values (?, ?, ?, ?)");
        statement.setInt(1, transaction.getBook_Id());
        statement.setString(2, transaction.getEmployee_Id());
        statement.setString(3, transaction.getCustomer_Id());
        statement.setDate(4, transaction.getDate());
        statement.executeUpdate();
        statement.close();
    }
    static public ArrayList<Transaction>Search(int s) throws SQLException, IOException{
         myconnection=TransactionDAO.getConnect();
        ArrayList<Transaction> lst;
        lst = new ArrayList<>();
        PreparedStatement statement;
        ResultSet result,res;
        
        statement = myconnection.prepareStatement("select * from Transactions where"
                + " Book_Id = ?");
     
        statement.setInt(1, s);
        result=statement.executeQuery();
        while(result.next()){
            Transaction temp=new Transaction(result);
            lst.add(temp);
        }
     
        return lst;
        
    }
    
    static public boolean is_record_found(int Book_Id,String Customer_Id) throws SQLException, IOException{
          myconnection=TransactionDAO.getConnect();
           PreparedStatement statement;
                   ResultSet result;
        statement = myconnection.prepareStatement("select COUNT(*) AS cnt from Transactions where Book_Id = ? and Customer_Id = ? ");
         statement.setInt(1, Book_Id);
        statement.setString(2,Customer_Id);
        result=statement.executeQuery();
         if(result.next()){
             if(result.getInt("cnt")!=1)return false;
         }
         return true;
       }
    static public int delete(int Book_Id,String Customer_Id) throws SQLException, IOException{
          myconnection=TransactionDAO.getConnect();
           PreparedStatement statement;
           
        statement = myconnection.prepareStatement("delete from Transactions where Book_Id = ? and Customer_Id = ? ");
        statement.setInt(1, Book_Id);
        statement.setString(2,Customer_Id);
        statement.executeUpdate();
        statement = myconnection.prepareStatement("SELECT DATEDIFF(day, GETDATE(), date) AS difference_in_days " +
"FROM Transactions");
        ResultSet result=statement.executeQuery();
         if(result.next()){
             return result.getInt("difference_in_days");
         }
        return -1;      
     }
     
     static public void UpdateBook(Book book) throws SQLException, IOException{
           myconnection=TransactionDAO.getConnect();
        PreparedStatement statement;
        statement = myconnection.prepareStatement("update Book "
                + "set Title='"+book.getTitle()+"', Author='"+book.getAuthor()+"', Language='" + book.getLanguage() + "',"
                + " Photo = ? ,No_Of_Pages=? , No_Of_Copies = ?,Loan_Period = ? where Id=?");
        statement.setBytes(1, book.getPhoto());
        statement.setInt(2, book.getNo_Of_Pages());
        statement.setInt(3, book.getNo_Of_Copies());
        statement.setInt(4, book.getLoan_Period());
        statement.setInt(5, book.getId());
        statement.executeUpdate();
    }
      
}
