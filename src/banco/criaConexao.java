/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class criaConexao {

    public static Connection getConexao() throws SQLException {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectado..");
            return DriverManager.getConnection("jdbc:mysql://localhost/sisgam", "root",  "");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
        
       
    }
  
}