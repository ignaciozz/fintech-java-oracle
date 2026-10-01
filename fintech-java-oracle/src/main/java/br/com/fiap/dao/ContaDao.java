package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Conta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDao {

    /**
     * Insere um novo registro de Conta na tabela CONTA do Oracle.
     */
    public void insert(Conta conta) throws SQLException {
        String sql = "INSERT INTO CONTA (id_conta, id_cliente, nmr_conta, agencia, saldo, dt_abertura) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, conta.getIdConta());
            stmt.setString(2, conta.getIdCliente());
            stmt.setString(3, conta.getNmrConta());
            stmt.setString(4, conta.getAgencia());
            stmt.setBigDecimal(5, conta.getSaldo());
            stmt.setDate(6, Date.valueOf(conta.getDtAbertura()));

            stmt.executeUpdate();
        }
    }

    /**
     * Consulta e retorna todos os registros da tabela CONTA.
     */
    public List<Conta> getAll() throws SQLException {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT id_conta, id_cliente, nmr_conta, agencia, saldo, dt_abertura FROM CONTA ORDER BY nmr_conta";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Conta conta = parseConta(rs);
                contas.add(conta);
            }
        }
        return contas;
    }

    /**
     * Método auxiliar para mapear o ResultSet em um objeto Conta.
     */
    private Conta parseConta(ResultSet rs) throws SQLException {
        return new Conta(
            rs.getString("id_conta"),
            rs.getString("id_cliente"),
            rs.getString("nmr_conta"),
            rs.getString("agencia"),
            rs.getBigDecimal("saldo"),
            rs.getDate("dt_abertura").toLocalDate()
        );
    }
}
