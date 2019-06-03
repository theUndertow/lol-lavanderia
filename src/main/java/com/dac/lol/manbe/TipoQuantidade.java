/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.model.Tipo;

/**
 *
 * @author marco
 */
public class TipoQuantidade {
    private Tipo tipo;
    private int quantidade;

    public TipoQuantidade(Tipo tipo, int quantidade) {
        this.tipo = tipo;
        this.quantidade = quantidade;
    }
    
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
    
    
}
