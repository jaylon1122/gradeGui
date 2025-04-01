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
import javax.swing.JOptionPane;
import settings.admin_settings;

/**
 *
 * @author HP745 G3
 */
public class changecontact extends javax.swing.JFrame {

    /**
     * Creates new form changecontact
     */
    public changecontact() {
        initComponents();
    }
private boolean phoneExists(String phoneNumber) {
    boolean exists = false;
    try {
         connectDB db = new connectDB();
        String query = "SELECT * FROM tbl_users WHERE contact = ?";
        PreparedStatement pstmt = db.getConnection().prepareStatement(query);
        pstmt.setString(1, phoneNumber);
        
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            exists = true;  
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return exists;
}
 private void logChangeContactAction(int userId, String Username) {
    String sql = "INSERT INTO tbl_logs (user_id, activity_description, timestamp) VALUES (?, ?, NOW())";

    connectDB db = new connectDB();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "Contact Changed: " + Username); 
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log user changing of contact: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nnum = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        cnum = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Update User Contact Info");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile_3135715 (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        nnum.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "New Contact Number"));
        jPanel1.add(nnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 240, 60));

        id.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Current User ID"));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 240, 60));

        cnum.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Current Contact Number"));
        jPanel1.add(cnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 240, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, -1));

        update.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 540, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        admin_settings changecontact = new admin_settings();  
        changecontact.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String currentPhoneText = cnum.getText();  
        String newPhoneText = nnum.getText();


if (currentPhoneText.isEmpty() || newPhoneText.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Both current and new phone numbers are required.");
    return;
}


if (!newPhoneText.matches("\\d+")) {
    JOptionPane.showMessageDialog(null, "Phone number must only contain digits.");
    return;
}

if (newPhoneText.length() > 11 || newPhoneText.length() < 11) {
    JOptionPane.showMessageDialog(null, "Phone number must be 8 digits long.");
    return;
}


if (!phoneExists(currentPhoneText)) {
    JOptionPane.showMessageDialog(null, "The current phone number does not exist in the database.");
    return;
}


try {
    connectDB db = new connectDB();
    String query = "UPDATE tbl_users SET contact = ? WHERE id = ?";
    
    PreparedStatement pstmt = db.getConnection().prepareStatement(query);
    pstmt.setString(1, newPhoneText);
    pstmt.setString(2, id.getText()); 

   
    int rowsUpdated = pstmt.executeUpdate();

  
    if (rowsUpdated > 0) {
       
        Session sess = Session.getInstance();  
        sess.setContact(newPhoneText); 

        JOptionPane.showMessageDialog(null, "Phone number updated successfully!");
         logChangeContactAction(Integer.parseInt(id.getText()), id.getText());

       
        admin_settings changecontact = new admin_settings();  
        changecontact.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Phone number update failed. Please try again.");
    }

} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error updating phone number: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(changecontact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changecontact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changecontact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changecontact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changecontact().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cnum;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nnum;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
