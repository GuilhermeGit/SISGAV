/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Guilherme
 */
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraBanco {
    public static void main (String [] args){
    	try {
    		Configuration cfg = new Configuration();
            cfg.configure();
            SchemaExport se = new SchemaExport(cfg);
            se.create(true, true);
            JOptionPane.showMessageDialog(null, "O Banco de Dados foi gerado com sucesso!",
            		"Fafica .:. Alerta",JOptionPane.INFORMATION_MESSAGE);
		} catch (HibernateException | HeadlessException e) {
			System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao Gerar a Base de Dados!",
            	"Fafica .:. Alerta",JOptionPane.ERROR_MESSAGE);
		}
    }
}