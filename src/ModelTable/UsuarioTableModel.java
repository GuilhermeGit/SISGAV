/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTable;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Logica.Usuario;

/**
 *
 * @author Guilherme
 */
public class UsuarioTableModel extends AbstractTableModel {

    private List<Usuario> usuarios = new ArrayList<>();
    private String[] nomeColunas = {"id", "usuario", "senha"};

    public UsuarioTableModel(List<Usuario> usuarios) {
        this.usuarios.clear();
        this.usuarios.addAll(usuarios);
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return nomeColunas[0];
            case 1:
                return nomeColunas[1];
            case 2:
                return nomeColunas[2];
            

        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usuario.getId();
            
            case 1:
                return usuario.getUsuario();
            case 2:
                return usuario.getSenha();

        }
        return null;
    }

}
