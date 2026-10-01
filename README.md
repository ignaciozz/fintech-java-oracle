# FINTECH — Java + Oracle Database

Projeto acadêmico desenvolvido para a disciplina de **Domain Driven Design / Desenvolvimento de Sistemas** da **FIAP**.

O objetivo da aplicação é realizar a manipulação de dados em uma instância de banco de dados Oracle utilizando **Java puro com JDBC** e o padrão de arquitetura **DAO (Data Access Object)**, sem o uso de frameworks ORM.

---

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java 17 (compatível com Java 21)
- **Gerenciador de Dependências:** Apache Maven
- **Banco de Dados:** Oracle Database (instância oficial FIAP)
- **Driver de Conexão:** Oracle JDBC Driver (`ojdbc8` versão `23.2.0.0`)
- **Padrão de Projeto:** DAO (Data Access Object) e Factory

---

## 🏛️ Entidades e Modelagem

O sistema implementa 3 entidades centrais da modelagem FINTECH:

1. **`Cliente`**: Representa os dados cadastrais do correntista (ID, nome, CPF, e-mail, telefone, data de nascimento, senha hash e data de cadastro).
2. **`Conta`**: Representa a conta bancária vinculada ao cliente (ID, ID do cliente, número da conta, agência, saldo e data de abertura).
3. **`Transacao`**: Representa movimentações financeiras vinculadas às contas (ID, conta origem, conta destino, tipo da transação, valor, data, descrição e status).
   - O campo `tipo_transacao` contempla movimentações como **Transferência PIX**, **Receita**, **Despesa** e **Investimento**.

---

## 📂 Estrutura do Projeto

```text
fintech-java-oracle/
├── pom.xml
├── schema.sql
└── src/
    └── main/
        └── java/
            └── br/com/fiap/
                ├── Main.java               # Classe de testes (Insert e GetAll)
                ├── dao/
                │   ├── ClienteDao.java     # DAO de Cliente (insert e getAll)
                │   ├── ContaDao.java       # DAO de Conta (insert e getAll)
                │   └── TransacaoDao.java   # DAO de Transação (insert e getAll)
                ├── factory/
                │   └── ConnectionFactory.java # Fábrica de conexões JDBC
                ├── model/
                │   ├── Cliente.java        # Modelo da entidade Cliente
                │   ├── Conta.java          # Modelo da entidade Conta
                │   └── Transacao.java      # Modelo da entidade Transacao
                └── view/
                    └── TestConnection.java # Teste isolado de conexão
```

---

## ⚙️ Configuração e Execução

### 1. Criação das Tabelas no Banco
Execute o script DDL contido em [`schema.sql`](file:///c:/Users/Gabriel/Desktop/code/fintech-java-oracle/fintech-java-oracle/schema.sql) no Oracle SQL Developer ou ferramenta equivalente conectado ao seu schema.

### 2. Configuração de Credenciais
No arquivo `br.com.fiap.factory.ConnectionFactory.java`, configure seu usuário e senha do banco Oracle da FIAP:

```java
private static final String USUARIO = "SEU_RM"; // Ex: "RM99999"
private static final String SENHA = "SUA_SENHA"; // Data de nascimento DDMMYY
```

### 3. Execução dos Testes
Execute a classe principal `br.com.fiap.Main`:
- Realiza a inserção de novos registros em sequência respeitando a integridade referencial (Clientes ➔ Contas ➔ Transações).
- Executa a consulta `getAll()` em todas as tabelas e exibe os resultados formatados no console.
- Trata possíveis falhas de conexão ou execução com blocos `try-catch` (`SQLException`).