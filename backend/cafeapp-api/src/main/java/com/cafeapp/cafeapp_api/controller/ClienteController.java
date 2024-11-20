package com.cafeapp.cafeapp_api.controller;

import com.cafeapp.cafeapp_api.dto.ClienteDTO;
import com.cafeapp.cafeapp_api.entity.ClienteEntity;
import com.cafeapp.cafeapp_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteDTO criarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());

        ClienteEntity savedCliente = clienteService.criarCliente(cliente);
        clienteDTO.setGuid(savedCliente.getGuid());
        return clienteDTO;
    }

    @GetMapping("/{guid}")
    public ClienteDTO getClienteByGuid(@PathVariable String guid) {
        ClienteEntity cliente = clienteService.findClienteByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setGuid(cliente.getGuid());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEmail(cliente.getEmail());
        return clienteDTO;
    }

    @GetMapping
    public List<ClienteDTO> listarTodosClientes() {
        return clienteService.listarTodosClientes().stream().map(cliente -> {
            ClienteDTO dto = new ClienteDTO();
            dto.setGuid(cliente.getGuid());
            dto.setNome(cliente.getNome());
            dto.setEmail(cliente.getEmail());
            return dto;
        }).collect(Collectors.toList());
    }

    @PutMapping("/{guid}")
    public ClienteDTO atualizarCliente(@PathVariable String guid, @RequestBody ClienteDTO clienteDTO) {
        ClienteEntity clienteAtualizado = new ClienteEntity();
        clienteAtualizado.setNome(clienteDTO.getNome());
        clienteAtualizado.setEmail(clienteDTO.getEmail());

        ClienteEntity updatedCliente = clienteService.atualizarCliente(guid, clienteAtualizado);
        clienteDTO.setGuid(updatedCliente.getGuid());
        return clienteDTO;
    }

    @DeleteMapping("/{guid}")
    public void deleteCliente(@PathVariable String guid) {
        clienteService.deleteCliente(guid);
    }
}
