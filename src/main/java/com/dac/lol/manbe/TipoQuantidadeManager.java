/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.model.Tipo;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author marco
 */
@Named(value = "tipoQuantidadeManager")
@SessionScoped
public class TipoQuantidadeManager implements Serializable{
    
    private Tipo tipo;
    private int quantidade;
    
    @Inject
    PedidoManbe cadastroPedidoManbe;

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void addNewTipoQuantidade(){
        cadastroPedidoManbe.addTipoQuantidade(new TipoQuantidade(tipo, quantidade));
    }
    
    public String deleteRow(TipoQuantidade tq){
        cadastroPedidoManbe.deleteRow(tq);
        return "/cliente_pedido.xhtml";
    }
    /**
     * Creates a new instance of TipoQuantidadeManager
     */
    public TipoQuantidadeManager() {
    }
    
}
