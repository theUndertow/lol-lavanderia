/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author marco
 */
@Entity
@Named(value="tb_pedido")
public class Pedido implements Serializable{
    
    private long pedido_id;
    private Date pedido_tempo;
    private int pedido_prazo;
    private String pedido_situacao;
    private float pedido_total;
    private Cliente pedido_cliente;
    private Collection<Roupa> roupas;

    public Pedido() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Date getPedido_tempo() {
        return pedido_tempo;
    }

    public void setPedido_tempo(Date pedido_tempo) {
        this.pedido_tempo = pedido_tempo;
    }

    public int getPedido_prazo() {
        return pedido_prazo;
    }

    public void setPedido_prazo(int pedido_prazo) {
        this.pedido_prazo = pedido_prazo;
    }

    public String getPedido_situacao() {
        return pedido_situacao;
    }

    public void setPedido_situacao(String pedido_situacao) {
        this.pedido_situacao = pedido_situacao;
    }

    public float getPedido_total() {
        return pedido_total;
    }

    public void setPedido_total(float pedido_total) {
        this.pedido_total = pedido_total;
    }

    @ManyToOne
    @JoinColumn(name="pedido_cliente")
    public Cliente getPedido_cliente() {
        return pedido_cliente;
    }

    public void setPedido_cliente(Cliente pedido_cliente) {
        this.pedido_cliente = pedido_cliente;
    }

    
    @ManyToMany(targetEntity=com.dac.lol.model.Roupa.class,
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch=FetchType.EAGER)
    @JoinTable(name="tb_pedido_roupa",
            joinColumns={@JoinColumn(name="pedido")},
            inverseJoinColumns={@JoinColumn(name="roupa")})
    
    public Collection<Roupa> getRoupas() {
        return roupas;
    }

    public void setRoupas(Collection<Roupa> roupas) {
        this.roupas = roupas;
    }
}
