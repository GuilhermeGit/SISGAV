/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import banco.criaConexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class chamar {

    public JasperPrint relat;
    public Connection conn;

    public chamar() throws SQLException {
        conn = criaConexao.getConexao();
    }

    public JasperPrint exibirRelatorio(int... id) throws SQLException {
        try {
            HashMap map = new HashMap();
            map.put("id", id[0]);

            String arquivo = "src/Relatorios/DeclaracaoINSS.jasper";
            relat = JasperFillManager.fillReport(arquivo, map, conn);

        } catch (JRException erro) {
            throw new RuntimeException(erro);
        }
        return relat;
    }

}
