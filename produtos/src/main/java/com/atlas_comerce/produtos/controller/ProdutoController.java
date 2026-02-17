package com.atlas_comerce.produtos.controller;

import com.atlas_comerce.produtos.model.Produto;
import com.atlas_comerce.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> salvar(Produto produto){
        return ResponseEntity.ok().body(produtoService.salvar(produto));
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Produto> buscarPorNome(@PathVariable("codigo") Long codigo){
        return produtoService
                .buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
