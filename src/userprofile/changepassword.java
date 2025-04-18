/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile;

import config.Session;
import config.connectDB;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import settings.user_settings;

/**
 *
 * @author HP745 G3
 */
public class changepassword extends javax.swing.JFrame {

    /**
     * Creates new form changepassword
     */
    public changepassword() {
        initComponents();
    }

    private void logChangePasswordAction(int userId, String Username) {
    String sql = "INSERT INTO tbl_logs (user_id, activity_description, timestamp) VALUES (?, ?, NOW())";

    connectDB db = new connectDB();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "Password Changed: " + Username); 
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log user changing of password: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        npass = new javax.swing.JTextField();
        cpass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Change Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile_3135715 (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        id.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Current User ID"));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 240, 60));

        npass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "New Password"));
        npass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npassActionPerformed(evt);
            }
        });
        jPanel1.add(npass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 240, 60));

        cpass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Current Password"));
        jPanel1.add(cpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 240, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 540, 440));

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void npassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        user_settings changepassword = new user_settings();
        changepassword.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            String currentPassText = cpass.getText();
            String newPassText = npass.getText();

            if (currentPassText.isEmpty() || newPassText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All Fields Required!", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (newPassText.length() < 8) {
                JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long!", "Invalid Password", JOptionPane.WARNING_MESSAGE);
                return;
            }

            connectDB db = new connectDB();
            Connection con = db.getConnection();

            String fetchQuery = "SELECT pass FROM tbl_users WHERE id = ?";
            PreparedStatement fetchStmt = con.prepareStatement(fetchQuery);
            fetchStmt.setInt(1, Session.getInstance().getId());
            ResultSet rs = fetchStmt.executeQuery();

            if (rs.next()) {
                String actualCurrentPass = rs.getString("pass");

                if (!passwordHasher.checkPassword(currentPassText, actualCurrentPass)) {
                    JOptionPane.showMessageDialog(null, "Incorrect Current Password!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String hashedNewPass = passwordHasher.hashPassword(newPassText);

            String updateQuery = "UPDATE tbl_users SET pass = ? WHERE id = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateQuery);
            updateStmt.setString(1, hashedNewPass);
            updateStmt.setInt(2, Session.getInstance().getId());

            int updatedRows = updateStmt.executeUpdate();
            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null, "Password updated successfully!");
                logChangePasswordAction(Session.getInstance().getId(), "" + Session.getInstance().getId());

                Session sess = Session.getInstance();
                sess.setPass(hashedNewPass);

                fetchStmt = con.prepareStatement("SELECT * FROM tbl_users WHERE id = ?");
                fetchStmt.setInt(1, Session.getInstance().getId());
                rs = fetchStmt.executeQuery();

                if (rs.next()) {

                    sess.setFname(rs.getString("fname"));
                    sess.setLname(rs.getString("lname"));
                    sess.setEmail(rs.getString("email"));
                    sess.setUsername(rs.getString("username"));
                    sess.setType(rs.getString("type"));
                    sess.setStatus(rs.getString("status"));
                    sess.setContact(rs.getString("contact"));
                }

                user_settings changepassword = new user_settings();
                changepassword.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Failed to update password!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            updateStmt.close();
            fetchStmt.close();
            con.close();

        } catch (SQLException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changepassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpass;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField npass;
    // End of variables declaration//GEN-END:variables
}
