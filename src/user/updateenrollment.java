/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import config.connectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP745 G3
 */
public class updateenrollment extends javax.swing.JFrame {

    /**
     * Creates new form updateenrollment
     */
    public updateenrollment() {
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
        yl = new javax.swing.JComboBox<>();
        section = new javax.swing.JComboBox<>();
        semester = new javax.swing.JComboBox<>();
        status = new javax.swing.JComboBox<>();
        dateEnrolled = new javax.swing.JTextField();
        studentID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 690, 20));

        yl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Year", "2mnd Year", "3rd Year", "4th Year" }));
        jPanel1.add(yl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 210, 50));

        section.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        section.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));
        jPanel1.add(section, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 210, 50));

        semester.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        semester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester" }));
        semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterActionPerformed(evt);
            }
        });
        jPanel1.add(semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 210, 50));

        status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enrolled" }));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 210, 50));

        dateEnrolled.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Date "));
        jPanel1.add(dateEnrolled, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 210, 50));

        studentID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student ID"));
        jPanel1.add(studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Year Level");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Section");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Semester");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Status");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 80, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Enroll Student");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 130, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Quit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 60, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Program");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 70, -1));

        program.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        program.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PF205", "IM207", "IPT209", "NET208" }));
        program.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programActionPerformed(evt);
            }
        });
        jPanel1.add(program, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 210, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Select Course");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 130, -1));

        course.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PF205", "IM207", "IPT209", "NET208" }));
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 210, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Course Descrption");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        courseD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        courseD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Object Oriented Programming", "Information Management", "Information  Programming and Technology", "Networking" }));
        courseD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseDActionPerformed(evt);
            }
        });
        jPanel1.add(courseD, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 210, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 790, 490));

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterActionPerformed

    }//GEN-LAST:event_semesterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String stID = studentID.getText().trim();
        String yearl = yl.getSelectedItem().toString().trim();
        String sec = section.getSelectedItem().toString().trim();
        String sem = semester.getSelectedItem().toString().trim();
        String dateEn = dateEnrolled.getText().trim();
        String stat = status.getSelectedItem().toString().trim();
        String prog = program.getSelectedItem().toString().trim();
        String crs = course.getSelectedItem().toString().trim();
        String crsDesc = courseD.getSelectedItem().toString().trim();

        if (stID.isEmpty() || yearl.isEmpty() || sec.isEmpty() || sem.isEmpty() ||
            dateEn.isEmpty() || stat.isEmpty() || prog.isEmpty() || crs.isEmpty() || crsDesc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
            return;
        }

        if (!dateEn.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(null, "Invalid date format! Use YYYY-MM-DD.");
            return;
        }

        if (!isStudentEnrolled(stID)) {
            JOptionPane.showMessageDialog(null, "Student is not enrolled yet!");
            return;
        }

        try {
            connectDB db = new connectDB();
            String query = "UPDATE tbl_enrollment SET " +
            "year_level = ?, course = ?, program = ?, section = ?, course_description = ?, " +
            "date_enrolled = ?, status = ? " +
            "WHERE studentID = ?";

            PreparedStatement pstmt = db.getConnection().prepareStatement(query);
            pstmt.setString(1, yearl);
            pstmt.setString(2, crs);
            pstmt.setString(3, prog);
            pstmt.setString(4, sec);
            pstmt.setString(5, crsDesc);
            pstmt.setString(6, dateEn);
            pstmt.setString(7, stat);
            pstmt.setString(8, stID);

            int rowsUpdated = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, rowsUpdated > 0 ? "Enrollment Updated Successfully!" : "Update Failed!");

            pstmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ins_dashb updateenrollment = new ins_dashb();
        updateenrollment.setVisible(true);
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
            java.util.logging.Logger.getLogger(updateenrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateenrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateenrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateenrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateenrollment().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> program;
    private javax.swing.JComboBox<String> section;
    private javax.swing.JComboBox<String> semester;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField studentID;
    private javax.swing.JComboBox<String> yl;
    // End of variables declaration//GEN-END:variables
}
