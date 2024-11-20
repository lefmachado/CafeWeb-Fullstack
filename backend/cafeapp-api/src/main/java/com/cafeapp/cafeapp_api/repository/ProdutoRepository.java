package com.cafeapp.cafeapp_api.repository;

import com.cafeapp.cafeapp_api.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    Optional<ProdutoEntity> findByGuid(String guid);
}
