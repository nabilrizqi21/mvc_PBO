/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pack.control.login_koneksi;

/**
 *
 * @author Nabil Rizki
 */
public class login extends javax.swing.JFrame {

    static String useraktif;
    String user;
    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        etNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BSignIn = new javax.swing.JButton();
        BSignUp = new javax.swing.JButton();
        BExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(null);
        jPanel2.add(etNama);
        etNama.setBounds(120, 90, 220, 30);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("League Spartan", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 90, 70, 30);

        jLabel2.setFont(new java.awt.Font("League Spartan", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 130, 70, 30);
        jPanel2.add(etPass);
        etPass.setBounds(120, 130, 220, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel3.setText("LOGIN");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(170, 0, 120, 70);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 420, 190);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        BSignIn.setText("Sign In");
        BSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSignInActionPerformed(evt);
            }
        });
        jPanel1.add(BSignIn);
        BSignIn.setBounds(50, 210, 80, 30);

        BSignUp.setText("Sign Up");
        BSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSignUpActionPerformed(evt);
            }
        });
        jPanel1.add(BSignUp);
        BSignUp.setBounds(170, 210, 80, 30);

        BExit.setText("Exit");
        BExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExitActionPerformed(evt);
            }
        });
        jPanel1.add(BExit);
        BExit.setBounds(300, 210, 80, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 420, 280);

        setSize(new java.awt.Dimension(436, 320));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSignInActionPerformed
        // TODO add your handling code here:
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/mvp?zeroDate TimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, etNama.getText());
            ps.setString(2, etPass.getText());
            ResultSet result =ps.executeQuery();
            if(result.next()){
                new home().show();
                useraktif = etNama.getText(); //perlu deklarasi user diclass utama.
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                etPass.setText("");
                etNama.requestFocus();
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"Gagal!");
        }
    }//GEN-LAST:event_BSignInActionPerformed

    private void BSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSignUpActionPerformed
        // TODO add your handling code here:
        String username = etNama.getText();
        String password = etPass.getText();

        try {
            try (Statement statement = (Statement) login_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO tb_akun(username,password) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null, "Selamat! anda berhasil Sign Up");
        }catch(Exception t){
            JOptionPane.showMessageDialog(null,"Mohon maaf, ulangi lagi prosedur");
        }
    }//GEN-LAST:event_BSignUpActionPerformed

    private void BExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BExitActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BExit;
    private javax.swing.JButton BSignIn;
    private javax.swing.JButton BSignUp;
    private javax.swing.JTextField etNama;
    private javax.swing.JPasswordField etPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}