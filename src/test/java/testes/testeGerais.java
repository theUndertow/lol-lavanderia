/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import com.dac.lol.criptografia.MDFive;
import com.dac.lol.dao.*;
import com.dac.lol.model.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.dac.lol.criptografia.MDFive;

/**
 *
 * @author marco
 */
public class testeGerais {
    public static void main(String[] args){
        
        // INSERÇÃO DE ESTADO    
        /*    
            Estado estado = new Estado();
            EstadoDAO estadoDAO = new EstadoDAO();

            estado.setNome("Parana");
            estadoDAO.insertEstado(estado);
        */
        
        // INSERÇÃO DE CIDADE    
        /*   
            Cidade cidade = new Cidade();
            CidadeDAO cidadeDAO = new CidadeDAO();
            Estado estado = new Estado();
            EstadoDAO estadoDAO = new EstadoDAO();

            estado = estadoDAO.selectEstado(1);
            cidade.setNome("Curitiba");
            cidade.setEstado(estado);
            cidadeDAO.insertCidade(cidade);
        */
        
        // INSERÇÃO DE USUARIO
        /*
            Usuario usuario = new Usuario();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            MDFive md5 = new MDFive();
            
            usuario.setEmail("marco@gmail.com");
            usuario.setNome("Marco");
            usuario.setSenha(md5.encripta("123"));
            usuario.setTipo('c');

            usuarioDAO.insertUsuario(usuario);
        */
        
        // INSERÇÃO DE FUNCIONARIO
        /*
            //Cria obj usuario
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.selectUsuario(1);

            usuario.setTipo('f');
            usuarioDAO.updateUsuario(usuario);

            //Cria obj funcionario
            Funcionario funcionario = new Funcionario();
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            //Adiciona os atributos
            funcionario.setMatricula(890);
            funcionario.setUsuario(usuario);

            // Parse a Date
            try{
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                funcionario.setNascimento(dateFormat.parse("21-12-1998"));
            }catch(ParseException exception){
                exception.printStackTrace();
            }

            //salva
            funcionarioDAO.insertFuncionario(funcionario);
        */
        
        //INSERÇÃO CLIENTE COM UM ENDERECO 
        /*
            //Cria obj usuario
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.selectUsuario(1);

            //Altera o tipo do usuario
            usuario.setTipo('c');
            usuarioDAO.updateUsuario(usuario);

            //Cria obj cidade
            CidadeDAO cidadeDAO = new CidadeDAO();
            Cidade cidade = cidadeDAO.selectCidade(1);

            //Cria obj Endereco
            Endereco endereco = new Endereco();
            endereco.setBairro("Santa Felicidade");
            endereco.setCidade(cidade);
            endereco.setComplemento("Casa 1");
            endereco.setNumero(320);
            endereco.setRua("Rua Boa vista da aparecida");

            //Cria obj Cliente
            Cliente cliente = new Cliente();
            ClienteDAO clienteDAO = new ClienteDAO();

            //Adiciona os atributos
            cliente.setCpf("10541335901");
            cliente.setSexo('M');
            cliente.setTelefone("41997735439");
            cliente.setUsuario(usuario);
            cliente.setEndereco(endereco);

            // endereço atribui um cliente
            endereco.setCliente(cliente);

            //Aqui ocorrerá a inserção tanto na na tb_cliente quanto em tb_endereco
            clienteDAO.insertCliente(cliente);
        */
        
        //INSERÇÃO TIPO
        /*
            Tipo tipo = new Tipo();
            TipoDAO tipoDAO = new TipoDAO();

            tipo.setPrazo(3);
            tipo.setPreco(80);

            tipoDAO.insertTipo(tipo);
        */
        
        //INSERÇÃO ROUPA
        /*
            Roupa roupa = new Roupa();
            RoupaDAO roupaDAO = new RoupaDAO();

            TipoDAO tipoDAO = new TipoDAO();
            Tipo tipo = tipoDAO.selectTipo(1);

            roupa.setQuantidade(4);
            roupa.setTipo(tipo);
            roupaDAO.insertRoupa(roupa);
        */
        
        //INSERÇÃO PEDIDO E ATUALIZA A TABELA INTERMEDIÁRIA
        /*
            //Criar obj pedido
            Pedido pedido = new Pedido();
            PedidoDAO pedidoDAO = new PedidoDAO();

            //Criar obj cliente
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.selectCliente(1);

            //Criar obj roupa
            RoupaDAO roupaDAO = new RoupaDAO();
            Roupa roupa = roupaDAO.selectRoupa(3);

            //Criar lista de roupas
            List<Roupa> roupas = new ArrayList<>();
            roupas.add(roupa);

            // Adicionar atributos ao pedido
            pedido.setCliente(cliente);
            pedido.setPrazo(3);
            pedido.setSituacao("Em espera"); 

            try{
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                pedido.setTempo(dateFormat.parse("21-05-2019"));
            }catch(ParseException exception){
                exception.printStackTrace();
            }

            pedido.setTotal((float) 240.00);
            pedido.setRoupas(roupas);

            pedidoDAO.insertPedido(pedido);
        */
        
        // TESTE DA MD5
        /*
        String senha = "123";
        String senha2 = "minhaSenhaSuperSeguraQueNinguémEstáVendo";
        String cript;
        String cript2;
        
        cript = MDFive.encripta(senha);
        cript2 = MDFive.encripta(senha2);
        System.out.println(cript);
        */
        Date data = new Date();
        System.out.println("\n\n\n\n\t "+data.toString());
    }   
}
