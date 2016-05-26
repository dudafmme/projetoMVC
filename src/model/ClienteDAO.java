package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Duda
 */
public class ClienteDAO {

    Connection conexao;
    Statement stmt;//comandos sql
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");//testa o driver
        // pega a conexão
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concessionaria", "root", "root");
        return con;
    }
    
    //Método para gravar um cliente no BD
    public void inserirNovoCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        conexao = getConnection();
        stmt = conexao.createStatement();
        String sql = "INSERT INTO clientes VALUES('"
                + cliente.getNome() +"', '" 
                + cliente.getCpf() +"', "
                + cliente.getRenda() + "," 
                + cliente.isAtivo() +");";
        if(stmt.executeUpdate(sql) > 0)
            JOptionPane.showMessageDialog(null, "Dados Inseridos com sucesso");
        else
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o cliente");
    }

    public ResultSet buscarClienteNome(String nome) throws ClassNotFoundException, SQLException {        
        ResultSet rs;//conjunto da seleção, guarda o resultado
        conexao = getConnection();
        stmt = conexao.createStatement();
        rs = stmt.executeQuery("SELECT * FROM clientes WHERE nome = '" + nome + "'");
        return rs;
    }
    public ResultSet listarClientes() throws ClassNotFoundException, SQLException {        
        ResultSet rs;//conjunto da seleção, guarda o resultado
        conexao = getConnection();
        stmt = conexao.createStatement();
        rs = stmt.executeQuery("SELECT * FROM clientes");
        return rs;
    }

    public void alterarDadosCliente(Cliente cliente, String nomeBusca) throws ClassNotFoundException, SQLException {
        conexao = getConnection();//estabelece a conexao
        stmt = conexao.createStatement();
        String sql;
        
        sql = "UPDATE clientes SET "
                + "nome = '" + cliente.getNome() + "', "
                + "cpf = '" + cliente.getCpf() + "', "
                + "renda = " + cliente.getRenda() + ", "
                + "ativo = " + cliente.isAtivo() 
                + " WHERE nome = '" + nomeBusca + "'";
        
        if(stmt.executeUpdate(sql) > 0)
            JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso");
        else
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar os dados do cliente");
    }
}//fim da classe
