package com.cafeapp.cafeapp_api.dto;

public class ProdutoDTO {
    private String guid;
    private String nome;
    private Double preco;

    // Getters e Setters
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
