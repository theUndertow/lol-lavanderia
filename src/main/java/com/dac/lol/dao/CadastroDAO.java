/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.dao;

import com.dac.lol.model.Cliente;
import com.dac.lol.model.Funcionario;
import com.dac.lol.model.Usuario;
import com.dac.lol.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author marco
 */
public class CadastroDAO {
    
    public boolean validateEmail(Usuario user){
        List<Usuario> users = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(
                    "from Usuario where usuario_email = :email").setParameter("email", user.getEmail());
            users =  query.list();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return (users.isEmpty());
    }
    
    public boolean validateMatricula(Funcionario employee){
        List<Funcionario> employees = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(
                    "from Funcionario where funcionario_matricula = :matricula").setParameter("matricula", employee.getMatricula());
            employees =  query.list();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return (employees.isEmpty());
    }
    public boolean validateCPF(Cliente client){
        List<Cliente> clients = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(
                    "from Cliente where cliente_cpf = :cpf").setParameter("cpf", client.getCpf());
            clients =  query.list();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return (clients.isEmpty());
    }
}

