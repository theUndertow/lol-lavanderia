/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.dao;

import com.dac.lol.model.Usuario;
import com.dac.lol.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author marco
 */
public class LoginDAO {
    public Usuario selectUsuario(String login, String password) {
        Usuario usuario = new Usuario();
        String HQL = "from Usuario u where usuario_email = :login and"
                            + " usuario_senha_criptografada = :password";
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(HQL).
                    setParameter("login", login).setParameter("password", password);
            usuario = (Usuario) query.uniqueResult();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
