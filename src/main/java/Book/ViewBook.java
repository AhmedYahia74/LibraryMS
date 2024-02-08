/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Book;

import Master.BookDAO;
import Master.Validation;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed yehia
 */
public class ViewBook extends javax.swing.JDialog {

    /**
     * Creates new form ViewBook
     */
     private BookDAO DAO;
    private Book book;
    private FindBook findform;
    public ViewBook(FindBook fnd,BookDAO dao,Book book, boolean modal) {
        super(fnd, modal);
        this.DAO=dao;
        this.findform=fnd;
        this.book=book;
        initComponents();
       ShowData(book);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LanguageBOX = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Photolbl = new javax.swing.JLabel();
        IdTXT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        No_Of_CopiesTXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        TitleTXT = new javax.swing.JTextField();
        AuthorTXT = new javax.swing.JTextField();
        PhotoTXT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Language");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Author");

        LanguageBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Arabic" }));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("ISBN");

        Photolbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        IdTXT.setEditable(false);
        IdTXT.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Copies");

        No_Of_CopiesTXT.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Title");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Photo");

        SaveButton.setBackground(new java.awt.Color(41, 128, 185));
        SaveButton.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        TitleTXT.setToolTipText("");

        AuthorTXT.setToolTipText("");

        PhotoTXT.setToolTipText("Put the path of a photo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Photolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PhotoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(LanguageBOX, javax.swing.GroupLayout.Alignment.LEADING, 0, 114, Short.MAX_VALUE)
                            .addComponent(AuthorTXT))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel6)
                                .addGap(35, 35, 35)
                                .addComponent(IdTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(No_Of_CopiesTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TitleTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Photolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(PhotoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(TitleTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AuthorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LanguageBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No_Of_CopiesTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(IdTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        try {
            // TODO add your handling code here:
            SaveBook();

        } catch (IOException | SQLException ex) {
            // Log the exception details
            ex.printStackTrace();

            // Optionally, show a user-friendly error message
            JOptionPane.showMessageDialog(this, "An error occurred. Please check the logs for details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AuthorTXT;
    private javax.swing.JTextField IdTXT;
    private javax.swing.JComboBox<String> LanguageBOX;
    private javax.swing.JTextField No_Of_CopiesTXT;
    private javax.swing.JTextField PhotoTXT;
    private javax.swing.JLabel Photolbl;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField TitleTXT;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

private void SaveBook() throws IOException, FileNotFoundException, SQLException {
        Book temp=new Book();
        Validation v=new Validation();
        
        if(v.Name(AuthorTXT.getText())){
            temp.setAuthor(AuthorTXT.getText());
        }
        else {
            JOptionPane.showMessageDialog(this, "Invalid Author. Please enter a valid Author.", "Error", JOptionPane.ERROR_MESSAGE);  
            return;
        }
        
        if(TitleTXT.getText().length()>0){
            temp.setTitle(TitleTXT.getText());
        }
        else {
            JOptionPane.showMessageDialog(this, "Invalid Title. Please enter a valid Title.", "Error", JOptionPane.ERROR_MESSAGE);  
            return;
        }
        
        
        if(v.Id(No_Of_CopiesTXT.getText())){
            temp.setNo_Of_Copies(Integer.parseInt(No_Of_CopiesTXT.getText()));
        }
        else {
            JOptionPane.showMessageDialog(this, "Invalid ID. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);  
            return;
        }
  
        
        
        if(v.Photo(PhotoTXT.getText())){
          try{
              File file=new File(PhotoTXT.getText());
              FileInputStream fis = new FileInputStream(file);
            byte[] data= new byte[(int) file.length()];
            fis.read(data);
            temp.setPhoto(data);
          } catch (FileNotFoundException ex) {
           JOptionPane.showMessageDialog(this, "Invalid Path. Please enter a valid path.", "Error", JOptionPane.ERROR_MESSAGE);  
            return;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Path. Please enter a valid path.", "Error", JOptionPane.ERROR_MESSAGE);  
            return;
            }
        }
        else if(PhotoTXT.getText().length()==0) {
            temp.setPhoto(book.getPhoto());
        }
        else {
            
            JOptionPane.showMessageDialog(this, "Invalid Path. Please enter a valid path.", "Error", JOptionPane.ERROR_MESSAGE);  
            return;
        }
        temp.setId(book.getId());
        temp.setLanguage((String)LanguageBOX.getSelectedItem());
        temp.setLoan_Period((book.getLoan_Period()));
        temp.setNo_Of_Pages(book.getNo_Of_Pages());
        DAO.UpdateBook(temp);
        setVisible(false);
         dispose();
        JOptionPane.showMessageDialog(this, "Book Updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

    }

   private void ShowData(Book book) {
        TitleTXT.setText(book.getTitle());
        AuthorTXT.setText(book.getAuthor());
        IdTXT.setText(book.getId()+"");
        No_Of_CopiesTXT.setText(""+book.getNo_Of_Copies());
                byte[] img = book.getPhoto();
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myimg = im.getScaledInstance(Photolbl.getWidth(), Photolbl.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myimg);
                Photolbl.setIcon(newImage);
    }

}
