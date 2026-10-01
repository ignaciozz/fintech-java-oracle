package br.com.fiap.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Conta {

    private String idConta;
    private String idCliente;
    private String nmrConta;
    private String agencia;
    private BigDecimal saldo;
    private LocalDate dtAbertura;

    public Conta() {
    }

    public Conta(String idConta, String idCliente, String nmrConta,
                 String agencia, BigDecimal saldo, LocalDate dtAbertura) {

        this.idConta = idConta;
        this.idCliente = idCliente;
        this.nmrConta = nmrConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.dtAbertura = dtAbertura;
    }

    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNmrConta() {
        return nmrConta;
    }

    public void setNmrConta(String nmrConta) {
        this.nmrConta = nmrConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(LocalDate dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    @Override
    public String toString() {
        return "Conta [ID=" + idConta + ", ID Cliente=" + idCliente + ", Conta=" + nmrConta +
               ", Agência=" + agencia + ", Saldo=R$ " + saldo + ", DtAbertura=" + dtAbertura + "]";
    }
}