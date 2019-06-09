/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.facade.Clientefacade;
import com.dac.lol.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "cliente")
@RequestScoped 
public class ClienteManbe implements Serializable {

    private List<Usuario> listaUsuarios;
    private Usuario usuarioDetail;
    private Long idInput;

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Long getIdInput() {
        return idInput;
    }

    public void setIdInput(Long idInput) {
        this.idInput = idInput;
    }

    @PostConstruct
    public void init() {
        listaUsuarios = Clientefacade.listaAllClients();
    }

    public String details(Long id) {
        usuarioDetail = Clientefacade.selectClient(id);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioDetail", usuarioDetail);
        return "visualizacao_cliente";
    }

    public void buscaTipo() {
        Usuario temp = Clientefacade.selectClient(idInput);
        if (temp != null) {
            int i = 0;
            for (Usuario u : listaUsuarios) {
                if (u.getId() == temp.getId()) {
                    listaUsuarios.remove(i);
                    listaUsuarios.add(0, temp);
                    break;
                }
                i++;
            }
        }
    }
}
