/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurar_backup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Guilherme 
 */
public class Conexao {

    static Connection con = null;
    static final String HOST = "localhost";
    static final String PORT = "3306";
    static final String DATABASE = "sisgam";
    static final String USER = "root";
    static final String PASS = "";

    public static Connection conectar() {
        try {

            con = DriverManager.getConnection("jdbc:mysql://".concat(HOST).concat("/").concat(DATABASE), 
                    USER, PASS);
        } catch (SQLException e) {
            System.out.println("erro aqui");
            System.out.println(e.getMessage());
        }
        return con;
    }

}
