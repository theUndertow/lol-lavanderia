/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.criptografia.MDFive;
import com.dac.lol.facade.CadastroFacade;
import com.dac.lol.model.*;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import sun.security.provider.MD5;

/**
 *
 * @author marco
 */
@Named(value = "cadastroManbe")
@RequestScoped
public class CadastroManbe {

    private List<Estado> listaEstados;
    private List<Cidade> listaCidades;
    private Estado estadoSelecionado;
    private Cidade cidadeSelecionada;
    private CadastroFacade cadastroFacade;
    private Usuario usuario;
    private Cliente cliente;
    private Funcionario funcionario;
    private Endereco endereco;

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

    public CadastroFacade getCadastroFacade() {
        return cadastroFacade;
    }

    public void setCadastroFacade(CadastroFacade cadastroFacade) {
        this.cadastroFacade = cadastroFacade;
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
    
    @PostConstruct
    public void init() {
        //initiate objects
        usuario = new Usuario();
        cliente = new Cliente();
        funcionario = new Funcionario();
        cadastroFacade = new CadastroFacade();
        endereco = new Endereco();
        
        listaEstados = cadastroFacade.selectAllState();
        estadoSelecionado = cadastroFacade.selectStateId(Long.parseLong("10"));
        listaCidades = cadastroFacade.selectAllCityById(estadoSelecionado.getId());
    }

    public void buscarCidades() {
        if(estadoSelecionado != null)
            listaCidades = cadastroFacade.selectAllCityById(estadoSelecionado.getId());
    }
    
    public void cadastroUsuario(){
        if(usuario.getTipo() == 'c'){
            cadastroCliente();
        }else if(usuario.getTipo() == 'f'){
            cadastroFuncionario();
        }
    }
    
    public void cadastroCliente(){
        
        // Set the city to address
        endereco.setCidade(cidadeSelecionada);
        
        // Set client to the user
        usuario.setCliente(cliente);
        
        // Set user to the client
        cliente.setUsuario(usuario);
        
        // encrypt the actual pass 
        String newPass = MDFive.encripta(usuario.getSenha());
        usuario.setSenha(newPass);
        
        // set address to the cliente
        cliente.setEndereco(endereco);
        
        // Pass the user and client to facade to make the register
        if(!cadastroFacade.registerCliente(usuario, cliente)){
            
        }
    }
    
    public void cadastroFuncionario(){
        System.out.println("\n\tEmail " + usuario.getEmail());
        System.out.println("\n\tNome " + usuario.getNome());
        System.out.println("\n\tSenha " + usuario.getSenha());
        System.out.println("\n\tTipo " + usuario.getTipo());
        
        System.out.println("\n\tMatricula" + funcionario.getMatricula());
        System.out.println("\n\tNascimento" + funcionario.getNascimento().toString());
    }
}


