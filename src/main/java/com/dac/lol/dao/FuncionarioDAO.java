/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.dao;

import com.dac.lol.model.Funcionario;
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
public class FuncionarioDAO {
    public boolean insertFuncionario(Funcionario funcionario) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(funcionario);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Retornará um único funcionario
    public Funcionario selectFuncionario(int id) {
        Funcionario funcionario = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(
                    "from Funcionario where id = :id");
            query.setInteger("id", id);
            funcionario = (Funcionario) query.uniqueResult();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return funcionario;
    }
    
    // Retorna uma lista de todos os funcionarios
    public List<Funcionario> selectListFuncionario() {
        List<Funcionario> funcionarios;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Funcionario");
            funcionarios = query.list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
        return funcionarios;
    }
    
    // Retorna um boolean em relação ao resultado do update
    public boolean updateFuncionario(Funcionario funcionario) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(funcionario);
            session.getTransaction().commit();
            session.clear();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    // Retorna um boolean em relação a deleção de um funcionario
    public boolean deleteFuncionario(Funcionario funcionario) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(funcionario);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
