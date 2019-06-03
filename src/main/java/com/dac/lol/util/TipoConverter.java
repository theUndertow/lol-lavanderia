/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.util;

import com.dac.lol.facade.PedidoFacade;
import com.dac.lol.model.Tipo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoConverter")
public class TipoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        return PedidoFacade.selectTypeId(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        return String.valueOf(((Tipo) value).getId());
    }
}