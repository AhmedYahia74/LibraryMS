/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import business.Validation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ahmed yehia
 */
public class Book {

    private String Title, Author, Language;
    private int Id, No_Of_Pages, No_Of_Copies, Loan_Period;
    private byte[] Photo;

    public Book() {

    }

    public Book(ResultSet rs) throws SQLException {
        Title = rs.getString("Title");
        Author = rs.getString("Author");
        Language = rs.getString("Language");
        Id = rs.getInt("Id");
        No_Of_Pages = rs.getInt("No_Of_Pages");
        No_Of_Copies = rs.getInt("No_Of_Copies");
        Loan_Period = rs.getInt("Loan_Period");
        Photo = rs.getBytes("Photo");
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) throws SQLException {
        if (Title.length() == 0) {
            throw new SQLException("Invalid Title. Please enter a valid Title.");
        }
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) throws SQLException {
        if (!Validation.Name(Author)) {
            throw new SQLException("Invalid Author. Please enter a valid Author.");
        }

        this.Author = Author;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) throws SQLException {
        if (!Validation.Number("" + Id)) {
            throw new SQLException("Invalid Id. Please enter a valid Id.");
        }
        this.Id = Id;
    }

    public int getNo_Of_Pages() {
        return No_Of_Pages;
    }

    public void setNo_Of_Pages(int No_Of_Pages) throws SQLException {
        if (!Validation.Number("" + No_Of_Pages)) {
            throw new SQLException("Invalid Pages. Please enter a valid Pages.");
        }
        this.No_Of_Pages = No_Of_Pages;
    }

    public int getNo_Of_Copies() {
        return No_Of_Copies;
    }

    public void setNo_Of_Copies(int No_Of_Copies) throws SQLException {
        if (!Validation.Number("" + No_Of_Copies)) {
            throw new SQLException("Invalid Copies. Please enter a valid Copies.");
        }
        this.No_Of_Copies = No_Of_Copies;
    }

    public int getLoan_Period() {
        return Loan_Period;
    }

    public void setLoan_Period(int Loan_Period) {
        this.Loan_Period = Loan_Period;
    }

    public byte[] getPhoto() {
        return Photo;
    }

    public void setPhoto(byte[] Photo) {
        this.Photo = Photo;
    }

    public void setPhoto(String s) throws SQLException {
        if (!Validation.Photo(s)) {
            throw new SQLException("Invalid Path. Please enter a valid Path.");
        }
        try {
            File file = new File(s);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            this.Photo = data;
        } catch (FileNotFoundException ex) {
            throw new SQLException("Invalid Path. Please enter a valid Path.");
        } catch (IOException ex) {
            throw new SQLException("Invalid Path. Please enter a valid Path.");
        }

    }

}
