/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.util;

import com.dac.lol.model.Cidade;
import com.dac.lol.model.Cliente;
import com.dac.lol.model.Endereco;
import com.dac.lol.model.Estado;
import com.dac.lol.model.Pedido;
import java.io.Serializable;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author marco
 */
public class Coisa implements Serializable {

    private Pedido pedido;
    private Cliente cliente;
    private Endereco endereco;
    private Estado estado;
    private Cidade cidade;

    public Coisa() {

    }

    public Coisa(Pedido pedido, Cliente cliente, Endereco endereco, Cidade cidade, Estado estado) {
        this.pedido = pedido;
        this.cliente = cliente;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
