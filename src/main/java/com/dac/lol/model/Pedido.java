/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author marco
 */
@Entity
@Table(name="tb_pedido")
public class Pedido implements Serializable{
    
    private long id;
    private Date tempo;
    private int prazo;
    private String situacao;
    private float total;
    private Cliente cliente;
    private Collection<Roupa> roupas;

    public Pedido() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "pedido_tempo")
    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }

    @Column(name = "pedido_prazo")
    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    @Column(name = "pedido_situacao")
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Column(name = "pedido_total")
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @ManyToOne
    @JoinColumn(name="pedido_cliente", updatable=true, nullable = false)
    @JsonIgnore
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @ManyToMany(targetEntity=com.dac.lol.model.Roupa.class,
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch=FetchType.EAGER)
    @JoinTable(name="tb_pedido_roupa",
            joinColumns={@JoinColumn(name="pedido")},
            inverseJoinColumns={@JoinColumn(name="roupa")})

    @JsonIgnore
    public Collection<Roupa> getRoupas() {
        return roupas;
    }

    public void setRoupas(Collection<Roupa> roupas) {
        this.roupas = roupas;
    }
    
}
