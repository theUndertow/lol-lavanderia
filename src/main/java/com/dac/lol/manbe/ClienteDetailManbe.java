/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.model.Pedido;
import com.dac.lol.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "clienteDetail")
@RequestScoped
public class ClienteDetailManbe implements Serializable {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Inject
    LoginManbe loginManbe;

    @PostConstruct
    public void init() {
        
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioDetail");
        if (usuario == null) {
            usuario = new Usuario();
        }
        if (usuario.getId() == 0 || usuario == null) {
            if (loginManbe.getUsuario().getTipo() == 'f') {
                NavigationHandler handler = FacesContext.getCurrentInstance().getApplication().
                        getNavigationHandler();
                handler.handleNavigation(FacesContext.getCurrentInstance(), null, "funcionario?faces-redirect=true");
                // renderiza a tela
                FacesContext.getCurrentInstance().renderResponse();
            }else if (loginManbe.getUsuario().getTipo() == 'c') {
                NavigationHandler handler = FacesContext.getCurrentInstance().getApplication().
                        getNavigationHandler();
                handler.handleNavigation(FacesContext.getCurrentInstance(), null, "cliente?faces-redirect=true");
                // renderiza a tela
                FacesContext.getCurrentInstance().renderResponse();
            }
            return;
        }
    }
}
