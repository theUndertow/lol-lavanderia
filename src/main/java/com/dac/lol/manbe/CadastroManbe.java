/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.criptografia.MDFive;
import com.dac.lol.facade.CadastroFacade;
import com.dac.lol.model.*;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "cadastroManbe")
@RequestScoped
public class CadastroManbe implements Serializable{

    private List<Estado> listaEstados;
    private List<Cidade> listaCidades;
    private Estado estadoSelecionado;
    private Cidade cidadeSelecionada;
    private Usuario usuario;
    private Cliente cliente;
    private Funcionario funcionario;
    private Endereco endereco;
    private String error; // Quem for fazer front end arrumar isso corretamente

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public Estado getEstadoSelecionado() {
        return estadoSelecionado;
    }

    public void setEstadoSelecionado(Estado estadoSelecionado) {
        this.estadoSelecionado = estadoSelecionado;
    }

    public Cidade getCidadeSelecionada() {
        return cidadeSelecionada;
    }

    public void setCidadeSelecionada(Cidade cidadeSelecionada) {
        this.cidadeSelecionada = cidadeSelecionada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @PostConstruct
    public void init() {
        //initiate objects
        usuario = new Usuario();
        cliente = new Cliente();
        funcionario = new Funcionario();
        endereco = new Endereco();

        listaEstados = CadastroFacade.selectAllState();
        estadoSelecionado = CadastroFacade.selectStateId(Long.parseLong("10"));
        listaCidades = CadastroFacade.selectAllCityById(estadoSelecionado.getId());
    }

    public void buscarCidades() {
        if (estadoSelecionado != null) {
            listaCidades = CadastroFacade.selectAllCityById(estadoSelecionado.getId());
        }
    }

    public void cadastroCliente() {
        // Check the type of a user to add a database
        // encrypt the actual pass 
        
        
        String newPass = MDFive.encripta(usuario.getSenha());
        System.out.println("\t SENHA :" + usuario.getSenha());
        usuario.setSenha(newPass);
        
        usuario.setTipo('c');
        System.out.println("\n\n\n\n\n\n\nCLIENTE");
        
        // set the state for the selected city
        
        
        // Set the city to address
        endereco.setCidade(cidadeSelecionada);

        // set address to the cliente
        cliente.setEndereco(endereco);

        // Set client to the user
        usuario.setCliente(cliente);

        // Set user to the client
        cliente.setUsuario(usuario);

        // Pass the user and client to facade to make the register
        this.error = CadastroFacade.registerCliente(usuario, cliente);

    }

    public void cadastroFuncionario() {
        // Check the type of a user to add a database
        // encrypt the actual pass 
        String newPass = MDFive.encripta(usuario.getSenha());
        usuario.setSenha(newPass);

        usuario.setTipo('f');
        System.out.println("\n\n\n\n\n\n\nFUNCIONARIO");
        // Set user to a employee 
        usuario.setFuncionario(funcionario);

        // Set employee to a user
        funcionario.setUsuario(usuario);
        // Pass the user and employee to facade to make the register
        this.error = CadastroFacade.registerFuncionario(usuario, funcionario);
    }
}
