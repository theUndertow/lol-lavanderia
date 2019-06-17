/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.manbe;

import com.dac.lol.facade.PedidoFacade;
import com.dac.lol.model.Pedido;
import com.dac.lol.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marco
 */
@Named(value = "funcionarioPortalManbe")
@ViewScoped
public class FuncionarioPortalManbe implements Serializable{

    private String nome;
    private List<Pedido> listaPedidos;

    private Pedido pedidoDetails;
    private Long idInput;
    private String idCommand;
    private Usuario usuario;
    
    private String error;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Long getIdInput() {
        return idInput;
    }

    public void setIdInput(Long idInput) {
        this.idInput = idInput;
    }

    public String getIdCommand() {
        return idCommand;
    }

    public void setIdCommand(String idCommand) {
        this.idCommand = idCommand;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pedido getPedidoDetails() {
        return pedidoDetails;
    }

    public void setPedidoDetails(Pedido pedidoDetails) {
        this.pedidoDetails = pedidoDetails;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Inject
    LoginManbe loginManbe;

    @PostConstruct
    public void init() {
        
        if (loginManbe.getUsuario().getTipo() != 'f') {
            NavigationHandler handler = FacesContext.getCurrentInstance().getApplication().
                    getNavigationHandler();
            handler.handleNavigation(FacesContext.getCurrentInstance(), null, "cliente?faces-redirect=true");
            // renderiza a tela
            FacesContext.getCurrentInstance().renderResponse();
            return;
        }
        
        usuario = loginManbe.getUsuario();
        listaPedidos = PedidoFacade.allOrders();

    }

    public String removeOrder(Pedido order) {
        if (order.getSituacao().equals("Em aberto")) {
            PedidoFacade.removeOrder(order.getId());
            listaPedidos = PedidoFacade.allOrders();
        }
        return null;
    }

    public void buscaPedido() {
        Pedido temp = PedidoFacade.selectOrder(idInput);
        if (temp != null) {
            int i = 0;
            for (Pedido p : listaPedidos) {
                if (p.getId() == temp.getId()) {
                    listaPedidos.remove(i);
                    listaPedidos.add(0, temp);
                    break;
                }
                i++;
            }
        }
    }

    public void changeSituation(Pedido pedido) {
        this.error = PedidoFacade.updateOrder(pedido);
    }

    public String details(Long id) {

        pedidoDetails = PedidoFacade.selectOrder(id);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pedidoDetails", pedidoDetails);
        return "visualizacao_pedido";
    }
    
    public void pedidosHoje(){
        listaPedidos = PedidoFacade.allOrdersToday();
    }
    
    public void pedidosNaoPagos(){
        listaPedidos = PedidoFacade.allOrders();
    }
    
    public void todosOsPedidos(){
        listaPedidos = PedidoFacade.allOrders();
    }
}
