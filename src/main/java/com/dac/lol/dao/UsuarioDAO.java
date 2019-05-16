/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.dao;

import com.dac.lol.model.Usuario;
import com.dac.lol.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author marco
 */
public class UsuarioDAO {
    public boolean insertUsuario(Usuario endereco) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(endereco);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Retornará um único endereco
    public Usuario selectUsuario(int id) {
        Usuario endereco = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(
                    "from tb_endereco where endereco_id = :id");
            query.setInteger("id", id);
            endereco = (Usuario) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return endereco;
    }
    
    // Retorna uma lista de todos os enderecos
    public List<Usuario> selectListUsuario() {
        List<Usuario> enderecos;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from tb_endereco");
            enderecos = query.list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
        return enderecos;
    }
    
    // Retorna um boolean em relação ao resultado do update
    public boolean updateUsuario(Usuario endereco) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(endereco);
            session.getTransaction().commit();
            session.clear();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    // Retorna um boolean em relação a deleção de um endereco
    public boolean deleteUsuario(Usuario endereco) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(endereco);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
