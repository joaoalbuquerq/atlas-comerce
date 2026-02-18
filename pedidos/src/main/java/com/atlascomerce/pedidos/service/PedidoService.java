package com.atlascomerce.pedidos.service;

import com.atlascomerce.pedidos.model.Pedido;
import com.atlascomerce.pedidos.repository.ItemPedidoRepository;
import com.atlascomerce.pedidos.repository.PedidoRepository;
import com.atlascomerce.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator pedidoValidator;

    public Pedido criarPedido(Pedido pedido) {

    }


}

