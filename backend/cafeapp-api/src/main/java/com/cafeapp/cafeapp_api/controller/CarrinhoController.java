package com.cafeapp.cafeapp_api.controller;

import com.cafeapp.cafeapp_api.dto.CarrinhoDTO;
import com.cafeapp.cafeapp_api.entity.CarrinhoEntity;
import com.cafeapp.cafeapp_api.entity.ProdutoEntity;
import com.cafeapp.cafeapp_api.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping
    public CarrinhoDTO criarCarrinho() {
        CarrinhoEntity carrinho = carrinhoService.criarCarrinho();
        CarrinhoDTO dto = new CarrinhoDTO();
        dto.setGuid(carrinho.getGuid());
        return dto;
    }

    @PostMapping("/{carrinhoGuid}/produtos/{produtoGuid}")
    public CarrinhoDTO adicionarProdutoAoCarrinho(@PathVariable String carrinhoGuid, @PathVariable String produtoGuid) {
        CarrinhoEntity carrinho = carrinhoService.adicionarProdutoAoCarrinho(carrinhoGuid, produtoGuid);
        CarrinhoDTO dto = new CarrinhoDTO();
        dto.setGuid(carrinho.getGuid());
        dto.setProdutosGuids(carrinho.getProdutos().stream().map(ProdutoEntity::getGuid).collect(Collectors.toList()));
        return dto;
    }

    @DeleteMapping("/{carrinhoGuid}/produtos/{produtoGuid}")
    public CarrinhoDTO removerProdutoDoCarrinho(@PathVariable String carrinhoGuid, @PathVariable String produtoGuid) {
        CarrinhoEntity carrinho = carrinhoService.removerProdutoDoCarrinho(carrinhoGuid, produtoGuid);
        CarrinhoDTO dto = new CarrinhoDTO();
        dto.setGuid(carrinho.getGuid());
        dto.setProdutosGuids(carrinho.getProdutos().stream().map(ProdutoEntity::getGuid).collect(Collectors.toList()));
        return dto;
    }

    @GetMapping("/{guid}/produtos")
    public List<String> listarProdutosNoCarrinho(@PathVariable String guid) {
        List<ProdutoEntity> produtos = carrinhoService.listarProdutosNoCarrinho(guid);
        return produtos.stream().map(ProdutoEntity::getGuid).collect(Collectors.toList());
    }

    @DeleteMapping("/{guid}")
    public void deleteCarrinho(@PathVariable String guid) {
        carrinhoService.deleteCarrinho(guid);
    }
}
