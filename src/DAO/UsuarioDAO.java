/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import Logica.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Guilherme
 */
public class UsuarioDAO {

    // 1/2 Instancia generica  "remover caso não pegue"
    Usuario usuario = new Usuario();

    private Session sessao;
    private Transaction transacao;

    public void salvar(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(usuario);
        transacao.commit();
        sessao.close();
    }

    public void remover(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(usuario);
        transacao.commit();
        sessao.close();
    }
    
    public List<Usuario> list() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Usuario> usuarios = (List<Usuario>) sessao.createCriteria(Usuario.class).list();
        sessao.close();
        return usuarios;
    }

    public Usuario pesquisaID(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Usuario usuarios = (Usuario) sessao.createCriteria(Usuario.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        sessao.close();
        return usuarios;
    }

    public Usuario pesquisaSenha(String senha) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Usuario usuarios = (Usuario) sessao.createCriteria(Usuario.class).
                add(Restrictions.eq("senha", senha)).uniqueResult();
        sessao.close();
        return usuarios;
    }

    public Usuario pesquisaUsuario(String usuario, String senha) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Usuario usuarios = (Usuario) sessao.createCriteria(Usuario.class).
                add(Restrictions.eq("usuario", usuario)).add(Restrictions.eq("senha", senha)).uniqueResult();
        sessao.close();
        return usuarios;
    }

    public List<Usuario> pesquisaUsuarioiLike(String usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Usuario> usuarios = (List<Usuario>) sessao.createCriteria(Usuario.class).
                add(Restrictions.ilike("usuario", usuario, MatchMode.ANYWHERE)).list();
        sessao.close();
        return usuarios;

    }

    public List<Usuario> pesquisaSenhaiLike(String senha) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Usuario> usuarios = (List<Usuario>) sessao.createCriteria(Usuario.class).
                add(Restrictions.ilike("senha", senha, MatchMode.ANYWHERE)).list();
        sessao.close();
        return usuarios;

    }

    public void Alterar(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.update(usuario);
        transacao.commit();
        sessao.close();

    }

    public Usuario recebeUsuario() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        List<Usuario> usuarioEncontrado = (List<Usuario>) sessao.createCriteria(Usuario.class).add(Restrictions.ne("id", 0)).list();
        sessao.close();
        setUsuario(usuarioEncontrado.get(0));
        return usuarioEncontrado.get(0);
    }

    // 2/2
    private void setUsuario(Usuario usuario) {
        this.usuario = usuario;

    }

    public Usuario recuperarDados(String email) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        Usuario usuarioEncontrado = (Usuario) sessao.createCriteria(Usuario.class)
                .add(Restrictions.ilike("email", email)).uniqueResult();
        sessao.close();
        return usuarioEncontrado;
    }

}
