package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ClienteDAO;

/**
 * Classe com as regras de negócio para manipular Cliente
 * @author Eduana Carvalho
 * @since 11/05/2016
 */
public class ControleCliente {
    
    public void criarCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        
        //Validação com regras
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.inserirNovoCliente(cliente);
    }

    public ResultSet buscarCliente(String nome) throws ClassNotFoundException, SQLException {
        ResultSet rs;
        ClienteDAO clienteDAO = new ClienteDAO();
        rs = clienteDAO.buscarClienteNome(nome);
        if (!rs.first())
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        return rs;
    }
    public String listarClientes() throws ClassNotFoundException, SQLException {
        ResultSet rs;
        String listagemClientes;
        ClienteDAO clienteDAO = new ClienteDAO();
        rs = clienteDAO.listarClientes();
        listagemClientes = "Nome\t\tCPF\tRenda Mensal\tAtivo";
        listagemClientes = listagemClientes + "\n============================================";
        while (rs.next()) {            
            listagemClientes = listagemClientes 
                    +"\n"+rs.getString(1) 
                    +"\t"+rs.getString(2)
                    +"\t"+rs.getString(3)
                    +"\t"+rs.getString(4);
        }
        return listagemClientes;
    }

    public void receberClienteAtualizar(Cliente cliente, String nomeBusca) throws ClassNotFoundException, SQLException {
        ClienteDAO cliDAO = new ClienteDAO();
        
        cliDAO.alterarDadosCliente(cliente, nomeBusca);

    }
    
}//fim da classe
