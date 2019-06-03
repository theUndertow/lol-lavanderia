/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.dao;

import com.dac.lol.model.Cliente;
import com.dac.lol.model.Pedido;
import com.dac.lol.model.Roupa;
import com.dac.lol.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author marco
 */
public class CadastroPedidoDAO {

    public void saveOrder(Pedido pedido, List<Roupa> roupas) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Pedido pedidoTemp = (Pedido) session.get(Pedido.class, pedido.getId());
            for (Roupa roupa : roupas) {
                Roupa roupaTemp = (Roupa) session.get(Roupa.class, roupa.getId());
                pedidoTemp.getRoupas().add(roupaTemp);
                roupaTemp.getPedidos().add(pedidoTemp);
            }
            session.save(pedidoTemp);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    
    public List<Pedido> listaAllOrders(Cliente client){
        List<Pedido> orders = new ArrayList<>();
        String HQL = "from Pedido where pedido_cliente = :id_client";
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(HQL).setParameter("id_client", client.getId());
            orders = query.list();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        return orders;
    }
}
