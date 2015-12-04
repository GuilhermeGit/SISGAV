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
import javax.persistence.Table;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Column(nullable = false)
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String usuario;

    @Column
    private String senha;
    
    // Valor a ser pego pelo iReport
    @Column
    private int PegaID;
    
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    

    /**
     * @return the ID
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String verificarUsuario() {
        if (util.Util.isUsuarioValido(usuario, senha)) {
            return "sucesso";
        } else {
            return "erro";
        }
    }

    /**
     * @return the PegaID
     */
    public int getPegaID() {
        return PegaID;
    }

    /**
     * @param PegaID the PegaID to set
     */
    public void setPegaID(int PegaID) {
        this.PegaID = PegaID;
    }

}
