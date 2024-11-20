package com.cafeapp.cafeapp_api.repository;

import com.cafeapp.cafeapp_api.entity.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {
    Optional<CarrinhoEntity> findByGuid(String guid);
}