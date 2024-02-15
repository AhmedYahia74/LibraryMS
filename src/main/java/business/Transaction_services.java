/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import Database.Book;
import Database.BookDAO;
import Database.Customer;
import Database.CustomerDAO;
import Database.Transaction;
import Database.TransactionDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ahmed yehia
 */
public class Transaction_services {

    static public void Borrow_a_book(String Book_IdTXT, String Customer_IdTXT, String Employee_Id) throws SQLException, IOException {

        Transaction t = new Transaction();
        t.setBook_Id(Integer.parseInt(Book_IdTXT));
        t.setCustomer_Id(Customer_IdTXT);
        if (TransactionDAO.is_record_found(Integer.parseInt(Book_IdTXT), Customer_IdTXT)) {
            throw new SQLException("Sorry, you have already borrowed this book.", "Error");
        }

        t.setEmployee_Id(Employee_Id);
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        t.setDate(currentDate);

        TransactionDAO.Save_Transaction(t);
        ArrayList<Book> lst = BookDAO.returnBookWithIdS(Book_IdTXT);
        lst.get(0).setNo_Of_Copies(lst.get(0).getNo_Of_Copies() - 1);
        TransactionDAO.UpdateBook(lst.get(0));
    }

    static public int delete_record(String Book_IdTXT, String Customer_IdTXT, String Employee_Id) throws SQLException, IOException, Exception {

        if (!Validation.Number(Book_IdTXT)) {
            throw new SQLException("Invalid ISBN. Please enter a valid ISBN.");
        }
        ArrayList<Book> lst = BookDAO.returnBookWithIdS(Book_IdTXT);
        if (lst.size() == 0) {
            throw new SQLException("Book with ID " + Book_IdTXT + " not found.");
        }

        // is customer has membership?
        if (!Validation.Number(Customer_IdTXT)) {
            throw new SQLException("Invalid Customer Id Please enter a valid Customer Id.");
        }
        ArrayList<Customer> lst2 = CustomerDAO.returnCustomerWithIdS(Customer_IdTXT);
        if (lst2.isEmpty()) {
            throw new SQLException("Customer with Id " + Customer_IdTXT + "  has'nt Membership.");
        }

        if (!TransactionDAO.is_record_found(Integer.parseInt(Book_IdTXT), Customer_IdTXT)) {
            throw new SQLException("You haven't borrowed this book.");

        }

        int delay = TransactionDAO.delete(Integer.parseInt(Book_IdTXT), Customer_IdTXT);
        delay -= lst.get(0).getLoan_Period();
        lst.get(0).setNo_Of_Copies(lst.get(0).getNo_Of_Copies() + 1);
        BookDAO.UpdateBook(lst.get(0));
        return delay;
    }
}
