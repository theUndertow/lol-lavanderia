/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.facade.CadastroPedidoFacade;
import com.dac.lol.model.Pedido;
import com.dac.lol.model.Roupa;
import com.dac.lol.model.Tipo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "cadastroPedido")
@SessionScoped
public class CadastroPedidoManbe implements Serializable{
    private List<Tipo> listaTipos;
    private List<TipoQuantidade> listaTipoQuantidade = new ArrayList<>();
    
    private Pedido pedido;
    private Roupa roupa;
    private Tipo tipoSelecionado;
    
    private String error;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Tipo> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(List<Tipo> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public Tipo getTipoSelecionado() {
        return tipoSelecionado;
    }

    public void setTipoSelecionado(Tipo tipoSelecionado) {
        this.tipoSelecionado = tipoSelecionado;
    }

    public Roupa getRoupa() {
        return roupa;
    }

    public void setRoupa(Roupa roupa) {
        this.roupa = roupa;
    }

    public List<TipoQuantidade> getListaTipoQuantidade() {
        return listaTipoQuantidade;
    }

    public void setListaTipoQuantidade(List<TipoQuantidade> listaTipoQuantidade) {
        this.listaTipoQuantidade = listaTipoQuantidade;
    }
    
    
    @PostConstruct
    public void init() {
        pedido = new Pedido();
        roupa = new Roupa();
        
        listaTipos = CadastroPedidoFacade.selectAllType();
        tipoSelecionado = CadastroPedidoFacade.selectTypeId(Long.parseLong("1"));
        listaTipoQuantidade.add(new TipoQuantidade(tipoSelecionado,10));
    }

    public void addTipoQuantidade(TipoQuantidade tipoQuantidade) {
        listaTipoQuantidade.add(tipoQuantidade);
    }
    
    public void deleteRow(TipoQuantidade tipoQuantidade){
        listaTipoQuantidade.remove(tipoQuantidade);
    }
}
