/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.control;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nabil Rizki
 */
public class c_koneksi {
     public static ResultSet executeQuery(String SQL) { 
        ResultSet rs = null;
        java.sql.Connection koneksi = setKoneksi();    
        try {       
            Statement st = koneksi.createStatement();         
            rs = st.executeQuery(SQL);   
        } catch (SQLException ex) {   
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);  
        }       
        return rs; 
    }  
     
    public static int execute(String SQL) {       
        int status = 0;      
        java.sql.Connection koneksi = setKoneksi();    
        try {        
            Statement st = koneksi.createStatement();   
            status = st.executeUpdate(SQL);    
        } catch (SQLException ex) {        
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);     
        }       
        return status;  
    }
     
    public static java.sql.Connection setKoneksi() {
        String konString = "jdbc:mysql://localhost:3306/mvp";
        java.sql.Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (java.sql.Connection) DriverManager.getConnection(konString, "root", "");
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        } catch (SQLException ex) {
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }
        return koneksi;
    }
 
    
    public static Object getConnection() {       
        return null;        
    }
    
    java.sql.Connection con = null; Statement st = null; ResultSet rs = null; String sql = null;  
    
    public c_koneksi(){ 
        try   
        {    
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mvp","root","");    
            st = con.createStatement(); 
        }     
        catch (Exception a)   
        {  
            JOptionPane.showMessageDialog(null,"Koneksi Database Gagal"+ a);     
        } 
    } 
}