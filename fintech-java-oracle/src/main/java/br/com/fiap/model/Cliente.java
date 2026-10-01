package br.com.fiap.model;

import java.time.LocalDate;

public class Cliente {

    private String idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dtNascimento;
    private String senhaHash;
    private LocalDate dtCadastro;

    public Cliente() {
    }

    public Cliente(String idCliente, String nome, String cpf, String email,
                   String telefone, LocalDate dtNascimento,
                   String senhaHash, LocalDate dtCadastro) {

        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
        this.senhaHash = senhaHash;
        this.dtCadastro = dtCadastro;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Override
    public String toString() {
        return "Cliente [ID=" + idCliente + ", Nome=" + nome + ", CPF=" + cpf +
               ", Email=" + email + ", Telefone=" + telefone +
               ", DtNascimento=" + dtNascimento + ", DtCadastro=" + dtCadastro + "]";
    }
}