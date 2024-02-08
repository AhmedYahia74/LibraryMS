package Employee;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ahmed yehia
 */
public class EmployeeTableModel extends AbstractTableModel {


    private static final int FirstNameCol=0;
    private static final int LastNameCol=1;
    private static final int IdCol=2;
    private static final int GenderCol=3;
    private static final int PasswordCol=4;
    private static final int PhotoCol=5;
    private static final int PhoneCol=3;
    
   
    private String[] columns={"First Name","Last Name","Id","Phone"};
    private List<Employee> employees;
    public EmployeeTableModel(List<Employee> list){
        this.employees=list;
    }
    @Override
    public int getRowCount() {
        return employees.size();
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
        Employee employee=employees.get(rowIndex);
        //    private String[] columns={"First Name","Last Name","Id","Gender","Password","Photo","Phone"};
        switch (columnIndex){
            case FirstNameCol:return employee.getFirst_Name();
            case LastNameCol:return employee.getLast_Name();
            case IdCol:return employee.getId();
//            case GenderCol:return employee.getGender();
//            case PasswordCol:return employee.getPassword();
//            case PhotoCol:return employee.getPhoto();
           
            default:return employee.getPhone();
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
