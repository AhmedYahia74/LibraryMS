/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;
import Database.Customer;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ahmed yehia
 */
public class CustomerTableModel extends AbstractTableModel {
    
    private static final int FirstNameCol=0;
    private static final int LastNameCol=1;
    private static final int IdCol=2;
    private static final int GenderCol=3;
    private static final int PhotoCol=5;
    private static final int PhoneCol=3;
    
   
    private String[] columns={"First Name","Last Name","Id","Phone"};
    private List<Customer> customers;
    public CustomerTableModel(List<Customer> list){
        this.customers=list;
    }
    @Override
    public int getRowCount() {
        return customers.size();
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
        Customer customer=customers.get(rowIndex);
        //    private String[] columns={"First Name","Last Name","Id","Gender","Password","Photo","Phone"};
        switch (columnIndex){
            case FirstNameCol:return customer.getFirst_Name();
            case LastNameCol:return customer.getLast_Name();
            case IdCol:return customer.getId();
//            case GenderCol:return customer.getGender();
//            case PasswordCol:return customer.getPassword();
//            case PhotoCol:return customer.getPhoto();
           
            default:return customer.getPhone();
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
