-- Criacao das tabelas do sistema Fintech

-- Tabela Cliente
CREATE TABLE CLIENTE (
    id_cliente VARCHAR2(50) PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL,
    cpf VARCHAR2(14) NOT NULL,
    email VARCHAR2(100) NOT NULL,
    telefone VARCHAR2(20),
    dt_nascimento DATE NOT NULL,
    senha_hash VARCHAR2(255) NOT NULL,
    dt_cadastro DATE NOT NULL
);

-- Tabela Conta
CREATE TABLE CONTA (
    id_conta VARCHAR2(50) PRIMARY KEY,
    id_cliente VARCHAR2(50) NOT NULL,
    nmr_conta VARCHAR2(20) NOT NULL,
    agencia VARCHAR2(10) NOT NULL,
    saldo NUMBER(12,2) NOT NULL,
    dt_abertura DATE NOT NULL,
    CONSTRAINT fk_conta_cliente FOREIGN KEY (id_cliente) REFERENCES CLIENTE(id_cliente)
);

-- Tabela Transacao
CREATE TABLE TRANSACAO (
    id_transacao VARCHAR2(50) PRIMARY KEY,
    id_conta_origem VARCHAR2(50) NOT NULL,
    id_conta_destino VARCHAR2(50),
    tipo_transacao VARCHAR2(30) NOT NULL,
    valor NUMBER(12,2) NOT NULL,
    data_transacao DATE NOT NULL,
    descricao VARCHAR2(255),
    status_transacao VARCHAR2(20) NOT NULL,
    CONSTRAINT fk_trans_origem FOREIGN KEY (id_conta_origem) REFERENCES CONTA(id_conta),
    CONSTRAINT fk_trans_destino FOREIGN KEY (id_conta_destino) REFERENCES CONTA(id_conta)
);

