/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.facade;

import com.dac.lol.dao.LoginDAO;
import com.dac.lol.model.Usuario;

/**
 *
 * @author marco
 */
public class LoginFacade {
    public static Usuario FazerLogin(String login, String senha){
        LoginDAO dao = new LoginDAO();
        Usuario usuario = new Usuario();
        usuario = dao.selectUsuario(login, senha);
        return usuario;
    }
}
