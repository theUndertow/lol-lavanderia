/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.facade.LoginFacade;
import com.dac.lol.model.Usuario;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author marco
 */
@Named(value = "loginManbe")
@RequestScoped
public class LoginManbe {
    private String login;
    private String password;
    private Usuario usuario;

    /**
     * Creates a new instance of LoginManbe
     */
    public LoginManbe() {
    }

    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String verifyLogin(){
        usuario = LoginFacade.FazerLogin(this.getLogin(), this.getPassword());
        
        if(usuario.getTipo() == 'c')
            return "cliente";
        else if(usuario.getTipo() == 'f')
            return "funcinario";
        else
            return null;
    }
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
}
