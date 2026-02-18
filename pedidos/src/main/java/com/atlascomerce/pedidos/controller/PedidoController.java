package com.atlascomerce.pedidos.controller;

import com.atlascomerce.pedidos.controller.dto.NovoPedidoDTO;
import com.atlascomerce.pedidos.controller.mappers.PedidoMapper;
import com.atlascomerce.pedidos.model.Pedido;
import com.atlascomerce.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidoMapper pedidoMapper;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody NovoPedidoDTO novoPedidoDTO) {
        var pedido = pedidoMapper.map(novoPedidoDTO);
        var pedidoCriado = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok(pedidoCriado.getCodigo());
    }

}
