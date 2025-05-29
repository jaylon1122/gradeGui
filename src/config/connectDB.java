/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP745 G3
 */
public class connectDB {
    
    private Connection connect;
    
    public connectDB(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradegui", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
      public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
      public int insertData(String sql){
            int result;
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
                result =1;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
                result =0;
            }
            return result;
        }
      public Connection getConnection(){
          return connect;
      }
         // Function to insert/update/delete data (returns number of affected rows)
    public int executeUpdate(String sql) {
        int result = 0;
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            result = pst.executeUpdate();
            System.out.println("Query Executed Successfully!");
        } catch (SQLException ex) {
            System.out.println("Query Execution Error: " + ex.getMessage());
        }
        return result;
    }
   

 public void updateData(String sql){
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                    int rowsUpdated = pst.executeUpdate();
                        if(rowsUpdated > 0){
                            JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
                        }else{
                            System.out.println("Data Update Failed!");
                        }
                        pst.close();
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
            }
        
        }
}

