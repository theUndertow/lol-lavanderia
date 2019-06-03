/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.facade;

import com.dac.lol.dao.CadastroPedidoDAO;
import com.dac.lol.dao.PedidoDAO;
import com.dac.lol.dao.RoupaDAO;
import com.dac.lol.dao.TipoDAO;
import com.dac.lol.dao.UsuarioDAO;
import com.dac.lol.model.Pedido;
import com.dac.lol.model.Roupa;
import com.dac.lol.model.Tipo;
import com.dac.lol.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class CadastroPedidoFacade {

    public static Tipo selectTypeId(Long id) {
        TipoDAO tipoDAO = new TipoDAO();
        return tipoDAO.selectTipo(id);
    }

    public static List<Tipo> selectAllType() {
        TipoDAO tipoDAO = new TipoDAO();
        return tipoDAO.selectListTipo();
    }

    public static Usuario getUser(Long id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.selectUsuario(id);
    }

    public static void addOrder(Pedido pedido, List<Roupa> roupas) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        RoupaDAO roupaDAO = new RoupaDAO();
        CadastroPedidoDAO cadastroPedidoDAO  = new CadastroPedidoDAO();
        
        for(Roupa r : roupas){
            roupaDAO.insertRoupa(r);
        }
        pedidoDAO.insertPedido(pedido);
        
        cadastroPedidoDAO.saveOrder(pedido, roupas);
    }
}
