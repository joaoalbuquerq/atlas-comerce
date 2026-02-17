package com.atlas_comerce.produtos;

import com.atlas_comerce.produtos.controller.ProdutoController;
import com.atlas_comerce.produtos.model.Produto;
import com.atlas_comerce.produtos.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProdutoController.class)
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoService produtoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveSalvarProdutoComSucessoRetornando200() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo(1L);
        produto.setNome("Produto Teste");

        when(produtoService.salvar(any(Produto.class))).thenReturn(produto);

        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigo").value(1L))
                .andExpect(jsonPath("$.nome").value("Produto Teste"));

        verify(produtoService, times(1)).salvar(any(Produto.class));
    }

    @Test
    void deveBuscarProdutoPorCodigoComSucessoRetornando200() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo(1L);
        produto.setNome("Produto Teste");

        when(produtoService.buscarPorCodigo(1L)).thenReturn(Optional.of(produto));

        mockMvc.perform(get("/produtos/{codigo}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigo").value(1L))
                .andExpect(jsonPath("$.nome").value("Produto Teste"));

        verify(produtoService, times(1)).buscarPorCodigo(1L);
    }

    @Test
    void deveRetornar404QuandoProdutoNaoEncontrado() throws Exception {
        when(produtoService.buscarPorCodigo(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/produtos/{codigo}", 99L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(produtoService, times(1)).buscarPorCodigo(99L);
    }

}
