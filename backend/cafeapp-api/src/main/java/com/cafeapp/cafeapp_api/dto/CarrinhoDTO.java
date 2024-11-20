package com.cafeapp.cafeapp_api.dto;

import java.util.List;

public class CarrinhoDTO {
    private String guid;
    private List<String> produtosGuids; // Lista de GUIDs dos produtos no carrinho

    // Getters e Setters
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public List<String> getProdutosGuids() {
        return produtosGuids;
    }

    public void setProdutosGuids(List<String> produtosGuids) {
        this.produtosGuids = produtosGuids;
    }
}
