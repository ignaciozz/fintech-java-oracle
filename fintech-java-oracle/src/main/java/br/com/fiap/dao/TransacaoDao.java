package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Transacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDao {

    /**
     * Insere um novo registro de Transacao na tabela TRANSACAO do Oracle.
     */
    public void insert(Transacao transacao) throws SQLException {
        String sql = "INSERT INTO TRANSACAO (id_transacao, id_conta_origem, id_conta_destino, tipo_transacao, valor, data_transacao, descricao, status_transacao) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, transacao.getIdTransacao());
            stmt.setString(2, transacao.getIdContaOrigem());
            stmt.setString(3, transacao.getIdContaDestino());
            stmt.setString(4, transacao.getTipoTransacao());
            stmt.setBigDecimal(5, transacao.getValor());
            stmt.setDate(6, Date.valueOf(transacao.getDataTransacao()));
            stmt.setString(7, transacao.getDescricao());
            stmt.setString(8, transacao.getStatusTransacao());

            stmt.executeUpdate();
        }
    }

    /**
     * Consulta e retorna todos os registros da tabela TRANSACAO.
     */
    public List<Transacao> getAll() throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT id_transacao, id_conta_origem, id_conta_destino, tipo_transacao, valor, data_transacao, descricao, status_transacao FROM TRANSACAO ORDER BY data_transacao DESC";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Transacao transacao = parseTransacao(rs);
                transacoes.add(transacao);
            }
        }
        return transacoes;
    }

    /**
     * Método auxiliar para mapear o ResultSet em um objeto Transacao.
     */
    private Transacao parseTransacao(ResultSet rs) throws SQLException {
        return new Transacao(
            rs.getString("id_transacao"),
            rs.getString("id_conta_origem"),
            rs.getString("id_conta_destino"),
            rs.getString("tipo_transacao"),
            rs.getBigDecimal("valor"),
            rs.getDate("data_transacao").toLocalDate(),
            rs.getString("descricao"),
            rs.getString("status_transacao")
        );
    }
}
