/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import settings.admin_settings;

/**
 *
 * @author HP745 G3
 */
public class changeemail extends javax.swing.JFrame {

    /**
     * Creates new form changeEmail
     */
    public changeemail() {
        initComponents();
    }
 private boolean emailExists(String email) {
    try {
          connectDB db = new connectDB();
        String query = "SELECT COUNT(*) FROM tbl_users WHERE email = ?";
        PreparedStatement pstmt = db.getConnection().prepareStatement(query);
        pstmt.setString(1, email);
        
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            return rs.getInt(1) > 0;  // Returns true if the email exists
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
    private boolean isEmailValid(String email) {
        // More robust regex (but still not perfect for all valid email addresses)
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        // Compile the regex pattern only ONCE (outside the function for efficiency)
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private void logChangeEmailAction(int userId, String Username) {
    String sql = "INSERT INTO tbl_logs (user_id, activity_description, timestamp) VALUES (?, ?, NOW())";

    connectDB db = new connectDB();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "Email changed: " + Username); 
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log user changing of email " + e.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        newemail = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        currentemail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Update User Email");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile_3135715 (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        newemail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "New Email"));
        jPanel1.add(newemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 240, 60));

        id.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Current User ID"));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 240, 60));

        currentemail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Current Email"));
        jPanel1.add(currentemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 240, 60));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 540, 440));

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         admin_settings changeemail = new admin_settings();  
        changeemail.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
String currentEmailText = currentemail.getText().trim(); 
String newEmailText = newemail.getText().trim(); 


if (currentEmailText.isEmpty() || newEmailText.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Both current and new email fields are required", "Missing Information", JOptionPane.WARNING_MESSAGE);
    return;
}

if (!isEmailValid(newEmailText)) {
    JOptionPane.showMessageDialog(null, "Invalid email format", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    connectDB db = new connectDB();
    Connection con = db.getConnection();

 
    String checkCurrentEmailQuery = "SELECT email FROM tbl_users WHERE id = ?";
    PreparedStatement checkCurrentEmailStmt = con.prepareStatement(checkCurrentEmailQuery);
    checkCurrentEmailStmt.setString(1, id.getText()); 
    ResultSet rs = checkCurrentEmailStmt.executeQuery();

    if (rs.next()) {
        String actualCurrentEmail = rs.getString("email");

        
        if (!currentEmailText.equals(actualCurrentEmail)) {
            JOptionPane.showMessageDialog(null, "Incorrect current email!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } else {
        JOptionPane.showMessageDialog(null, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

  
    String checkNewEmailQuery = "SELECT COUNT(*) FROM tbl_users WHERE email = ?";
    PreparedStatement checkNewEmailStmt = con.prepareStatement(checkNewEmailQuery);
    checkNewEmailStmt.setString(1, newEmailText);
    ResultSet rsNewEmail = checkNewEmailStmt.executeQuery();
    
    if (rsNewEmail.next() && rsNewEmail.getInt(1) > 0) {
        JOptionPane.showMessageDialog(null, "This new email is already in use by another user", "Duplicate Email", JOptionPane.WARNING_MESSAGE);
        return;
    }

   
    String updateQuery = "UPDATE tbl_users SET email = ? WHERE id = ?";
    PreparedStatement updateStmt = con.prepareStatement(updateQuery);
    updateStmt.setString(1, newEmailText);
    updateStmt.setString(2, id.getText());

    int rowsUpdated = updateStmt.executeUpdate();

    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(null, "Email updated successfully!");
        logChangeEmailAction(Integer.parseInt(id.getText()), id.getText());
      
        Session sess = Session.getInstance();
        sess.setEmail(newEmailText);

       
        admin_settings changecontact = new admin_settings();  
        changecontact.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Email update failed. Please try again.", "Update Failed", JOptionPane.ERROR_MESSAGE);
    }


    rs.close();
    rsNewEmail.close();
    checkCurrentEmailStmt.close();
    checkNewEmailStmt.close();
    updateStmt.close();
    con.close();

} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error updating email: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(changeemail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changeemail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changeemail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changeemail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changeemail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField currentemail;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField newemail;
    // End of variables declaration//GEN-END:variables
}
