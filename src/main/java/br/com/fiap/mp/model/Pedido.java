package br.com.fiap.mp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

    private String nomeProduto;
    private BigDecimal valorNegociado;
    private LocalDate dataDaEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Pedido setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
        return this;
    }

    public BigDecimal getValorNegociado() {
        return valorNegociado;
    }

    public Pedido setValorNegociado(BigDecimal valorNegociado) {
        this.valorNegociado = valorNegociado;
        return this;
    }

    public LocalDate getDataDaEntrega() {
        return dataDaEntrega;
    }

    public Pedido setDataDaEntrega(LocalDate dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
        return this;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public Pedido setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
        return this;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public Pedido setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Pedido setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
}