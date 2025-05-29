/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import config.connectDB;
import config.passwordHasher;
import guigrade.welcomepage;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HP745 G3
 */
public class reg_ins extends javax.swing.JFrame {

   
    public reg_ins() {
        initComponents();
        applyComboBoxStyle(ut);
        applyTextFieldStyle(fname);
        applyTextFieldStyle(lname);
        applyTextFieldStyle(em);
        applyTextFieldStyle(cn);
        applyTextFieldStyle(username);
        applyTextFieldStyle(pass);
        applyButtonStyle(register);
        applyButtonStyle(cancel);
        
    }
   private boolean isEmailValid(String email) {
     
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
      
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static String email1,username1;
     public boolean duplicateChecker() {
    connectDB db = new connectDB();
    boolean isDuplicate = false;

    try {
        String query = "SELECT username, email FROM tbl_users WHERE username = ? OR email = ?";
        PreparedStatement pstmt = db.getConnection().prepareStatement(query);
        pstmt.setString(1, username.getText());
        pstmt.setString(2, em.getText());
        ResultSet resultSet = pstmt.executeQuery();

        while (resultSet.next()) { 
            String existingEmail = resultSet.getString("email");
            String existingUsername = resultSet.getString("username");

            if (existingEmail.equals(em.getText())) {
                JOptionPane.showMessageDialog(null, "Email is Already Used");
                em.setText("");
                isDuplicate = true;
            }
            if (existingUsername.equals(username.getText())) {
                JOptionPane.showMessageDialog(null, "Username is Already Used");
                username.setText("");
                isDuplicate = true;
            }
        }

        resultSet.close();
        pstmt.close();
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }

    return isDuplicate;
}
     
     private void applyComboBoxStyle(JComboBox<?> comboBox) {
    // Font and color settings
    comboBox.setBackground(Color.WHITE);
    comboBox.setForeground(new Color(60, 60, 60)); // Dark gray text
    comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    comboBox.setOpaque(true);
    comboBox.setFocusable(true);

    // Default lilac border
    comboBox.setBorder(BorderFactory.createLineBorder(new Color(204, 153, 255), 1));

    // Padding using CompoundBorder
    comboBox.setBorder(BorderFactory.createCompoundBorder(
        comboBox.getBorder(),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));

    // Hover effect using mouse listener
    comboBox.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            comboBox.setBackground(new Color(230, 204, 242)); // Light lilac
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            comboBox.setBackground(Color.WHITE);
        }
    });

    // Focus effect: deeper lilac border on focus
    comboBox.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            comboBox.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 102), 2)); // Deeper lilac
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
            comboBox.setBorder(BorderFactory.createLineBorder(new Color(204, 153, 255), 1)); // Reset to lilac
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
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        cn = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        ut = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sign Up");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        username.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Username", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 230, 60));

        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "First Name", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 230, 60));

        cn.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Contact Number", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        jPanel1.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 230, 60));

        lname.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Last Name", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 230, 60));

        em.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Email", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 230, 60));

        pass.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Password", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 230, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Already have an account?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Sign In");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 50, -1));

        register.setBackground(new java.awt.Color(255, 255, 255));
        register.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        register.setText("Sign Up");
        register.setBorder(null);
        register.setBorderPainted(false);
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel1.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 80, 30));

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 90, 30));

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User Type", "User", "Admin" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        jPanel1.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 210, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Firstname");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Lastname");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Email");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Conatct Number");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Username");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
         sign_in_ins reg_ins = new sign_in_ins();
         reg_ins.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
         
 try {
    connectDB db = new connectDB();
    String hashedPassword = passwordHasher.hashPassword(pass.getText());
    

    if (username.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() ||
        em.getText().isEmpty() || cn.getText().isEmpty() || pass.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields required");
    } else if (duplicateChecker()) {
        System.out.println("Duplicates Existed");
    } else if (!isEmailValid(em.getText())) {
        JOptionPane.showMessageDialog(null, "Invalid email format");
    } else if (!cn.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Contact number must only contain digits");
    } else if (cn.getText().length() > 11) {
        JOptionPane.showMessageDialog(null, "Contact number exceeded");
    } else if (pass.getText().length() < 8) {
        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long");
    } else if (ut.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(null, "Please select a type of user");
    } else if (db.insertData("INSERT INTO tbl_users (username, fname, lname, email, contact, type, pass, status) " +
            "VALUES ('" + username.getText() + "', '" + fname.getText() + "', '" + lname.getText() + "', '" +
            em.getText() + "', '" + cn.getText() + "', '" + ut.getSelectedItem() + "', '" +
            hashedPassword + "', 'Pending')") == 1) {

        
        JOptionPane.showMessageDialog(null, "Submitted Successfully");
        sign_in_ins signInPage = new sign_in_ins();
        signInPage.setVisible(true);
        this.dispose();
    }
} catch (NoSuchAlgorithmException e) {
    System.out.println("" + e);
}

    }//GEN-LAST:event_registerActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
         welcomepage reg_ins = new welcomepage();
         reg_ins.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
       
       
    }//GEN-LAST:event_registerMouseClicked

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

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
            java.util.logging.Logger.getLogger(reg_ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reg_ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reg_ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reg_ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reg_ins().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton register;
    private javax.swing.JTextField username;
    private javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
