/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.model;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author marco
 */
@Entity
@Named(value = "tb_cliente")
public class Cliente implements Serializable{
    private long cliente_id;
    private char cliente_sexo;
    private String cliente_telefone;
    private String cliente_cpf;
    private Usuario cliente_usuario = new Usuario();
    private Endereco cliente_endereco = new Endereco();
    private List<Pedido> pedidos;

    public Cliente() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public char getCliente_sexo() {
        return cliente_sexo;
    }

    public void setCliente_sexo(char cliente_sexo) {
        this.cliente_sexo = cliente_sexo;
    }

    public String getCliente_telefone() {
        return cliente_telefone;
    }

    public void setCliente_telefone(String cliente_telefone) {
        this.cliente_telefone = cliente_telefone;
    }

    public String getCliente_cpf() {
        return cliente_cpf;
    }

    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    @OneToOne
    @JoinColumn(name="cliente_usuario", updatable=true)
    public Usuario getCliente_usuario() {
        return cliente_usuario;
    }

    public void setCliente_usuario(Usuario cliente_usuario) {
        this.cliente_usuario = cliente_usuario;
    }

    @ManyToOne
    @JoinColumn(name="cliente_endereco",updatable=true)
    public Endereco getCliente_endereco() {
        return cliente_endereco;
    }

    public void setCliente_endereco(Endereco cliente_endereco) {
        this.cliente_endereco = cliente_endereco;
    }

    @OneToMany(mappedBy="pedido_cliente")
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
