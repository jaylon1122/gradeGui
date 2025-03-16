/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guigrade;

import admin.admin_dashb;
import config.Session;
import config.connectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
    }
    static String status1;
    static String type1;
    
    public static boolean loginAccount(String username, String password){
          connectDB db = new connectDB();
          
        try{
            String query = "SELECT * FROM tbl_users WHERE username = '"+ username +"' AND pass = '"+password+"'";
            ResultSet resultSet = db.getData(query);
           
            if(resultSet.next()){
               
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
                System.out.println(""+sess.getId());
                  return true;
               
            }else{
                return false; 
            }
        }catch(SQLException e){
           
            return false;
        }
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        pw = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile_3135715 (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sign In");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        uname.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Username", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        jPanel1.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 200, -1));

        pw.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Password", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP));
        jPanel1.add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 200, -1));

        jLabel3.setText("Don't have an account?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jLabel5.setForeground(new java.awt.Color(51, 0, 153));
        jLabel5.setText("Sign Up now!");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        jPanel3.setBackground(new java.awt.Color(88, 88, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 330));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 490, 330));

        jPanel2.setBackground(new java.awt.Color(26, 6, 74));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 30));

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
     
        connectDB db = new connectDB();
        if (uname.getText().isEmpty() && pw.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your username & password !!.");
        } else if (uname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please cannot be empty.");
        } else if (pw.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty.");
        } else {
            if (loginAccount(uname.getText(), pw.getText())) {
                if (!status1.equals("Active")) {
                    JOptionPane.showMessageDialog(null, "Pending Account, Please wait for the approval");
                } else {
            JOptionPane.showMessageDialog(null, "Login successful!");
                        
            if (type1.equals("Admin")) {
                admin_dashb  ad= new admin_dashb();
                ad.setVisible(true);
                this.dispose();
            } else if (type1.equals("User")) {
                ins_dashb id = new ins_dashb();
                id.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No account type found!");
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Invalid Account, Please register first !!" );
    }
}

        
        
        
        
        
    }//GEN-LAST:event_loginMouseClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField pw;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
