/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollment;

import admin.admin_dashb;
import config.connectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP745 G3
 */
public class updateenroll extends javax.swing.JFrame {

    /**
     * Creates new form updateenroll
     */
    public updateenroll() {
        initComponents();
    }

    public boolean isStudentEnrolled(String studentID) {
    connectDB db = new connectDB();
    boolean enrolled = false;

    try {
        String query = "SELECT * FROM tbl_enrollment WHERE studentID = ?";
        PreparedStatement pstmt = db.getConnection().prepareStatement(query);
        pstmt.setString(1, studentID);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) { 
            enrolled = true; 
        } else {
            JOptionPane.showMessageDialog(null, "Error: Student is not enrolled!", "Enrollment Error", JOptionPane.ERROR_MESSAGE);
        }

        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        System.out.println("Database error: " + e.getMessage());
    }
      return enrolled;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        section = new javax.swing.JComboBox<>();
        dateEnrolled = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        program = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        course = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        courseD = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/graduation_16584819.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Update Student Enrollment");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 450, 20));

        section.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        section.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));
        jPanel1.add(section, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 210, 50));

        dateEnrolled.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Date Enrolled"));
        jPanel1.add(dateEnrolled, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 210, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Section");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Enroll Student");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 130, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Quit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 60, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Program");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, -1));

        program.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        program.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PF205", "IM207", "IPT209", "NET208" }));
        program.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programActionPerformed(evt);
            }
        });
        jPanel1.add(program, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Select Course");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 130, -1));

        course.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PF205", "IM207", "IPT209", "NET208" }));
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Course Descrption");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        courseD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        courseD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Object Oriented Programming", "Information Management", "Information  Programming and Technology", "Networking" }));
        courseD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseDActionPerformed(evt);
            }
        });
        jPanel1.add(courseD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 250, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 580, 490));

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


        String sec = section.getSelectedItem().toString().trim();
        String dateEn = dateEnrolled.getText().trim();
        String prog = program.getSelectedItem().toString().trim();
        String crs = course.getSelectedItem().toString().trim();
        String crsDesc = courseD.getSelectedItem().toString().trim();

        // Validate all fields
        if ( sec.isEmpty() || dateEn.isEmpty() || 
            prog.isEmpty() || crs.isEmpty() || crsDesc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }

        // Validate date format
        if (!dateEn.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid date format! Use YYYY-MM-DD.");
            return;
        }

        // Show student ID input dialog
        String studentID = JOptionPane.showInputDialog(this, "Enter Student ID:");
        if (studentID == null || studentID.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Student ID!");
            return;
        }

        try {
            // Check if student exists
            connectDB db = new connectDB();
            String checkQuery = "SELECT * FROM tbl_student WHERE studentID = ?";
            PreparedStatement checkStmt = db.getConnection().prepareStatement(checkQuery);
            checkStmt.setString(1, studentID);
            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Student ID not found!");
                return;
            }

            // Insert enrollment record
            String insertQuery = "INSERT INTO tbl_enrollment (studentID, section, program, course, course_description, date_enrolled) " +
                               "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = db.getConnection().prepareStatement(insertQuery);
            pstmt.setString(1, studentID);
    
            pstmt.setString(3, sec);
            pstmt.setString(4, prog);
            pstmt.setString(5, crs);
            pstmt.setString(6, crsDesc);
            pstmt.setString(7, dateEn);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Student enrolled successfully!");
                // Clear fields after successful enrollment
                dateEnrolled.setText("");
                program.setSelectedIndex(0);
                course.setSelectedIndex(0);
                courseD.setSelectedIndex(0);
            
                section.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "Enrollment failed!");
            }

            pstmt.close();
            checkStmt.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
            ex.printStackTrace();
        }
    

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        admin_dashb enroll = new admin_dashb();
        enroll.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void programActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programActionPerformed

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseActionPerformed

    private void courseDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseDActionPerformed

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
            java.util.logging.Logger.getLogger(updateenroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateenroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateenroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateenroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateenroll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> course;
    private javax.swing.JComboBox<String> courseD;
    private javax.swing.JTextField dateEnrolled;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> program;
    private javax.swing.JComboBox<String> section;
    // End of variables declaration//GEN-END:variables
}
