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
@Named(value = "alteracaoManbeFuncionario")
@ViewScoped
public class AlteracaoManbeFuncionario implements Serializable {

    private Usuario usuario;
    private String email;
    private int matricula;
    private Funcionario funcionario;
    private String error;

    

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
        
        usuario = new Usuario();

        usuario = loginManbe.getUsuario();
        email = usuario.getEmail();
        funcionario = usuario.getFuncionario();
        matricula = funcionario.getMatricula();

    }

    public String alterarFuncionario() {

        String newPass = MDFive.encripta(usuario.getSenha());
        usuario.setSenha(newPass);
        this.error = CadastroFacade.updateEmployee(usuario, funcionario, email, matricula);
        if(this.error == null){
            return "funcionario";
        }else{
            return "";
        }
    }
}
