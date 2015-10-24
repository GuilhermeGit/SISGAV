/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import Logica.Funcionario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Guilherme
 */
public class funcionarioDAO {

    private Session sessao;
    private Transaction transacao;

    public void salvar(Funcionario funcionario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(funcionario);
        transacao.commit();
        sessao.close();
    }

    /**
     *
     * @param funcionario
     */
    public void remover(Funcionario funcionario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(funcionario);
        transacao.commit();
        sessao.close();
    }

    /**
     *
     * @param id
     * @return
     */
    public Funcionario pesquisaID(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Funcionario funcionario = (Funcionario) sessao.createCriteria(Funcionario.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        sessao.close();
        return funcionario;
    }

    /**
     *
     * @param nome
     * @return
     */
    public List<Funcionario> pesquisaNomeiLike(String nome) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Funcionario> Funcionarios = (List<Funcionario>) sessao.createCriteria(Funcionario.class).
                add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).list();
        sessao.close();
        return Funcionarios;
    }

    public void Alterar(Funcionario funcionario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.saveOrUpdate(funcionario);
        transacao.commit();
        sessao.close();
    }

    public Funcionario pesquisaCPF(String CPF) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Funcionario funcionarios = (Funcionario) sessao.createCriteria(Funcionario.class).
                add(Restrictions.eq("CPF", CPF)).uniqueResult();
        sessao.close();
        return funcionarios;

    }
    public Funcionario pesquisaRG(String RG) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Funcionario funcionarios = (Funcionario) sessao.createCriteria(Funcionario.class).
                add(Restrictions.eq("RG", RG)).uniqueResult();
        sessao.close();
        return funcionarios;

    }
}
