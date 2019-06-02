/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.facade;

import com.dac.lol.dao.CadastroTipoRoupaDAO;
import com.dac.lol.dao.TipoDAO;
import com.dac.lol.model.Tipo;
import java.util.List;

/**
 *
 * @author marco
 */
public class CadastroTipoRoupaFacade {
    public static boolean registerType(Tipo type){
        TipoDAO tipoDAO = new TipoDAO();
        CadastroTipoRoupaDAO cadastroTipoRoupaDAO = new CadastroTipoRoupaDAO();
        if(cadastroTipoRoupaDAO.verifyName(type)){
            tipoDAO.insertTipo(type);
            return true;
        }
        return false;
    }

    public static Tipo selectTypeId(Long id){
        TipoDAO tipoDAO = new TipoDAO();
        return tipoDAO.selectTipo(id);
    }

    public static List<Tipo> selectAllType() {
        TipoDAO tipoDAO = new TipoDAO();
        return tipoDAO.selectListTipo();
    }
}
