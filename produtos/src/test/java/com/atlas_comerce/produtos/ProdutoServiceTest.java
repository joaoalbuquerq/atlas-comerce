package com.atlas_comerce.produtos;

import com.atlas_comerce.produtos.model.Produto;
import com.atlas_comerce.produtos.repository.ProdutoRepository;
import com.atlas_comerce.produtos.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    void deveSalvarProdutoComSucesso() {
        Produto produto = new Produto();
        produto.setCodigo(1L);
        produto.setNome("Produto Teste");

        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto resultado = produtoService.salvar(produto);

        assertNotNull(resultado);
        assertEquals(produto.getCodigo(), resultado.getCodigo());
        assertEquals(produto.getNome(), resultado.getNome());
        verify(produtoRepository, times(1)).save(produto);
    }

    @Test
    void deveBuscarProdutoPorCodigoComSucesso() {
        Produto produto = new Produto();
        produto.setCodigo(1L);
        produto.setNome("Produto Teste");

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Optional<Produto> resultado = produtoService.buscarPorCodigo(1L);

        assertTrue(resultado.isPresent());
        assertEquals(produto.getCodigo(), resultado.get().getCodigo());
        verify(produtoRepository, times(1)).findById(1L);
    }

    @Test
    void deveRetornarVazioQuandoProdutoNaoEncontrado() {
        when(produtoRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Produto> resultado = produtoService.buscarPorCodigo(99L);

        assertFalse(resultado.isPresent());
        verify(produtoRepository, times(1)).findById(99L);
    }

}
