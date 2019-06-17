/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.criptografia.MDFive;
import com.dac.lol.facade.CadastroFacade;
import com.dac.lol.model.Cidade;
import com.dac.lol.model.Cliente;
import com.dac.lol.model.Endereco;
import com.dac.lol.model.Estado;
import com.dac.lol.model.Funcionario;
import com.dac.lol.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "cadastroManbeFuncionario")
@ViewScoped
public class CadastroManbeFuncionario implements Serializable {

    private Usuario usuario;
    private Funcionario funcionario;
    private String error; // Quem for fazer front end arrumar isso corretamente

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    @Inject
    LoginManbe loginManbe;

    @PostConstruct
    public void init() {
        if (loginManbe.getUsuario().getTipo() != 'f') {
            NavigationHandler handler = FacesContext.getCurrentInstance().getApplication().
                    getNavigationHandler();
            handler.handleNavigation(FacesContext.getCurrentInstance(), null, "cliente?faces-redirect=true");
            // renderiza a tela
            FacesContext.getCurrentInstance().renderResponse();
            return;
        }
        //initiate objects
        usuario = new Usuario();
        funcionario = new Funcionario();

    }
    
    public String cadastroFuncionario() {
        // Check the type of a user to add a database
        // encrypt the actual pass 
        String newPass = MDFive.encripta(usuario.getSenha());
        usuario.setSenha(newPass);

        usuario.setTipo('f');
        // Set user to a employee 
        usuario.setFuncionario(funcionario);

        // Set employee to a user
        funcionario.setUsuario(usuario);
        // Pass the user and employee to facade to make the register
        this.error = CadastroFacade.registerFuncionario(usuario, funcionario);
        if(this.error!=null){
            return "funcionario.xhtml";
        }
        
        return "";
    }
}
