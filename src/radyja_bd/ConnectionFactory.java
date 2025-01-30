/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radyja_bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author 20221074010021
 */
public class ConnectionFactory {
    
      private final String url = "jdbc:mysql://localhost/sakila";
      private final String usr = "root";
      private final String pwd = "1234";
    
      public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usr, pwd);
        } 



















}
