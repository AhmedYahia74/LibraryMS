/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaction;

import Transaction.Transaction;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ahmed yehia
 */
public class TransactionTableModel extends AbstractTableModel{
    private static final int Employee_IdCol=0;
    private static final int Book_IdCol=1;
    private static final int Customer_IdCol=2;
    private static final int DateCol=3;
      private String[] columns={"Employee_Id","Book_Id","Customer_Id","Date"};
    private List<Transaction> transactions;
    public TransactionTableModel(List<Transaction> list){
        this.transactions=list;
    }
    @Override
    public int getRowCount() {
        return transactions.size();
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
        Transaction transaction=transactions.get(rowIndex);
        switch (columnIndex){
            case Employee_IdCol:return transaction.getEmployee_Id();
            case Book_IdCol:return transaction.getBook_Id();
            case Customer_IdCol:return transaction.getCustomer_Id();
            default:return transaction.getDate();
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
