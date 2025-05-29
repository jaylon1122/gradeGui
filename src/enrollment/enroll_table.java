package enrollment;

import config.connectDB;
import dashbaord.dashb;
import grade.grade_dashb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import student.student_dashb;
import java.awt.*;

public class enroll_table extends javax.swing.JFrame {
    private JComboBox<String> program;
    private JComboBox<String> course;
    private JComboBox<String> yl;
    private JComboBox<String> section;
    private JTextField dateEnrolled;


    
    public enroll_table() {
        initComponents();

        displayUsers();
    }


    private void enrollStudent() {
        int rowIndex = studentstable.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a student from the table!");
            return;
        }

        try {
            connectDB db = new connectDB();
            Connection conn = db.getConnection();
            TableModel tbl = studentstable.getModel();

            // Get student ID from selected row
            int studentID = Integer.parseInt(tbl.getValueAt(rowIndex, 0).toString());

            // Get selected values
            String selectedProgram = program.getSelectedItem().toString();
            String selectedCourseCode = course.getSelectedItem().toString();
            String selectedYearLevel = yl.getSelectedItem().toString();
            String selectedSection = section.getSelectedItem().toString();
            String dateEnrolledValue = dateEnrolled.getText().trim();

            if (dateEnrolledValue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the enrollment date.");
                return;
            }

            // Query for program_id
            PreparedStatement pstProgram = conn.prepareStatement(
                "SELECT program_id FROM tbl_program WHERE program_name = ?");
            pstProgram.setString(1, selectedProgram);
            ResultSet rsProgram = pstProgram.executeQuery();

            if (!rsProgram.next()) {
                JOptionPane.showMessageDialog(this, "Program not found!");
                pstProgram.close();
                conn.close();
                return;
            }
            int programID = rsProgram.getInt("program_id");
            pstProgram.close();

            // Query for course_id
            PreparedStatement pstCourse = conn.prepareStatement(
                "SELECT course_id FROM tbl_course WHERE course_code = ?");
            pstCourse.setString(1, selectedCourseCode);
            ResultSet rsCourse = pstCourse.executeQuery();

            if (!rsCourse.next()) {
                JOptionPane.showMessageDialog(this, "Course not found!");
                pstCourse.close();
                conn.close();
                return;
            }
            int courseID = rsCourse.getInt("course_id");
            pstCourse.close();

            // Insert enrollment record
            PreparedStatement pstInsert = conn.prepareStatement(
                "INSERT INTO tbl_enrollment (studentID, course_id, program_id, year_level, section, date_enrolled) " +
                "VALUES (?, ?, ?, ?, ?, ?)");
            pstInsert.setInt(1, studentID);
            pstInsert.setInt(2, courseID);
            pstInsert.setInt(3, programID);
            pstInsert.setString(4, selectedYearLevel);
            pstInsert.setString(5, selectedSection);
            pstInsert.setString(6, dateEnrolledValue);

            int row = pstInsert.executeUpdate();
            pstInsert.close();
            conn.close();

            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Student enrolled successfully!");
                displayUsers(); // Refresh the table
                // Clear input fields
                dateEnrolled.setText("");
                program.setSelectedIndex(0);
                course.setSelectedIndex(0);
                yl.setSelectedIndex(0);
                section.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "Enrollment failed.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, "Invalid student ID format.");
        }
    }

    public void displayUsers() {
        try {
            connectDB db = new connectDB();
            ResultSet rs = db.getData("SELECT * FROM tbl_enrollment");
            studentstable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentstable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(26, 6, 74));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(studentstable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 640, 450));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/graduation_16584819.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reference_17314467.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Enroll Student");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rejected-file_13088156 (1).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Update Enrollment");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/undo_12209127 (2).png"))); // NOI18N
        jLabel8.setText("Back");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Delete Enrollment");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("List of Students");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 640, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Enrollment Page");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/contract_987466.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 860, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        dashb enroll_table = new dashb();
        enroll_table.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
      enroll enroll_table = new enroll();
        enroll_table.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jPanel2MouseClicked

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
            java.util.logging.Logger.getLogger(enroll_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(enroll_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(enroll_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(enroll_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new enroll_table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable studentstable;
    // End of variables declaration//GEN-END:variables
}
