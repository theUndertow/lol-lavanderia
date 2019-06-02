/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.dao;

import com.dac.lol.model.Tipo;
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
public class CadastroTipoRoupaDAO {
    public boolean verifyName(Tipo type){
        List<Tipo> types = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(
                    "from Tipo where tipo_nome = :name").setParameter("name", type.getNome());
            types =  query.list();
            session.close();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        return (types.isEmpty());
    }
}
