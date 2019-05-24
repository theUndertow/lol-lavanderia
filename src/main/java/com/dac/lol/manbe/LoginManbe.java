/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

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

    public String verifyLogin(){
        
        //System.out.println("Login: "+this.getLogin());
        //System.out.println("Senha: "+this.getPassword());
        return "success";
    }
    
}
