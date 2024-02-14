/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import business.Validation;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ahmed yehia
 */
public class Transaction {
    int Transaction_Id,Book_Id;
    String Customer_Id,Employee_Id;
    Date date;
    
    public Transaction(){
        
    }
    public Transaction(ResultSet rs) throws SQLException{
         Customer_Id =rs.getString("Customer_Id");
        Employee_Id=rs.getString("Employee_Id");
        Transaction_Id =rs.getInt("Transaction_Id");
        Book_Id =rs.getInt("Book_Id");
        date=rs.getDate("date");
    }

    public int getTransaction_Id() {
        return Transaction_Id;
    }
    public int getBook_Id() {
        return Book_Id;
    }

    public void setBook_Id(int Book_Id) throws SQLException, IOException {
        
        if (!Validation.Number(Book_Id + "")) {
            throw new SQLException("Invalid ISBN. Please enter a valid ISBN.");
        }
        ArrayList<Book> lst = BookDAO.returnBookWithIdS(Book_Id+"");
        if (lst.isEmpty() ||lst.get(0).getNo_Of_Copies() == 0 ) {
            throw new SQLException( "Book with ISBN " + Book_Id + " not found.");
        }
        
        this.Book_Id = Book_Id;
    }

    public String getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(String Customer_Id) throws SQLException, IOException {
         if (!Validation.Number(Customer_Id)){
             throw new SQLException("Invalid Customer Id Please enter a valid Customer Id.");
         }
          ArrayList<Customer> lst = CustomerDAO.returnCustomerWithIdS(Customer_Id+"");
        if (lst.isEmpty()) {
            throw new SQLException( "Customer with Id " + Customer_Id + " has'nt Membership.");
        }
        this.Customer_Id = Customer_Id;
    }

    public String getEmployee_Id() {
        return Employee_Id;
    }

    public void setEmployee_Id(String Employee_Id) {
        this.Employee_Id = Employee_Id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
