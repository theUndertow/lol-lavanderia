/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.criptografia.MDFive;
import com.dac.lol.facade.LoginFacade;
import com.dac.lol.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
/**
 *
 * @author marco
 */

@SessionScoped
@Named(value = "loginManbe")
public class LoginManbe implements Serializable{
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
    
    public boolean isLogado(){
        return this.getLogin() != null;
    }
    
    
    public String verifyLogin(){
        String pass = MDFive.encripta(this.getPassword());
        usuario = LoginFacade.FazerLogin(this.getLogin(), pass);
        if(usuario != null){
            if(usuario.getTipo() == 'c')
                return "cliente";   
            else if(usuario.getTipo() == 'f')
                return "funcionario";
        }
        
        return "index";       
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
}
