/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.model;

import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author marco
 */
@Entity
@Named(value="tb_funcionario")
public class Funcionario implements Serializable{
    private long funcionario_id;
    private int funcionario_matricula;
    private Date funcionario_nascimento;
    private Usuario funcionario_usuario;

    public Funcionario() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(long funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public int getFuncionario_matricula() {
        return funcionario_matricula;
    }

    public void setFuncionario_matricula(int funcionario_matricula) {
        this.funcionario_matricula = funcionario_matricula;
    }

    public Date getFuncionario_nascimento() {
        return funcionario_nascimento;
    }

    public void setFuncionario_nascimento(Date funcionario_nascimento) {
        this.funcionario_nascimento = funcionario_nascimento;
    }
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="funcionario_usuario", updatable=true)
    public Usuario getUsuario() {
        return funcionario_usuario;
    }

    public void setUsuario(Usuario funcionario_usuario) {
        this.funcionario_usuario = funcionario_usuario;
    }
    
    
}
