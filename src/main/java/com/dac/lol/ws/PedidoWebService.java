/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.ws;

import com.dac.lol.facade.PedidoFacade;
import com.dac.lol.util.StrangerCoisa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author marco
 */
@Path("delivery")
public class PedidoWebService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PedidoWebService
     */
    public PedidoWebService() {
    }

    /**
     * Retrieves representation of an instance of com.dac.lol.ws.PedidoWebService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "lol";
    }

    /**
     * PUT method for updating or creating an instance of PedidoWebService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postDelivery(String delivery){
        if(delivery!=null){
            Gson gson = new Gson();
            StrangerCoisa strangerCoisa = gson.fromJson(delivery, StrangerCoisa.class);
            //fazer a inserção da entrega com endereço e historico
            PedidoFacade.updateOrderDelivery(strangerCoisa);
            return delivery;
        }else{
            return "NAO DEU";
        }
    }
    
    
}
