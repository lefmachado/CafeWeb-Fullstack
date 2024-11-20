package com.cafeapp.cafeapp_api.repository;

import com.cafeapp.cafeapp_api.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByGuid(String guid);
}