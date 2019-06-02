/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.facade.CadastroTipoRoupaFacade;
import com.dac.lol.model.Tipo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "cadastroTipoRoupaManbe")
@RequestScoped
public class CadastroTipoRoupaManbe {
    private List<Tipo> listaTipos;
    private Tipo tipoSelecionado;
    private Tipo tipo;
    private CadastroTipoRoupaFacade cadastroTipoRoupaFacade;
    private String error;

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public CadastroTipoRoupaFacade getCadastroTipoRoupaFacade() {
        return cadastroTipoRoupaFacade;
    }

    public void setCadastroTipoRoupaFacade(CadastroTipoRoupaFacade cadastroTipoRoupaFacade) {
        this.cadastroTipoRoupaFacade = cadastroTipoRoupaFacade;
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
    
    @PostConstruct
    public void init(){
        tipo = new Tipo();
        cadastroTipoRoupaFacade = new CadastroTipoRoupaFacade();
        
        listaTipos = cadastroTipoRoupaFacade.selectAllType();
        tipoSelecionado = cadastroTipoRoupaFacade.selectTypeId(Long.parseLong("1"));
    }
    
    
    public void cadastroTipo(){
        if(!cadastroTipoRoupaFacade.registerType(tipo)){
            error = "Roupa ja cadastrada no sistema";
        }
    }
}
