/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import config.connectDB;
import user.ins_dashb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author SCC-COLLEGE
 */
public class student_data extends javax.swing.JFrame {

    /**
     * Creates new form student_data
     */
    public student_data() {
        initComponents();
    }
    
    connectDB db = new connectDB(); 

    
    private boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

   
    private boolean duplicateChecker(String email) {
        boolean isDuplicate = false;

        try {
            String query = "SELECT email FROM tbl_student WHERE email = ?";
            PreparedStatement pstmt = db.getConnection().prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Email is already used");
                isDuplicate = true;
            }else{
                JOptionPane.showMessageDialog(null, "Added Successfuly");
                student_dashb student_data = new student_dashb();
                student_data.setVisible(true);
                this.dispose();
                
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return isDuplicate;
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cn = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/student_18181142 (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Student Information ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jPanel3.setBackground(new java.awt.Color(103, 95, 122));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quit");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 50, 30));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 480, 30));

        cn.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contact Number "));
        jPanel2.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 240, 70));

        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "First Name"));
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 240, 70));

        lname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Last Name"));
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 240, 70));

        em.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Email"));
        jPanel2.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 240, 70));

        jPanel4.setBackground(new java.awt.Color(99, 87, 119));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add Student");
        jPanel4.add(jLabel4);

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 110, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 640, 360));

        jPanel1.setBackground(new java.awt.Color(26, 6, 74));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
         student_dashb student_data = new student_dashb();
         student_data.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        connectDB db = new connectDB();

    if(fname.getText().isEmpty() || lname.getText().isEmpty() || em.getText().isEmpty() || cn.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required");

    }else if(!isEmailValid(em.getText())){
            JOptionPane.showMessageDialog(null, "Your email format is invalid, Please Try again!");
    }else if(duplicateChecker(em.getText())){
            System.out.println("Duplicate Existed");
     

    } else if (!cn.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Contact number only accepts numeric!");

    } else if (cn.getText().length() > 11) {
        JOptionPane.showMessageDialog(null, "Contact number should not exceed 11 numbers");

    } else if (db.insertData("INSERT INTO tbl_student (fname, lname, email, contact) " +
        "VALUES ('" + fname.getText() + "', '" + lname.getText() + "', '" + em.getText() + "', '" + cn.getText() + "')") == 1) {

            JOptionPane.showMessageDialog(null, "Student added successfully");

    } else {
        JOptionPane.showMessageDialog(null, "Connection Error");
}


   
    }//GEN-LAST:event_jPanel4MouseClicked

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
            java.util.logging.Logger.getLogger(student_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student_data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cn;
    private javax.swing.JTextField em;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lname;
    // End of variables declaration//GEN-END:variables

   
}
