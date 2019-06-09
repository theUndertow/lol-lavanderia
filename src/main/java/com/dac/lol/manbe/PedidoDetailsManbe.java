/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.model.Pedido;
import com.dac.lol.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "pedidoDetails")
@ViewScoped
public class PedidoDetailsManbe implements Serializable {

    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    @Inject
    LoginManbe loginManbe;
    
    @PostConstruct
    public void init() {
        pedido = (Pedido) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pedidoDetails");
    }
    
    public String home(){
        Usuario usuario = loginManbe.getUsuario();
        if(usuario.getTipo() == 'c'){
            return "/cliente.xhtml";
        }else if(usuario.getTipo() == 'f'){
            return "/funcionario.xhtml";
        }
        return null;
    }
}
