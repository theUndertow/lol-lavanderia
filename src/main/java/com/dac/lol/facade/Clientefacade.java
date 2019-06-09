/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.facade;

import com.dac.lol.dao.ClienteDAO;
import com.dac.lol.dao.UsuarioDAO;
import com.dac.lol.model.Cliente;
import com.dac.lol.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Clientefacade {
    public static List<Usuario> listaAllClients(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.selectListUsuarioCliente();
    }

    public static Usuario selectClient(Long id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.selectUsuario(id);
    }
}
