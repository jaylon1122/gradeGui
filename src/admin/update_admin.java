/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.connectDB;
import config.passwordHasher;
import authentication.sign_in_ins;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author HP745 G3
 */
public class update_admin extends javax.swing.JFrame {

    /**
     * Creates new form update_admin
     */
    public update_admin() {
        initComponents();
    }
    
    private boolean isEmailValid(String email) {
       
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
     public static String email1;
     
     public boolean updatechecker(){
        connectDB db = new connectDB();
        try{
        String query = "SELECT * FROM tbl_user WHERE (email = '"+email.getText()+"') AND id != '"+id.getText()+"'";
        ResultSet resultSet = db.getData(query);
       
       
        if (resultSet.next()) { 
            email1 = resultSet.getString("email");
        if(email1.equals(email.getText())){
             JOptionPane.showMessageDialog(null, "Email is Already Used");
             email.setText("");
        }
         return true;  
        }else{
            return false;
        }
        }catch(SQLException e){
            System.out.println(""+e.getMessage());
            return false;
        }
    }
     
       private void logUpdateUserAction(int userId, String Username) {
    String sql = "INSERT INTO tbl_logs (user_id, activity_description, timestamp) VALUES (?, ?, NOW())";

    connectDB db = new connectDB();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "User deleted: " + Username); 
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log user deletion: " + e.getMessage());
    }
}
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        type1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ph = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        acc_name = new javax.swing.JLabel();
        acc_lname = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile_3135715 (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Update User Form");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        lastname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Last Name"));
        jPanel1.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 190, 50));

        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "First Name"));
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 190, 50));

        email.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Email"));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 190, 50));

        username.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Username"));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 190, 50));

        id.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ID"));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 190, 50));

        pass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Password"));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 190, 50));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 190, 40));

        type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        jPanel1.add(type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 190, 40));

        jLabel3.setText("Account Type");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        jLabel4.setText("Status Type");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 90, 30));

        ph.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contact Number"));
        jPanel1.add(ph, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 190, 50));

        jSeparator1.setForeground(new java.awt.Color(51, 0, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 48, 570, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Current User ID:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        acc_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        acc_name.setText("Admin");
        jPanel1.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        acc_lname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        acc_lname.setText("name");
        jPanel1.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        acc_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        acc_id.setText("ID");
        jPanel1.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Cancel");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 730, 410));

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
                       String passText = pass.getText();

                       if (email.getText().isEmpty() || ph.getText().isEmpty() || type1.getSelectedIndex() == 0
                               || passText.isEmpty()) {
                           JOptionPane.showMessageDialog(null, "All fields required");
                       } else if (passText.length() < 8) {
                           JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long");
                       } else if (!isEmailValid(email.getText())) {
                           JOptionPane.showMessageDialog(null, "Invalid email format");
                       } else if (updatechecker()) {
                           System.out.println("Duplicate Existed");
                       } else {
                           try {

                               String pass1 = passwordHasher.hashPassword(passText);

                               connectDB db = new connectDB();
                               String query = "UPDATE tbl_users SET email = ?, phone_number = ?, type = ?, pass = ?, status_1 = ? WHERE id = ?";
                               PreparedStatement pstmt = db.getConnection().prepareStatement(query);

                               pstmt.setString(1, email.getText());
                               pstmt.setString(2, ph.getText());
                               pstmt.setString(3, (String) type1.getSelectedItem());
                               pstmt.setString(4, pass1);
                               pstmt.setString(5, (String) type1.getSelectedItem());
                               pstmt.setString(6, id.getText());


                               int rowsUpdated = pstmt.executeUpdate();

                               if (rowsUpdated > 0) {
                                   JOptionPane.showMessageDialog(null, "User updated successfully!");
                                   
                                    
                                         int userId = Integer.parseInt(id.getText());
                                        logUpdateUserAction(userId, username.getText());
                               } else {
                                   JOptionPane.showMessageDialog(null, "User update failed!");
                               }

                               admin_dashb update_admin = new admin_dashb();
                               update_admin.setVisible(true);
                               this.dispose();

                           } catch (Exception e) {
                               e.printStackTrace();
                               JOptionPane.showMessageDialog(null, "Error updating user: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                           }
                       }
                   } catch (Exception e) {
                       e.printStackTrace();
                       JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                   }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         Session sess = Session.getInstance();
       if(sess.getId()== 0){
       JOptionPane.showMessageDialog(null,"No Account, Log in First");
       sign_in_ins admin_dashb = new sign_in_ins();
       admin_dashb.setVisible(true);
       this.dispose();
       }else{
            acc_name.setText(""+sess.getFname());
            acc_lname.setText(""+sess.getLname());
            acc_id.setText(""+sess.getId());
       } 
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(update_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(update_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(update_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(update_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new update_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel acc_lname;
    private javax.swing.JLabel acc_name;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField ph;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JComboBox<String> type1;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
