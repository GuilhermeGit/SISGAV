/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTable;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Logica.Funcionario;

/**
 *
 * @author Guilherme
 */
public class FuncionarioTableModel extends AbstractTableModel {

    private List<Funcionario> funcionarios = new ArrayList<>();
    private String[] nomeColunas = {
        "ID", "Nome", "Telefone", "Endereço", "Cidade", "Estado", "DataNascimento", " Sexo ", " CPF ", " RG ", " Admissao ", "Função", "Matricula ", "Exoneração", "Secretaria", "Prateleira", "Caixa", "Envelope"
    };

    public FuncionarioTableModel(List<Funcionario> funcionarios) {
        this.funcionarios.clear();
        this.funcionarios.addAll(funcionarios);
    }

    @Override
    public int getRowCount() {
        return funcionarios.size();
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
            case 3:
                return nomeColunas[3];
            case 4:
                return nomeColunas[4];
            case 5:
                return nomeColunas[5];
            case 6:
                return nomeColunas[6];
            case 7:
                return nomeColunas[7];
            case 8:
                return nomeColunas[8];
            case 9:
                return nomeColunas[9];
            case 10:
                return nomeColunas[10];
            case 11:
                return nomeColunas[11];
            case 12:
                return nomeColunas[12];
            case 13:
                return nomeColunas[13];
            case 14:
                return nomeColunas[14];
            case 15:
                return nomeColunas[15];
            case 16:
                return nomeColunas[16];
            case 17:
                return nomeColunas[17];

        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario funcionario = funcionarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return funcionario.getId();
            case 1:
                return funcionario.getNome();
            case 2:
                return funcionario.getTelefone();
            case 3:
                return funcionario.getEndereco();
            case 4:
                return funcionario.getCidade();

            case 5:
                return funcionario.getEstado();
            case 6:
                return funcionario.getNascimento();
            case 7:
                return funcionario.getSexo();
            case 8:
                return funcionario.getCpf();
            case 9:
                return funcionario.getRg();
            case 10:
                return funcionario.getAdmissao();
            case 11:
                return funcionario.getFuncao();

            case 12:
                return funcionario.getMatricula();
            case 13:
                return funcionario.getExoneracao();
            case 14:
                return funcionario.getSecretaria();
            case 15:
                return funcionario.getPrateleira();
            case 16:
                return funcionario.getCaixa();
            case 17:
                return funcionario.getEnvelope();

        }
        return null;
    }

}
