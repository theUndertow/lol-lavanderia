/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dac.lol.manbe.LoginManbe;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author marco
 */
public class Autenticacao implements PhaseListener{

    private static final long serialVersionUID = 1;
    
    @Override
    public void beforePhase(PhaseEvent event) {
        
    }
    
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        if ("/index.xhtml".equals(context.getViewRoot().getViewId()))
            return;
        if ("/cadastro.xhtml".equals(context.getViewRoot().getViewId()))
            return;
        LoginManbe loginManbe = context.getApplication().
        evaluateExpressionGet(context, "#{loginManbe}", LoginManbe.class);
        if (!loginManbe.isLogado()) {
            NavigationHandler handler = context.getApplication().
            getNavigationHandler();
            handler.handleNavigation(context, null,"index?faces-redirect=true");
            // renderiza a tela
            context.renderResponse();
        }
        
    }
    
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}

