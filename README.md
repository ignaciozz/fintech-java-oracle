# FINTECH — Java + Oracle

Projeto desenvolvido para a disciplina de Desenvolvimento de Sistemas da FIAP.

A aplicação utiliza Java e JDBC para realizar operações de manipulação de dados em um banco de dados Oracle, seguindo o padrão DAO (Data Access Object).

## Tecnologias

- Java 17
- Maven
- Oracle Database
- JDBC
- Oracle JDBC Driver
- IntelliJ IDEA

## Estrutura

O projeto trabalha com três entidades do modelo de dados da FINTECH:

- Cliente
- Conta
- Transação

A entidade `Transacao` contempla diferentes tipos de movimentação financeira, como:

- Receita
- Despesa
- Investimento

## Funcionalidades

- Conexão com banco de dados Oracle
- Cadastro de registros utilizando `INSERT`
- Consulta de registros utilizando `SELECT`
- Implementação do padrão DAO
- Método `insert()` para inserção de registros
- Método `getAll()` para consulta de todos os registros
- Tratamento de exceções relacionadas ao banco de dados

## Arquitetura

```text
src
└── main
    └── java
        └── br.com.fiap
            ├── dao
            ├── factory
            ├── model
            └── view