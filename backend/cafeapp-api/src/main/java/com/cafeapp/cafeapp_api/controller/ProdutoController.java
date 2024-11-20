package com.cafeapp.cafeapp_api.controller;

import com.cafeapp.cafeapp_api.dto.ProdutoDTO;
import com.cafeapp.cafeapp_api.entity.ProdutoEntity;
import com.cafeapp.cafeapp_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoDTO addProduto(@RequestBody ProdutoDTO produtoDTO) {
        ProdutoEntity produto = new ProdutoEntity();
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());

        ProdutoEntity savedProduto = produtoService.addProduto(produto);
        produtoDTO.setGuid(savedProduto.getGuid());
        return produtoDTO;
    }

    @GetMapping
    public List<ProdutoDTO> getAllProdutos() {
        return produtoService.getAllProdutos().stream().map(produto -> {
            ProdutoDTO dto = new ProdutoDTO();
            dto.setGuid(produto.getGuid());
            dto.setNome(produto.getNome());
            dto.setPreco(produto.getPreco());
            return dto;
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{guid}")
    public void deleteProduto(@PathVariable String guid) {
        produtoService.deleteProduto(guid);
    }
}
