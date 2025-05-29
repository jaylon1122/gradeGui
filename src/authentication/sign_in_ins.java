/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import authentication.reg_ins;
import user.ins_dashb;
import admin.admin_dashb;
import config.Session;
import config.connectDB;
import config.passwordHasher;
import dashbaord.dashb;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
 *
 * @author HP745 G3
 */
public class sign_in_ins extends javax.swing.JFrame {

    /**
     * Creates new form sign_in_ins
     */
    public sign_in_ins() {
        initComponents();
        applyButtonStyle(login);
        applyTextFieldStyle(uname);
        applyTextFieldStyle(pw);
     

    }
    

    static String status1;
    static String type1;
    
    public static boolean loginAccount(String username, String password){
        connectDB db = new connectDB();
try {
    String query = "SELECT * FROM tbl_users WHERE username = '" + username + "'";
    ResultSet resultSet = db.getData(query);

    if (resultSet.next()) {
        String storedPassword = resultSet.getString("pass"); // Hashed password from DB
        String rehashedPassword = passwordHasher.hashPassword(password); // Hash entered password

        System.out.println("Stored: " + storedPassword);
        System.out.println("Rehashed: " + rehashedPassword);

        if (storedPassword.equals(rehashedPassword)) {  // ✅ Now comparing hashed values
            status1 = resultSet.getString("status");
            type1 = resultSet.getString("type");

            Session sess = Session.getInstance();
            sess.setId(resultSet.getInt("id"));
            sess.setFname(resultSet.getString("fname"));
            sess.setLname(resultSet.getString("lname"));
            sess.setEmail(resultSet.getString("email"));
            sess.setUsername(resultSet.getString("username"));
            sess.setType(resultSet.getString("type"));
            sess.setStatus(resultSet.getString("status"));

            System.out.println("User ID: " + sess.getId());
            return true;
        } else {
            System.out.println("Password does not match!!");
            return false;
        }
    } else {
        return false;
    }
} catch (SQLException | NoSuchAlgorithmException e) {
    System.out.println("" + e);
    return false;
}
    
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        pw = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        forgot = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sign In");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        uname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uname.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 0, 51))); // NOI18N
        uname.setOpaque(false);
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        jPanel1.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 200, 50));

        pw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pw.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 0, 51))); // NOI18N
        pw.setOpaque(false);
        jPanel1.add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 200, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Don't have an account?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 153));
        jLabel5.setText("Sign Up now!");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        login.setText("Sign In");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 110, 40));

        forgot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        forgot.setText("Forgot Password?");
        forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotMouseClicked(evt);
            }
        });
        jPanel1.add(forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/books_1903469.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Username");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 470, 500));

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
         reg_ins sign_in_ins = new reg_ins();
         sign_in_ins.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        
    }//GEN-LAST:event_loginActionPerformed

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
     try {
    connectDB db = new connectDB();

    if (uname.getText().isEmpty() || pw.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter your username & password !!.");
    } else if (uname.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username cannot be empty.");
    } else if (pw.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password cannot be empty.");
    } else if (loginAccount(uname.getText(), pw.getText())) {
        if (!status1.equals("Active")) {
            JOptionPane.showMessageDialog(null, "Pending Account, Please wait for approval");
        } else if (type1.equals("Admin")) {
            JOptionPane.showMessageDialog(null, "Login successful!");
         
            dashb ad = new dashb();
            ad.setVisible(true);
            this.dispose();
            
        } else if (type1.equals("User")) {
            JOptionPane.showMessageDialog(null, "Login successful!");
            ins_dashb id = new ins_dashb();
            id.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No account type found!");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Invalid Account, Please register first !!");
    }
} catch (Exception e) {
    System.out.println("" + e);
}
        
    }//GEN-LAST:event_loginMouseClicked

    private void forgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseClicked
        forgotpass ins_dashb = new forgotpass();
        ins_dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_forgotMouseClicked

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
            java.util.logging.Logger.getLogger(sign_in_ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sign_in_ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sign_in_ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sign_in_ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sign_in_ins().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField pw;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
