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
@Named(value="tb_roupa")
public class Roupa {
    
    private long roupa_id;
    private int roupa_quantidade;
    private Tipo roupa_tipo = new Tipo();

    public Roupa() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getRoupa_id() {
        return roupa_id;
    }

    public void setRoupa_id(long roupa_id) {
        this.roupa_id = roupa_id;
    }

    public int getRoupa_quantidade() {
        return roupa_quantidade;
    }

    public void setRoupa_quantidade(int roupa_quantidade) {
        this.roupa_quantidade = roupa_quantidade;
    }

    public Tipo getRoupa_tipo() {
        return roupa_tipo;
    }

    public void setRoupa_tipo(Tipo roupa_tipo) {
        this.roupa_tipo = roupa_tipo;
    }
    
}
