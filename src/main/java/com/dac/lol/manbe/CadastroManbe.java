/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.facade.CadastroFacade;
import com.dac.lol.model.*;
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
    
    public void cadastroCliente(){
        usuario.setTipo('c');
        System.out.println("\n\t Email" + usuario.getEmail());
        System.out.println("\n\t Nome" + usuario.getNome());
        System.out.println("\n\t Senha" + usuario.getSenha());
        System.out.println("\n\t Tipo" + usuario.getTipo());
        
        System.out.println("\n\t CPF" + cliente.getCpf());
        System.out.println("\n\t Telefone" + cliente.getTelefone());
        
        cliente.setEndereco(endereco);
        endereco.setCidade(cidadeSelecionada);
        
        System.out.println("\n\t Bairro" + endereco.getBairro());
        System.out.println("\n\t Complemento" + endereco.getComplemento());
        System.out.println("\n\t Rua" + endereco.getRua());
        System.out.println("\n\t Numero" + endereco.getNumero());
        System.out.println("\n\t Cidade" + endereco.getCidade().getNome());
        System.out.println("\n\t Estado" + cidadeSelecionada.getEstado().getNome());
    }
    
    public void cadastroFuncionario(){
        usuario.setTipo('f');
        System.out.println("\n\tEmail " + usuario.getEmail());
        System.out.println("\n\tNome " + usuario.getNome());
        System.out.println("\n\tSenha " + usuario.getSenha());
        System.out.println("\n\tTipo " + usuario.getTipo());
        
        System.out.println("\n\tMatricula" + funcionario.getMatricula());
        System.out.println("\n\tNascimento" + funcionario.getNascimento().toString());
    }
}


