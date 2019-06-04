/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;


import com.dac.lol.facade.PedidoFacade;
import com.dac.lol.model.Cliente;
import com.dac.lol.model.Pedido;
import com.dac.lol.model.Roupa;
import com.dac.lol.model.Tipo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "Pedido")
@ViewScoped
public class PedidoManbe implements Serializable {

    private List<Tipo> listaTipos;
    private List<Roupa> listaRoupas;
    private List<Roupa> roupas;

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

    public List<Roupa> getListaRoupas() {
        return listaRoupas;
    }

    public void setListaRoupas(List<Roupa> listaRoupas) {
        this.listaRoupas = listaRoupas;
    }

    public List<Roupa> getRoupas() {
        return roupas;
    }

    public void setRoupas(List<Roupa> roupas) {
        this.roupas = roupas;
    }

    @PostConstruct
    public void init() {
        pedido = new Pedido();
        roupa = new Roupa();
        listaRoupas = new ArrayList<>();
        roupas = new ArrayList<>();
        
        listaTipos = PedidoFacade.selectAllType();
        tipoSelecionado = PedidoFacade.selectTypeId(Long.parseLong("1"));
    }

    public void addTipoQuantidade() {
        listaRoupas.add(roupa);
    }

    public void deleteRow(Roupa r) {
        listaRoupas.remove(r);
    }

    public void calculate() {
        int total = 0, prazo = 0;
        roupas.clear();
        for (Roupa r : listaRoupas) {
            Roupa temp = new Roupa();
            temp.setQuantidade(r.getQuantidade());
            temp.setTipo(r.getTipo());
            roupas.add(temp);
            total += r.getQuantidade() * r.getTipo().getPreco();
            if (prazo < r.getTipo().getPrazo()) {
                prazo = r.getTipo().getPrazo();
            }
        }
        pedido.setTotal(total);
        pedido.setPrazo(prazo);
    }

    public String order(Cliente client) {
        if (pedido.getTotal() != 0 && pedido.getPrazo() != 0 && !roupas.isEmpty()) {
            pedido.setCliente(client);
            pedido.setSituacao("Em aberto");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, pedido.getPrazo());
            pedido.setTempo(c.getTime());
            PedidoFacade.addOrder(pedido, roupas);
            return "/cliente.xhtml";
        } else {
            return null;
        }
    }
}
