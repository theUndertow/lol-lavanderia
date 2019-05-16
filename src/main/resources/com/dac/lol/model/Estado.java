/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.model;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author marco
 */
@Entity
@Named(value="tb_estado")
public class Estado implements Serializable{
    
    private long estado_id;
    private String estado_nome;
    private String estado_sigla;
    private List<Cidade> cidades;

    public Estado() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(long estado_id) {
        this.estado_id = estado_id;
    }

    public String getEstado_nome() {
        return estado_nome;
    }

    public void setEstado_nome(String estado_nome) {
        this.estado_nome = estado_nome;
    }

    public String getEstado_sigla() {
        return estado_sigla;
    }

    public void setEstado_sigla(String estado_sigla) {
        this.estado_sigla = estado_sigla;
    }
    
    @OneToMany(mappedBy="cidade_estado", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
}
