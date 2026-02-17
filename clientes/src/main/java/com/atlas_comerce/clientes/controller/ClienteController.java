package com.atlas_comerce.clientes.controller;

import com.atlas_comerce.clientes.model.Cliente;
import com.atlas_comerce.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        return ResponseEntity.ok().body(clienteService.salvar(cliente));
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Cliente> buscarPorCodigo(@PathVariable Long codigo){
        return clienteService
                .buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
