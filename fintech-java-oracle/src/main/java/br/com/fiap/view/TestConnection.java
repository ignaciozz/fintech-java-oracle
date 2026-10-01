package br.com.fiap.view;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {

        try {
            Connection conexao = ConnectionFactory.getConnection();

            System.out.println("Conexão com Oracle realizada com sucesso!");

            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o Oracle.");
            e.printStackTrace();
        }
    }
}