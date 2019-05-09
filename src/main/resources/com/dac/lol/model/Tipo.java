/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.model;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marco
 */
@Entity
@Named(value="tb_tipo")
public class Tipo {
    private long tipo_id;
    private float tipo_preco;
    private int tipo_prazo;

    public Tipo() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(long tipo_id) {
        this.tipo_id = tipo_id;
    }

    public float getTipo_preco() {
        return tipo_preco;
    }

    public void setTipo_preco(float tipo_preco) {
        this.tipo_preco = tipo_preco;
    }

    public int getTipo_prazo() {
        return tipo_prazo;
    }

    public void setTipo_prazo(int tipo_prazo) {
        this.tipo_prazo = tipo_prazo;
    }
    
    
}
