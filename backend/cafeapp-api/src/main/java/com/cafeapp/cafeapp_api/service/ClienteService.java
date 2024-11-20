package com.cafeapp.cafeapp_api.service;

import com.cafeapp.cafeapp_api.entity.ClienteEntity;
import com.cafeapp.cafeapp_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity criarCliente(ClienteEntity cliente) {
        cliente.setGuid(java.util.UUID.randomUUID().toString());
        return clienteRepository.save(cliente);
    }

    public Optional<ClienteEntity> findClienteByGuid(String guid) {
        return clienteRepository.findByGuid(guid);
    }

    public List<ClienteEntity> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    public ClienteEntity atualizarCliente(String guid, ClienteEntity clienteAtualizado) {
        Optional<ClienteEntity> clienteOptional = clienteRepository.findByGuid(guid);
        if (clienteOptional.isPresent()) {
            ClienteEntity cliente = clienteOptional.get();
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    public void deleteCliente(String guid) {
        Optional<ClienteEntity> cliente = clienteRepository.findByGuid(guid);
        cliente.ifPresent(clienteRepository::delete);
    }
}
