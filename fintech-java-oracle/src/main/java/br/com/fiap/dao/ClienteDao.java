package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    /**
     * Insere um novo registro de Cliente na tabela CLIENTE do Oracle.
     */
    public void insert(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO CLIENTE (id_cliente, nome, cpf, email, telefone, dt_nascimento, senha_hash, dt_cadastro) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefone());
            stmt.setDate(6, Date.valueOf(cliente.getDtNascimento()));
            stmt.setString(7, cliente.getSenhaHash());
            stmt.setDate(8, Date.valueOf(cliente.getDtCadastro()));

            stmt.executeUpdate();
        }
    }

    /**
     * Consulta e retorna todos os registros da tabela CLIENTE.
     */
    public List<Cliente> getAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id_cliente, nome, cpf, email, telefone, dt_nascimento, senha_hash, dt_cadastro FROM CLIENTE ORDER BY nome";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = parseCliente(rs);
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    /**
     * Método auxiliar para mapear o ResultSet em um objeto Cliente.
     */
    private Cliente parseCliente(ResultSet rs) throws SQLException {
        return new Cliente(
            rs.getString("id_cliente"),
            rs.getString("nome"),
            rs.getString("cpf"),
            rs.getString("email"),
            rs.getString("telefone"),
            rs.getDate("dt_nascimento").toLocalDate(),
            rs.getString("senha_hash"),
            rs.getDate("dt_cadastro").toLocalDate()
        );
    }
}
