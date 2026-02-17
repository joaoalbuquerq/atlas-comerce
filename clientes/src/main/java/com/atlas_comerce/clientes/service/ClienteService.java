package com.atlas_comerce.clientes.service;

import com.atlas_comerce.clientes.model.Cliente;
import com.atlas_comerce.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarPorCodigo(Long codigo) {
        return clienteRepository.findById(codigo);
    }

}
