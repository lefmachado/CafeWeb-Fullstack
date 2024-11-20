package com.cafeapp.cafeapp_api.service;

import com.cafeapp.cafeapp_api.entity.CarrinhoEntity;
import com.cafeapp.cafeapp_api.entity.ProdutoEntity;
import com.cafeapp.cafeapp_api.repository.CarrinhoRepository;
import com.cafeapp.cafeapp_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public CarrinhoEntity criarCarrinho() {
        CarrinhoEntity carrinho = new CarrinhoEntity();
        carrinho.setGuid(java.util.UUID.randomUUID().toString());
        return carrinhoRepository.save(carrinho);
    }

    public Optional<CarrinhoEntity> findCarrinhoByGuid(String guid) {
        return carrinhoRepository.findByGuid(guid);
    }

    public CarrinhoEntity adicionarProdutoAoCarrinho(String carrinhoGuid, String produtoGuid) {
        Optional<CarrinhoEntity> carrinhoOptional = carrinhoRepository.findByGuid(carrinhoGuid);
        Optional<ProdutoEntity> produtoOptional = produtoRepository.findByGuid(produtoGuid);

        if (carrinhoOptional.isPresent() && produtoOptional.isPresent()) {
            CarrinhoEntity carrinho = carrinhoOptional.get();
            ProdutoEntity produto = produtoOptional.get();

            carrinho.getProdutos().add(produto);
            return carrinhoRepository.save(carrinho);
        } else {
            throw new RuntimeException("Carrinho ou Produto não encontrado");
        }
    }

    public CarrinhoEntity removerProdutoDoCarrinho(String carrinhoGuid, String produtoGuid) {
        Optional<CarrinhoEntity> carrinhoOptional = carrinhoRepository.findByGuid(carrinhoGuid);
        Optional<ProdutoEntity> produtoOptional = produtoRepository.findByGuid(produtoGuid);

        if (carrinhoOptional.isPresent() && produtoOptional.isPresent()) {
            CarrinhoEntity carrinho = carrinhoOptional.get();
            ProdutoEntity produto = produtoOptional.get();

            carrinho.getProdutos().remove(produto);
            return carrinhoRepository.save(carrinho);
        } else {
            throw new RuntimeException("Carrinho ou Produto não encontrado");
        }
    }

    public List<ProdutoEntity> listarProdutosNoCarrinho(String carrinhoGuid) {
        Optional<CarrinhoEntity> carrinhoOptional = carrinhoRepository.findByGuid(carrinhoGuid);
        if (carrinhoOptional.isPresent()) {
            return carrinhoOptional.get().getProdutos(); // Agora retorna uma List
        } else {
            throw new RuntimeException("Carrinho não encontrado");
        }
    }

    public void deleteCarrinho(String guid) {
        Optional<CarrinhoEntity> carrinho = carrinhoRepository.findByGuid(guid);
        carrinho.ifPresent(carrinhoRepository::delete);
    }
}
