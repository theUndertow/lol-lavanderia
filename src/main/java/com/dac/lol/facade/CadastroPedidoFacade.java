/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.facade;

import com.dac.lol.dao.TipoDAO;
import com.dac.lol.model.Tipo;
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
}
