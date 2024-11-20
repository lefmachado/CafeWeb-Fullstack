package com.cafeapp.cafeapp_api.service;

import com.cafeapp.cafeapp_api.entity.ProdutoEntity;
import com.cafeapp.cafeapp_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoEntity addProduto(ProdutoEntity produto) {
        produto.setGuid(java.util.UUID.randomUUID().toString());
        return produtoRepository.save(produto);
    }

    public Optional<ProdutoEntity> findProdutoByGuid(String guid) {
        return produtoRepository.findByGuid(guid);
    }

    public List<ProdutoEntity> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public void deleteProduto(String guid) {
        Optional<ProdutoEntity> produto = produtoRepository.findByGuid(guid);
        produto.ifPresent(produtoRepository::delete);
    }
}
