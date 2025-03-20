/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.connectDB;
import grade.grade_dashb;
import guigrade.sign_in_ins;
import guigrade.welcomepage;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import student.student_dashb;
import student.student_data;


/**
 *
 * @author HP745 G3
 */
public class admin_dashb extends javax.swing.JFrame {

  
    public admin_dashb() {
        initComponents();
        displayUsers();
    }
        Color navcolor = new Color(88,88,100);
        Color hovercolor = new Color(164,149,149);
    
     
    public void displayUsers(){
        
        try{
            connectDB db = new connectDB();
        ResultSet rs = db.getData("SELECT * FROM tbl_users");
        userstable.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
        }catch(SQLException e){
            System.out.println("Erros: "+e.getMessage());
        }

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
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        p_add = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        p_update = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        p_delete = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        p_student = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userstable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        acc_lname = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        acc_name = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(88, 88, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Users");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 40));

        logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel3.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Delete");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 100, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("LOGOUT");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Grade");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 90, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ranking");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 270, 90, 50));

        p_add.setBackground(new java.awt.Color(88, 88, 100));
        p_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_addMouseExited(evt);
            }
        });
        p_add.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(89, 82, 92));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add");
        p_add.add(jLabel2);
        jLabel2.setBounds(40, 10, 50, 25);

        jPanel3.add(p_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 130, 40));

        p_update.setBackground(new java.awt.Color(88, 88, 100));
        p_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_updateMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Update");
        p_update.add(jLabel10);

        jPanel3.add(p_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 130, 40));

        p_delete.setBackground(new java.awt.Color(88, 88, 100));
        p_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_deleteMouseExited(evt);
            }
        });
        p_delete.setLayout(null);
        jPanel3.add(p_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 130, 50));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Student");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, -1));

        p_student.setBackground(new java.awt.Color(88, 88, 100));
        p_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_studentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_studentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_studentMouseExited(evt);
            }
        });
        p_student.setLayout(null);
        jPanel3.add(p_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 130, 50));

        jPanel2.setBackground(new java.awt.Color(88, 88, 100));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(null);
        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 130, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 130, 370));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/businessman_6997481.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setText("Admin Dashboard");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        userstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(userstable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 570, 370));

        jPanel4.setBackground(new java.awt.Color(26, 6, 74));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings_14183462 (1).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, -1));

        acc_lname.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        acc_lname.setText("Admin");
        jPanel1.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 540, 10));

        acc_name.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        acc_name.setText("Admin");
        jPanel1.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        acc_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        acc_id.setText("ID");
        jPanel1.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Current User ID:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
       int choice = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Logout Confirmation!",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {

           welcomepage si = new welcomepage();
            si.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();
       if(sess.getId()== 0){
       JOptionPane.showMessageDialog(null,"No Account, Log in First");
       sign_in_ins admin_dashb = new sign_in_ins();
       admin_dashb.setVisible(true);
       this.dispose();
       }else{
            acc_name.setText(""+sess.getFname());
            acc_lname.setText(""+sess.getLname());
            acc_id.setText(""+sess.getId());
       } 
    }//GEN-LAST:event_formWindowActivated

    private void p_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseEntered
       p_add.setBackground(hovercolor);
    }//GEN-LAST:event_p_addMouseEntered

    private void p_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseExited
       p_add.setBackground(navcolor); 
    }//GEN-LAST:event_p_addMouseExited

    private void p_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_updateMouseEntered
        p_update.setBackground(hovercolor);
    }//GEN-LAST:event_p_updateMouseEntered

    private void p_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_updateMouseExited
        p_update.setBackground(navcolor);
    }//GEN-LAST:event_p_updateMouseExited

    private void p_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseClicked
      reg_admin admin_dashb = new reg_admin();
      admin_dashb.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_p_addMouseClicked

    private void p_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseEntered
        p_delete.setBackground(hovercolor); 
    }//GEN-LAST:event_p_deleteMouseEntered

    private void p_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseExited
         p_delete.setBackground(navcolor); 
    }//GEN-LAST:event_p_deleteMouseExited

    private void p_studentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_studentMouseEntered
       p_student.setBackground(hovercolor); 
    }//GEN-LAST:event_p_studentMouseEntered

    private void p_studentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_studentMouseExited
        p_student.setBackground(navcolor); 
    }//GEN-LAST:event_p_studentMouseExited

    private void p_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_studentMouseClicked
         student_dashb admin_dashb = new student_dashb();
         admin_dashb.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_p_studentMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
       grade_dashb admin_dashb = new grade_dashb();
       admin_dashb.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

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
            java.util.logging.Logger.getLogger(admin_dashb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_dashb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_dashb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_dashb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_dashb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel acc_lname;
    private javax.swing.JLabel acc_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel p_add;
    private javax.swing.JPanel p_delete;
    private javax.swing.JPanel p_student;
    private javax.swing.JPanel p_update;
    private javax.swing.JTable userstable;
    // End of variables declaration//GEN-END:variables
}
