package br.com.fiap.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {

    private String idTransacao;
    private String idContaOrigem;
    private String idContaDestino;
    private String tipoTransacao;
    private BigDecimal valor;
    private LocalDate dataTransacao;
    private String descricao;
    private String statusTransacao;

    public Transacao() {
    }

    public Transacao(String idTransacao, String idContaOrigem,
                     String idContaDestino, String tipoTransacao,
                     BigDecimal valor, LocalDate dataTransacao,
                     String descricao, String statusTransacao) {

        this.idTransacao = idTransacao;
        this.idContaOrigem = idContaOrigem;
        this.idContaDestino = idContaDestino;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.descricao = descricao;
        this.statusTransacao = statusTransacao;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getIdContaOrigem() {
        return idContaOrigem;
    }

    public void setIdContaOrigem(String idContaOrigem) {
        this.idContaOrigem = idContaOrigem;
    }

    public String getIdContaDestino() {
        return idContaDestino;
    }

    public void setIdContaDestino(String idContaDestino) {
        this.idContaDestino = idContaDestino;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatusTransacao() {
        return statusTransacao;
    }

    public void setStatusTransacao(String statusTransacao) {
        this.statusTransacao = statusTransacao;
    }

    @Override
    public String toString() {
        return "Transacao [ID=" + idTransacao + ", Origem=" + idContaOrigem +
               ", Destino=" + (idContaDestino != null ? idContaDestino : "N/A") +
               ", Tipo=" + tipoTransacao + ", Valor=R$ " + valor +
               ", Data=" + dataTransacao + ", Status=" + statusTransacao +
               ", Descrição=" + descricao + "]";
    }
}