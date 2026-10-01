package br.com.fiap;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.ContaDao;
import br.com.fiap.dao.TransacaoDao;
import br.com.fiap.model.Cliente;
import br.com.fiap.model.Conta;
import br.com.fiap.model.Transacao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDao();
        ContaDao contaDao = new ContaDao();
        TransacaoDao transacaoDao = new TransacaoDao();

        try {
            System.out.println("--- Teste de Cadastro (Insert) ---");

            // Gerando um sufixo para nao repetir a chave primaria no banco
            long id = System.currentTimeMillis() % 100000;

            String idCli1 = "CLI" + id + "A";
            String idCli2 = "CLI" + id + "B";

            String idConta1 = "CTA" + id + "A";
            String idConta2 = "CTA" + id + "B";

            String idTrans1 = "TRX" + id + "A";
            String idTrans2 = "TRX" + id + "B";

            // Inserindo 2 clientes
            Cliente c1 = new Cliente(idCli1, "Ana Beatriz Santos", "12345678901", "ana.santos@email.com", "11987654321", LocalDate.of(1995, 5, 20), "senha123", LocalDate.now());
            Cliente c2 = new Cliente(idCli2, "Carlos Eduardo Lima", "98765432100", "carlos.lima@email.com", "11912345678", LocalDate.of(1988, 10, 15), "senha456", LocalDate.now());

            clienteDao.insert(c1);
            System.out.println("Cliente 1 inserido com sucesso!");

            clienteDao.insert(c2);
            System.out.println("Cliente 2 inserido com sucesso!");

            // Inserindo 2 contas
            Conta conta1 = new Conta(idConta1, idCli1, "10023-4", "0001", new BigDecimal("5500.00"), LocalDate.now());
            Conta conta2 = new Conta(idConta2, idCli2, "20045-8", "0001", new BigDecimal("3200.50"), LocalDate.now());

            contaDao.insert(conta1);
            System.out.println("Conta 1 inserida com sucesso!");

            contaDao.insert(conta2);
            System.out.println("Conta 2 inserida com sucesso!");

            // Inserindo 2 transacoes
            Transacao t1 = new Transacao(idTrans1, idConta1, idConta2, "TRANSFERENCIA", new BigDecimal("350.00"), LocalDate.now(), "Transferencia PIX", "CONCLUIDA");
            Transacao t2 = new Transacao(idTrans2, idConta1, null, "INVESTIMENTO", new BigDecimal("1000.00"), LocalDate.now(), "Aplicacao CDB", "CONCLUIDA");

            transacaoDao.insert(t1);
            System.out.println("Transacao 1 inserida com sucesso!");

            transacaoDao.insert(t2);
            System.out.println("Transacao 2 inserida com sucesso!");

            System.out.println("\n--- Teste de Consulta (getAll) ---");

            // Listando clientes
            System.out.println("\nClientes no banco:");
            List<Cliente> clientes = clienteDao.getAll();
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }

            // Listando contas
            System.out.println("\nContas no banco:");
            List<Conta> contas = contaDao.getAll();
            for (Conta conta : contas) {
                System.out.println(conta);
            }

            // Listando transacoes
            System.out.println("\nTransacoes no banco:");
            List<Transacao> transacoes = transacaoDao.getAll();
            for (Transacao transacao : transacoes) {
                System.out.println(transacao);
            }

            System.out.println("\nTestes finalizados com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao acessar o banco de dados:");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro inesperado:");
            e.printStackTrace();
        }
    }
}