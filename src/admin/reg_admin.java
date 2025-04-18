/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.connectDB;
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
public class reg_admin extends javax.swing.JFrame {

    /**
     * Creates new form reg_admin
     */
    public reg_admin() {
        initComponents();
    }

     private boolean isEmailValid(String email) {
     
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
      
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static String email1,username1;
     public boolean duplicateChecker() {
    connectDB db = new connectDB();
    boolean isDuplicate = false;

    try {
        String query = "SELECT username, email FROM tbl_users WHERE username = ? OR email = ?";
        PreparedStatement pstmt = db.getConnection().prepareStatement(query);
        pstmt.setString(1, username.getText());
        pstmt.setString(2, em.getText());
        ResultSet resultSet = pstmt.executeQuery();

        while (resultSet.next()) { 
            String existingEmail = resultSet.getString("email");
            String existingUsername = resultSet.getString("username");

            if (existingEmail.equals(em.getText())) {
                JOptionPane.showMessageDialog(null, "Email is Already Used");
                em.setText("");
                isDuplicate = true;
            }
            if (existingUsername.equals(username.getText())) {
                JOptionPane.showMessageDialog(null, "Username is Already Used");
                username.setText("");
                isDuplicate = true;
            }
        }

        resultSet.close();
        pstmt.close();
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }

    return isDuplicate;
}
     
       private void logAddUserAction(int userId, String Username) {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        register = new javax.swing.JButton();
        ut = new javax.swing.JComboBox<>();
        us = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        cn = new javax.swing.JTextField();
        separator = new javax.swing.JSeparator();
        acc_id = new javax.swing.JLabel();
        acc_name = new javax.swing.JLabel();
        acc_lname = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile_3135715 (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("New User");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        username.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Username", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 200, 60));

        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "First Name", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 200, 60));

        lname.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Last Name", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 200, 60));

        em.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Email", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 200, 60));

        pass.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Password", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 200, 60));

        register.setBackground(new java.awt.Color(255, 255, 255));
        register.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        register.setText("Add");
        register.setBorder(null);
        register.setBorderPainted(false);
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel1.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 80, 30));

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User Type", "User", "Admin" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        jPanel1.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 180, 60));

        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staus Type", "Active", "Pending" }));
        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel1.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 180, 60));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 80, 30));

        cn.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Contact", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        jPanel1.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 200, 60));
        jPanel1.add(separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 540, 10));

        acc_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        acc_id.setText("ID");
        jPanel1.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        acc_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        acc_name.setText("Admin");
        jPanel1.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        acc_lname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        acc_lname.setText("name");
        jPanel1.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Current User ID:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked

    }//GEN-LAST:event_registerMouseClicked

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed

        connectDB db = new connectDB();

        if(username.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() || em.getText().isEmpty()  || cn.getText().isEmpty()
            || pass.getText().isEmpty()){ 
            JOptionPane.showMessageDialog(null, "All fields required");

        }else if(!isEmailValid(em.getText())){
            JOptionPane.showMessageDialog(null, "Your email format is invalid, Please Try again!");
        }else if(duplicateChecker()){
            System.out.println("Duplicate Existed");
          } else if (!cn.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Contact number must only contain digits");
       
        }else if(pass.getText().length() < 8){

            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long");
       
        }else if (db.insertData("INSERT INTO tbl_users(username, fname, lname, email, contact, type, pass, status) "
                + "VALUES ('"+username.getText()+"', '"+fname.getText()+"', '"+lname.getText()+"', '"+em.getText()+"', '"+cn.getText()+"', '"+ut.getSelectedItem()+"', '"+pass.getText()+"',  '"+us.getSelectedItem()+"')") > 0 ) {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }else{
            
            JOptionPane.showMessageDialog(null, "Submitted Successfuly");
            logAddUserAction(1, username.getText()); 
              
            sign_in_ins reg_admin = new sign_in_ins();
            reg_admin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_registerActionPerformed

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         admin_dashb reg_admin = new admin_dashb();
         reg_admin.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnActionPerformed

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
            java.util.logging.Logger.getLogger(reg_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reg_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reg_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reg_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reg_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel acc_lname;
    private javax.swing.JLabel acc_name;
    public javax.swing.JTextField cn;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fname;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField lname;
    public javax.swing.JPasswordField pass;
    private javax.swing.JButton register;
    private javax.swing.JSeparator separator;
    public javax.swing.JComboBox<String> us;
    public javax.swing.JTextField username;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
