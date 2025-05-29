/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import config.connectDB;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import user.ins_dashb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
        applyButtonStyle(add);
        applyTextFieldStyle(fname);
        applyTextFieldStyle(lname);
        applyTextFieldStyle(em);
        applyTextFieldStyle(cn);
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
     private void applyButtonStyle(JButton button) {
    button.setBackground(new Color(245, 245, 245)); // Light gray background
    button.setForeground(new Color(80, 0, 120));    // Deep violet text
    button.setFont(new Font("Segoe UI", Font.BOLD, 14));
    button.setFocusPainted(false);
    button.setBorder(BorderFactory.createLineBorder(new Color(180, 150, 255), 1));
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    button.setOpaque(true);

    // Rounded corners using custom UI
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);

    button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Background color
            g2.setColor(button.getModel().isRollover() ? new Color(220, 200, 255) : new Color(245, 245, 245));
            g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);

            // Draw the text
            super.paint(g, c);
            g2.dispose();
        }
    });

    // Optional: Mouse hover changes text color slightly
    button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setForeground(new Color(100, 0, 150));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setForeground(new Color(80, 0, 120));
        }
    });
}
     private void applyTextFieldStyle(JTextField textField) {
    // Background and text color
    textField.setBackground(Color.WHITE); // White background
    textField.setForeground(new Color(60, 60, 60)); // Dark gray text
    textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    
    // Border and rounded corners
    textField.setBorder(BorderFactory.createLineBorder(new Color(204, 153, 255), 1)); // Lilac border
    textField.setCaretColor(new Color(102, 0, 102)); // Lilac cursor
    textField.setOpaque(true);

    // Rounded corners
    textField.setBorder(BorderFactory.createCompoundBorder(
        textField.getBorder(), 
        BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding inside the text field
    ));

    // Focus effect: stronger lilac border on focus
    textField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            textField.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 102), 2)); // Focus border: lilac
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
            textField.setBorder(BorderFactory.createLineBorder(new Color(204, 153, 255), 1)); // Reset border: lilac
        }
    });
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cn = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 480, 10));

        cn.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contact Number "));
        jPanel2.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 240, 70));

        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "First Name"));
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 240, 70));

        lname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Last Name"));
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 240, 70));

        em.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Email"));
        jPanel2.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 240, 70));

        add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add.setText("Add Student");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 130, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/undo_12209127 (2).png"))); // NOI18N
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Contact Number");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Firstname");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Lastname");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Email");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 640, 360));

        jPanel1.setBackground(new java.awt.Color(26, 6, 74));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
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
    }//GEN-LAST:event_addActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
      student_dashb student_data = new student_dashb();
         student_data.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
    private javax.swing.JButton add;
    private javax.swing.JTextField cn;
    private javax.swing.JTextField em;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lname;
    // End of variables declaration//GEN-END:variables

   
}
