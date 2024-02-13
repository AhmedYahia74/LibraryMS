/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDAO extends ConnectDB {

    public static Connection myconnection;

    public BookDAO() throws FileNotFoundException, IOException, SQLException {
        myconnection = BookDAO.getConnect();
    }

    static public void connect() throws IOException, FileNotFoundException, SQLException {
        myconnection = BookDAO.getConnect();
    }

    static public void DeleteBook(int Id) throws SQLException, IOException {
        BookDAO.connect();
        PreparedStatement statement = null;
        try {
            statement = myconnection.prepareStatement("delete from Book where Id=?");
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        statement.setInt(1, Id);
        statement.executeQuery();

    }

    static public ArrayList<Book> Search(String s) throws SQLException, IOException {
        BookDAO.connect();
        ArrayList<Book> lst;
        lst = new ArrayList<>();
        String t = "%" + s + "%";
        PreparedStatement statement;
        ResultSet result;
        boolean flag = true;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                flag = false;
            }
        }
        if (t.length() > 2) {
            if (flag) {
                statement = myconnection.prepareStatement("select * from Book where"
                        + " Id = ?");
                statement.setInt(1, Integer.parseInt(s));
            } else {
                statement = myconnection.prepareStatement("select * from Book where"
                        + " Title like ? or Author like ? ");
                statement.setString(1, t);
                statement.setString(2, t);

            }
        } else {
            statement = myconnection.prepareStatement("select * from Book");
        }
        result = statement.executeQuery();
        while (result.next()) {
            Book temp = new Book(result);
            lst.add(temp);
        }
        statement.close();
        return lst;

    }

    static public void AdingBook(Book book) throws SQLException, IOException {
        BookDAO.connect();
        PreparedStatement statement;
        statement = myconnection.prepareStatement("insert into Book (Title,Author,Language,"
                + " Photo,No_Of_Pages,No_Of_Copies,Loan_Period,Id) values ('" + book.getTitle() + "',"
                + "'" + book.getAuthor() + "','" + book.getLanguage() + "',?,?,?,?,?)");
        statement.setBytes(1, book.getPhoto());
        statement.setInt(2, book.getNo_Of_Pages());
        statement.setInt(3, book.getNo_Of_Copies());
        statement.setInt(4, book.getLoan_Period());
        statement.setInt(5, book.getId());

        statement.executeUpdate();
        statement.close();
    }

    static public void UpdateBook(Book book) throws SQLException, IOException {
        BookDAO.connect();
        PreparedStatement statement;
        statement = myconnection.prepareStatement("update Book "
                + "set Title='" + book.getTitle() + "', Author='" + book.getAuthor() + "', Language='" + book.getLanguage() + "',"
                + " Photo = ? ,No_Of_Pages=? , No_Of_Copies = ?,Loan_Period = ? where Id=?");
        statement.setBytes(1, book.getPhoto());
        statement.setInt(2, book.getNo_Of_Pages());
        statement.setInt(3, book.getNo_Of_Copies());
        statement.setInt(4, book.getLoan_Period());
        statement.setInt(5, book.getId());
        statement.executeUpdate();
        statement.close();
    }
}
