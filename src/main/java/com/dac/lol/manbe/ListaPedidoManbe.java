/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.facade.PedidoFacade;
import com.dac.lol.model.Pedido;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

/**
 *
 * @author marco
 */
@Named(value = "listaPedidoManbe")
@RequestScoped
public class ListaPedidoManbe {
    private String nome;
    private List<Pedido> listaPedidos;
    
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
    
    @Inject
    LoginManbe loginManbe;
    
    @PostConstruct
    public void init(){
        listaPedidos = PedidoFacade.allOrders(loginManbe.getUsuario().getCliente());
    }
    
    public String removeOrder(Pedido order){
        PedidoFacade.removeOrder(order.getId());
        listaPedidos = PedidoFacade.allOrders(loginManbe.getUsuario().getCliente());
        return "/cliente_lista_pedido.xhtml";
    }
    
}
