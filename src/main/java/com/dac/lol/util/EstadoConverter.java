/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.util;

import com.dac.lol.facade.CadastroFacade;
import com.dac.lol.model.Estado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        CadastroFacade cadastroFacade = new CadastroFacade();
        return cadastroFacade.selectStateSigla(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        CadastroFacade cadastroFacade = new CadastroFacade();
        return ((Estado) value).getSigla();
    }
    
}

