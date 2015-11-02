/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "Funcionario")
public class Funcionario implements Serializable {

    @Column(nullable = false)
    @GeneratedValue
    @Id
    @PrimaryKeyJoinColumn
    private int id;

    @Column
    private String nome;

    @Column
    private String telefone;

    @Column
    private String cidade;

    @Column
    private String estado;

    @Column
    private String admissao;

    @Column
    private String matricula;

    @Column
    private String exoneracao;

    @Column
    private String sexo;

    @Column
    private String rg;

    @Column
    private String cpf;

    @Column
    private String endereco;

    @Column
    private String nascimento;

    @Column
    private String secretaria;

    @Column
    private String Funcao;

    @Column
    private String prateleira;

    @Column
    private String caixa;
    
    @Column
    private String envelope;
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the admissao
     */
    public String getAdmissao() {
        return admissao;
    }

    /**
     * @param admissao the admissao to set
     */
    public void setAdmissao(String admissao) {
        this.admissao = admissao;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the exoneração
     */
    public String getExoneracao() {
        return exoneracao;
    }

    /**
     * @param exoneracao the exoneração to set
     */
    public void setExoneracao(String exoneracao) {
        this.exoneracao = exoneracao;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rua
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the nascimento
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;

    }

    /**
     * @return the secretaria
     */
    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;

    }

    /**
     * @return the Funcao
     */
    public String getFuncao() {
        return Funcao;
    }

    /**
     * @param Funcao the Funcao to set
     */
    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }

    /**
     * @return the prateleira
     */
    public String getPrateleira() {
        return prateleira;
    }

    /**
     * @param prateleira the prateleira to set
     */
    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    /**
     * @return the caixa
     */
    public String getCaixa() {
        return caixa;
    }

    /**
     * @param caixa the caixa to set
     */
    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    /**
     * @return the envelope
     */
    public String getEnvelope() {
        return envelope;
    }

    /**
     * @param envelope the envelope to set
     */
    public void setEnvelope(String envelope) {
        this.envelope = envelope;
    }

}
