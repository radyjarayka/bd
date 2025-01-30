/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package radyja_bd;

import java.sql.*;

/**
 *
 * @author 20221074010021
 */
public class Radyja_bd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Connection con = null;

        Customer c = new Customer(2, "Tim", "Cook", "tim.cook@apple.com.br", 0, 0);
        try {
            con = new ConnectionFactory().getConnection();
            System.out.println("Conexao OK!");

            //************** CRUD **************
            //CREATE - Inserir
            String sql = "insert into customer"
                    + "(set store_id=?, first_name, last_name=?, email=?, address_id=?, active=?)"
                    + "values"
                    + "(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, c.getStore_id());
            pst.setString(2, c.getFirst_name());
            pst.setString(3, c.getLast_name());
            pst.setString(4, c.getEmail());
            pst.setInt(5, c.getAddress_id());
            pst.setInt(6, c.getActive());

            pst.execute();
            pst.close();
            System.out.println("Customer ADDED!");

            //READ - Consultas
            Statement st = con.createStatement();

            String query = "select * from customer"
                    + " order by customer_id desc"
                    + " limit 5";

            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData md = rs.getMetaData();
            int col = md.getColumnCount();

            System.out.println("Tabela:" + md.getTableName(1));
            for (int i = 1; i <= col; i++) {
                System.out.print(md.getColumnName(i) + "\t");

            }
            System.out.println("");

            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");

                }
                System.out.println("");
            }
 
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            con.close();
        }

    }
}
