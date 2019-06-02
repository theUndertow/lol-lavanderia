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
import com.dac.lol.util.TipoQuantidade;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UICommand;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "cadastroPedido")
@RequestScoped
public class CadastroPedidoManbe {

    private Pedido pedido;
    private Roupa roupa;
    private CadastroPedidoFacade cadastroPedidoFacade;
    private List<Tipo> listaTipos;
    private Tipo tipoSelecionado;
    private TipoQuantidade tipoQuantidade;
    private List<TipoQuantidade> listaTipoQuantidade;
    private String error;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public CadastroPedidoFacade getCadastroPedidoFacade() {
        return cadastroPedidoFacade;
    }

    public void setCadastroPedidoFacade(CadastroPedidoFacade cadastroPedidoFacade) {
        this.cadastroPedidoFacade = cadastroPedidoFacade;
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

    public TipoQuantidade getTipoQuantidade() {
        return tipoQuantidade;
    }

    public void setTipoQuantidade(TipoQuantidade tipoQuantidade) {
        this.tipoQuantidade = tipoQuantidade;
    }

    @PostConstruct
    public void init() {
        cadastroPedidoFacade = new CadastroPedidoFacade();
        pedido = new Pedido();
        roupa = new Roupa();
        
        listaTipos = cadastroPedidoFacade.selectAllType();
        tipoSelecionado = cadastroPedidoFacade.selectTypeId(Long.parseLong("1"));
    }

    public void adicionar() {
        tipoQuantidade = new TipoQuantidade(tipoSelecionado,roupa.getQuantidade());
        listaTipoQuantidade = cadastroPedidoFacade.addTypeQuantity(this.listaTipoQuantidade, tipoQuantidade);
        if (!listaTipoQuantidade.isEmpty()) {
            for (TipoQuantidade tipoQuantidade : listaTipoQuantidade) {
                System.out.println(tipoQuantidade.getTipo().getNome() + "\t quantidade" + tipoQuantidade.getQuantidade());
            }
        }
    }
}
