/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import Database.Book;
import Database.BookDAO;
import GUI.Employee.AddBook;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Ahmed yehia
 */
public class Book_services {

    public Book_services() {

    }

    static public void SaveBook(String AuthorTXT, String TitleTXT, String No_Of_CopiesTXT, String No_Of_PagesTXT, String IdTXT,
            String path, String LanguageBOX) throws IOException, FileNotFoundException, SQLException {
        Book temp = new Book();
        temp.setAuthor(AuthorTXT);
        temp.setTitle(TitleTXT);
        temp.setNo_Of_Copies(Integer.parseInt(No_Of_CopiesTXT));
        temp.setNo_Of_Pages(Integer.parseInt(No_Of_PagesTXT));

        temp.setId(Integer.parseInt(IdTXT));

        temp.setPhoto(path);
        temp.setLanguage(LanguageBOX);
        BookDAO d = new BookDAO();
        temp.setLoan_Period((int) Math.ceil(Integer.parseInt(No_Of_PagesTXT) / 10.0));
        d.AdingBook(temp);
    }

    static public void UpdateBook(String AuthorTXT, String TitleTXT, String No_Of_CopiesTXT, String IdTXT,
            String path, String LanguageBOX, Book book) throws IOException, FileNotFoundException, SQLException {
        Book temp = new Book();
        temp.setAuthor(AuthorTXT);
        temp.setTitle(TitleTXT);
        temp.setNo_Of_Copies(Integer.parseInt(No_Of_CopiesTXT));
        temp.setNo_Of_Pages(book.getNo_Of_Pages());
        temp.setId(Integer.parseInt(IdTXT));
        if (path.length() > 0) {
            temp.setPhoto(path);
        } else {
            temp.setPhoto(book.getPhoto());
        }
        temp.setLanguage(LanguageBOX);
        temp.setLoan_Period(book.getLoan_Period());
        BookDAO.UpdateBook(temp);
    }

}
