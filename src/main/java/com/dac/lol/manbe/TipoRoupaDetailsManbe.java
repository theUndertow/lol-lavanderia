/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.model.Tipo;
import com.dac.lol.facade.CadastroTipoRoupaFacade;
import com.dac.lol.facade.PedidoFacade;
import com.dac.lol.model.Pedido;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "tipoRoupaDetails")
@ViewScoped
public class TipoRoupaDetailsManbe implements Serializable{
    private List<Tipo> listaTipos;
    private Long idInput;

    public Long getIdInput() {
        return idInput;
    }

    public void setIdInput(Long idInput) {
        this.idInput = idInput;
    }
    public List<Tipo> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(List<Tipo> listaTipos) {
        this.listaTipos = listaTipos;
    }
    
    @PostConstruct
    public void init(){
        listaTipos = CadastroTipoRoupaFacade.listaAllTypes();
    }
    
    public void removeTipo(Tipo tipo){
        CadastroTipoRoupaFacade.removeType(tipo);
        listaTipos = CadastroTipoRoupaFacade.listaAllTypes();
    }
    
    public void buscaTipo() {
        Tipo temp = CadastroTipoRoupaFacade.selectType(idInput);
        if (temp != null) {
            int i = 0;
            for (Tipo t : listaTipos) {
                if (t.getId() == temp.getId()) {
                    listaTipos.remove(i);
                    listaTipos.add(0, temp);
                    break;
                }
                i++;
            }
        }
    }
}
