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
 * @author Roberto Nunes
 */
public class Conexao {

    static Connection con=null;

 public static Connection conectar(){
    try {

        con = DriverManager.getConnection("jdbc:mysql://localhost/livro_veja","root","igc7gng");
    }
    catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return con;
    }

}
