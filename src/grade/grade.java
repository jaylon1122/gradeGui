/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade;

import config.connectDB;
import guigrade.ins_dashb;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author HP745 G3
 */
public class grade extends javax.swing.JFrame {

    /**
     * Creates new form grade
     */
    public grade() {
        initComponents();
    }
          connectDB db = new connectDB(); 

   private boolean addGrade(String full_name, JComboBox<String> pg, JComboBox<String> yl, 
                         JComboBox<String> sub, JComboBox<String> ins, JComboBox<String> ay, 
                         JComboBox<String> ap, JComboBox<String> at, String grade) {
    boolean isInserted = false;

    try {
        String query = "INSERT INTO tbl_grade (full_name, program, yr_lvl, subject, instructor, acad_yr, acad_period, acad_terms, grade) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement pstmt = db.getConnection().prepareStatement(query);
        
        pstmt.setString(1, full_name);
        pstmt.setString(2, (String) pg.getSelectedItem());
        pstmt.setString(3, (String) yl.getSelectedItem());
        pstmt.setString(4, (String) sub.getSelectedItem());
        pstmt.setString(5, (String) ins.getSelectedItem());
        pstmt.setString(6, (String) ay.getSelectedItem());
        pstmt.setString(7, (String) ap.getSelectedItem());
        pstmt.setString(8, (String) at.getSelectedItem());
        pstmt.setString(9, grade);

        int rowsInserted = pstmt.executeUpdate();

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Grade added successfully!");
            isInserted = true;
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add grade. Please check your inputs.");
        }

        pstmt.close();
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }

    return isInserted;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        fullname = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        pg = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        yl = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sub = new javax.swing.JComboBox<>();
        ins = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        at = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ap = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        gr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ay = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/document_13596608.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Grade Manipulation");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 550, 20));

        fullname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Name of Student"));
        fullname.setEnabled(false);
        jPanel1.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 210, 50));

        id.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Id"));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 210, 50));

        pg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSIT" }));
        pg.setBorder(null);
        pg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pgActionPerformed(evt);
            }
        });
        jPanel1.add(pg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Program");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        yl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Year", "2nd Year", "3rd Year", "4thYear" }));
        jPanel1.add(yl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 200, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Year Level");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Subject");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        sub.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PF205", "IM207", "NET208", "IPT209" }));
        jPanel1.add(sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 210, 40));

        ins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr.Bustamante", "Mr.Dajay", "Mr.Aripal", "Mr.Cilin" }));
        jPanel1.add(ins, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 210, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Instructor");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        at.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        at.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prelim", "Midterm", "Pre-Final", "Final" }));
        jPanel1.add(at, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 210, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Academic Terms");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, -1));

        ap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester" }));
        jPanel1.add(ap, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 210, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Academic Period");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        gr.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Grade"));
        jPanel1.add(gr, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 210, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 110, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Quit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, -1));

        ay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023-2024", "2024-2025", "2025-2026" }));
        jPanel1.add(ay, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 210, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Academic Year");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 700, 420));

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pgActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        grade_dashb grade = new grade_dashb();
        grade.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      connectDB db = new connectDB(); 


    if (fullname.getText().isEmpty() || gr.getText().isEmpty()) {
         JOptionPane.showMessageDialog(null, "All fields are required");

    } else if (!gr.getText().matches("\\d+(\\.\\d+)?")) {
         JOptionPane.showMessageDialog(null, "Grade must be a valid number!");


    } else if (pg.getSelectedItem() == null || yl.getSelectedItem() == null || sub.getSelectedItem() == null ||
           ins.getSelectedItem() == null || ay.getSelectedItem() == null || ap.getSelectedItem() == null ||
           at.getSelectedItem() == null) {
                 JOptionPane.showMessageDialog(null, "Please select all required fields!");

    } else {
   
         String sql = "INSERT INTO tbl_grade (full_name, program, yr_lvl, subject, instructor, acad_yr, acad_period, acad_terms, grade) " +
                 "VALUES ('" + fullname.getText() + "', '" + pg.getSelectedItem() + "', '" + yl.getSelectedItem() + "', '" + 
                 sub.getSelectedItem() + "', '" + ins.getSelectedItem() + "', '" + ay.getSelectedItem() + "', '" + 
                 ap.getSelectedItem() + "', '" + at.getSelectedItem() + "', '" + gr.getText() + "')";
    
                System.out.println("SQL Query: " + sql); 
    
    if (db.insertData(sql) == 1) {
        JOptionPane.showMessageDialog(null, "Grade added successfully!");
    } else {
        JOptionPane.showMessageDialog(null, "Database insertion failed!");
    }
}

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(grade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(grade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(grade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(grade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new grade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ap;
    private javax.swing.JComboBox<String> at;
    private javax.swing.JComboBox<String> ay;
    private javax.swing.JTextField fullname;
    private javax.swing.JTextField gr;
    private javax.swing.JTextField id;
    private javax.swing.JComboBox<String> ins;
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
    private javax.swing.JComboBox<String> pg;
    private javax.swing.JComboBox<String> sub;
    private javax.swing.JComboBox<String> yl;
    // End of variables declaration//GEN-END:variables
}
