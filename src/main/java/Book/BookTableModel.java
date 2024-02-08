/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Book;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Ahmed yehia
 */
public class BookTableModel extends AbstractTableModel{
      
    private static final int TitleCol=0;
    private static final int AuthorCol=1;
    private static final int IdCol=2;
    private static final int No_OF_CopiesCol=3;

    
   
    private String[] columns={"Title","Author","Id","No_OF_Copies"};
    private List<Book> books;
    public BookTableModel(List<Book> list){
        this.books=list;
    }
    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0,columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book=books.get(rowIndex);
        switch (columnIndex){
            case TitleCol:return book.getTitle();
            case AuthorCol:return book.getAuthor();
            case IdCol:return book.getId();
            default:return book.getNo_Of_Copies();
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
