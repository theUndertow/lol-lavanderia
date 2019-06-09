/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.util;
import com.dac.lol.criptografia.MDFive;
import com.dac.lol.dao.ClienteDAO;
import com.dac.lol.dao.FuncionarioDAO;
import com.dac.lol.dao.PedidoDAO;
import com.dac.lol.dao.RoupaDAO;
import com.dac.lol.dao.UsuarioDAO;
import com.dac.lol.facade.PedidoFacade;
import com.dac.lol.model.Cliente;
import com.dac.lol.model.Endereco;
import com.dac.lol.model.Funcionario;
import com.dac.lol.model.Pedido;
import com.dac.lol.model.Roupa;
import com.dac.lol.model.Usuario;
import com.dac.lol.ws.SaveOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author marco
 */
public class teste {
    public static void main(String args[]){
//        SaveOrder save = new SaveOrder();
//        Pedido pedido = PedidoFacade.selectOrder(Long.parseLong("1"));
//        Cliente cliente = pedido.getCliente();
//        Endereco endereco = cliente.getEndereco();
//        Coisa coisa = new Coisa(pedido, cliente, endereco);
//        save.saveOrder(coisa);
    }
}
