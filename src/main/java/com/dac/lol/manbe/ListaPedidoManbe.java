/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.facade.PedidoFacade;
import com.dac.lol.model.Pedido;
import com.dac.lol.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author marco
 */
@Named(value = "listaPedidoManbe")
@ViewScoped
public class ListaPedidoManbe implements Serializable {

    private String nome;
    private List<Pedido> listaPedidos;
    private Long id;
    private Usuario usuario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    @Inject
    LoginManbe loginManbe;

    @PostConstruct
    public void init() {
        usuario = loginManbe.getUsuario();
        
        if (usuario.getTipo() == 'c') {
            listaPedidos = PedidoFacade.allOrdersByClients(usuario.getCliente());
        } else if (usuario.getTipo() == 'f') {
            listaPedidos = PedidoFacade.allOrders();
        }
    }

    public String removeOrder(Pedido order) {
        PedidoFacade.removeOrder(order.getId());
        if (usuario.getTipo() == 'c') {
            listaPedidos = PedidoFacade.allOrdersByClients(usuario.getCliente());
        } else if (usuario.getTipo() == 'f') {
            listaPedidos = PedidoFacade.allOrders();
        }
        return null;
    }

    public void pedidosEmAberto() {
        listaPedidos = PedidoFacade.allOpenOrders(usuario.getCliente());
    }

    public void buscaPedido() {
        Pedido temp = PedidoFacade.selectOrder(id);
        if (temp != null) {
            int i = 0;
            for (Pedido p : listaPedidos) {
                if (p.getId() == temp.getId()) {
                    listaPedidos.remove(i);
                    listaPedidos.add(0, temp);
                    break;
                }
                i++;
            }
        }
    }
    
    public void changeSituation(Pedido pedido){
        PedidoFacade.updateOrder(pedido);
    }
}
