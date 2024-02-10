/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Master;

import Book.Book;
import Transaction.Transaction;
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
      private Connection myconnection;
   
    
    public TransactionDAO() throws FileNotFoundException, IOException, SQLException{
      myconnection=TransactionDAO.getConnect();
    }
    
    public void Save_Transaction(Transaction transaction) throws SQLException{
          PreparedStatement statement;
        statement = myconnection.prepareStatement("insert into Transactions (Book_Id,Employee_Id,Customer_Id,Date) values (?, ?, ?, ?)");
        statement.setInt(1, transaction.getBook_Id());
        statement.setString(2, transaction.getEmployee_Id());
        statement.setString(3, transaction.getCustomer_Id());
        statement.setDate(4, transaction.getDate());
        statement.executeUpdate();
        statement.close();
    }
     public ArrayList<Book>Search(String s) throws SQLException{
        
        ArrayList<Book> lst;
        lst = new ArrayList<>();
        PreparedStatement statement;
        ResultSet result,res;
        
         statement = myconnection.prepareStatement("select COUNT(*) AS cnt from Book where Id = ?");
         statement.setInt(1, Integer.parseInt(s));
         res=statement.executeQuery();
         if(res.next()){
             if(res.getInt("cnt")!=1)return lst;
         }
        statement = myconnection.prepareStatement("select * from Book where"
                + " Id = ?");
     
        statement.setInt(1, Integer.parseInt(s));
        result=statement.executeQuery();
        while(result.next()){
            Book temp=new Book(result);
            lst.add(temp);
        
        }
     
        return lst;
        
    }
     public boolean is_record_found(int Book_Id,String Customer_Id) throws SQLException{
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
     public int delete(int Book_Id,String Customer_Id) throws SQLException{
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
     
      public void UpdateBook(Book book) throws SQLException{
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
