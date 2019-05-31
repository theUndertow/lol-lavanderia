package com.dac.lol.facade;

import com.dac.lol.dao.CidadeDAO;
import com.dac.lol.dao.EstadoDAO;
import com.dac.lol.dao.LoginDAO;
import com.dac.lol.model.Cidade;
import com.dac.lol.model.Estado;
import com.dac.lol.model.Usuario;
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
        
}
