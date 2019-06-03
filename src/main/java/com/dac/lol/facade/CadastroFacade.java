package com.dac.lol.facade;

import com.dac.lol.dao.*;
import com.dac.lol.model.*;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class CadastroFacade {
    //Busca todas as cidades pelo Id do estado (cidades ligadas com estado)
    public static List<Cidade> selectAllCityById(long id){
        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = estadoDAO.selectEstadoId(id);
        List<Cidade> cidades = estado.getCidades();
        return cidades;
    }
    
    //Passa um ID e busca a cidade que possui esse id
    public static Cidade selectCityById(long id){
        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.selectCidade(id);
        return cidade;
    }
    
    public static List<Cidade> selectAllCity(){
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.selectListCidade();
    }
    
    public static List<Estado> selectAllState(){
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.selectListEstado();
    }
    
    public static Estado selectStateSigla(String sigla){
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.selectEstadoSigla(sigla);
    }
    
    public static Estado selectStateId(Long id){
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.selectEstadoId(id);
    }
    
    public static String registerCliente(Usuario user, Cliente client){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        CadastroDAO cadastroDAO = new CadastroDAO();
        
        if(!cadastroDAO.validateEmail(user)){
            return "Cliente com o mesmo email ja adicionado no banco meu bom";
        }
        
        if(!cadastroDAO.validateCPF(client)){
            return "Cliente com o mesmo cpf ja adicionado no banco meu bom";
        }
        
        
        usuarioDAO.insertUsuario(user);
        clienteDAO.insertCliente(client);
        
        return "";
    }
    
    public static String registerFuncionario(Usuario user, Funcionario employee){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        CadastroDAO cadastroDAO = new CadastroDAO();
        
        if(!cadastroDAO.validateEmail(user)){
            return "Funcionario com o mesmo email ja adicionado no banco meu bom";
        }
        
        if(!cadastroDAO.validateMatricula(employee)){
            return "Funcionario com a mesma matricula ja adicionado no banco meu bom";
        }
        usuarioDAO.insertUsuario(user);
        funcionarioDAO.insertFuncionario(employee);
        
        return "";
    }
        
}
