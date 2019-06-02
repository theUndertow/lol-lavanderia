/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.facade;

import com.dac.lol.dao.TipoDAO;
import com.dac.lol.model.Tipo;
import com.dac.lol.util.TipoQuantidade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class CadastroPedidoFacade {
    public static Tipo selectTypeId(Long id){
        TipoDAO tipoDAO = new TipoDAO();
        return tipoDAO.selectTipo(id);
    }

    public static List<Tipo> selectAllType() {
        TipoDAO tipoDAO = new TipoDAO();
        return tipoDAO.selectListTipo();
    }
    
    public  static List <TipoQuantidade> initializeTypeQuantity(){
        CadastroPedidoFacade cadastroPedidoFacade = new CadastroPedidoFacade();
        List<TipoQuantidade> lista = new ArrayList<>();
        lista.add(new TipoQuantidade(
                cadastroPedidoFacade.selectTypeId(Long.parseLong("1")), 1));
        return lista;
    } 
    
    public static List<TipoQuantidade> addTypeQuantity(List<TipoQuantidade> listaTipoQuantidade, TipoQuantidade tipoQuantidade ){
        
        listaTipoQuantidade.add(tipoQuantidade);
        
        return listaTipoQuantidade;
    }
}
