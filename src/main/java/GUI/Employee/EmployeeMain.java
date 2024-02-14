/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Employee;

import GUI.Employee.AddBook;
import GUI.Employee.FindBook;
import GUI.Employee.Borrow;
import GUI.Employee.ReturnBook;
import GUI.Employee.AddCustomer;
import GUI.Employee.FindCustomer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed yehia
 */
public class EmployeeMain extends javax.swing.JFrame {

    /**
     * Creates new form AmployeeMain
     */
     String id;
    public EmployeeMain(String id) {
        this.id=id;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FindCustomer = new javax.swing.JButton();
        AddCustomer = new javax.swing.JButton();
        Borrow = new javax.swing.JButton();
        ReturnBook = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        AddBook = new javax.swing.JButton();
        FindBook = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        FindCustomer.setBackground(new java.awt.Color(41, 128, 185));
        FindCustomer.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        FindCustomer.setForeground(new java.awt.Color(255, 255, 255));
        FindCustomer.setText("Find Member");
        FindCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindCustomerActionPerformed(evt);
            }
        });

        AddCustomer.setBackground(new java.awt.Color(41, 128, 185));
        AddCustomer.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        AddCustomer.setForeground(new java.awt.Color(255, 255, 255));
        AddCustomer.setText("Create Membership");
        AddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCustomerActionPerformed(evt);
            }
        });

        Borrow.setBackground(new java.awt.Color(41, 128, 185));
        Borrow.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        Borrow.setForeground(new java.awt.Color(255, 255, 255));
        Borrow.setText("Borrow a Book");
        Borrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrowActionPerformed(evt);
            }
        });

        ReturnBook.setBackground(new java.awt.Color(41, 128, 185));
        ReturnBook.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        ReturnBook.setForeground(new java.awt.Color(255, 255, 255));
        ReturnBook.setText("Return Book");
        ReturnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnBookActionPerformed(evt);
            }
        });

        LogOut.setBackground(new java.awt.Color(102, 0, 0));
        LogOut.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        AddBook.setBackground(new java.awt.Color(41, 128, 185));
        AddBook.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        AddBook.setForeground(new java.awt.Color(255, 255, 255));
        AddBook.setText("Add Book");
        AddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookActionPerformed(evt);
            }
        });

        FindBook.setBackground(new java.awt.Color(41, 128, 185));
        FindBook.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        FindBook.setForeground(new java.awt.Color(255, 255, 255));
        FindBook.setText("Find Book");
        FindBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddCustomer, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Borrow, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ReturnBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FindCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FindBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogOut)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddBook, AddCustomer, Borrow, FindBook, FindCustomer, ReturnBook});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(FindCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Borrow, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReturnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FindBook, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(LogOut)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AddBook, AddCustomer, Borrow, FindBook, FindCustomer, ReturnBook});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FindCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindCustomerActionPerformed
       FindCustomer findcustomer=new FindCustomer(id);
       findcustomer.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_FindCustomerActionPerformed

    private void AddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCustomerActionPerformed
        AddCustomer addcustomer=new AddCustomer(id);
        addcustomer.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AddCustomerActionPerformed

    private void BorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowActionPerformed
        Borrow borrow;
         try {
             borrow = new Borrow(id);
               borrow.setVisible(true);
              this.setVisible(false);
         } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         }
      
    }//GEN-LAST:event_BorrowActionPerformed

    private void ReturnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnBookActionPerformed
         try {
             ReturnBook r=new ReturnBook(id);
             r.setVisible(true);
             this.setVisible(false);
         } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_ReturnBookActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        EmployeeLogin l=new EmployeeLogin();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LogOutActionPerformed

    private void AddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBookActionPerformed
          AddBook r=new AddBook(id);
             r.setVisible(true);
             this.setVisible(false);
    }//GEN-LAST:event_AddBookActionPerformed

    private void FindBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindBookActionPerformed
          FindBook r=new FindBook(id);
          r.setVisible(true);
          this.setVisible(false);
    }//GEN-LAST:event_FindBookActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBook;
    private javax.swing.JButton AddCustomer;
    private javax.swing.JButton Borrow;
    private javax.swing.JButton FindBook;
    private javax.swing.JButton FindCustomer;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton ReturnBook;
    // End of variables declaration//GEN-END:variables
}
