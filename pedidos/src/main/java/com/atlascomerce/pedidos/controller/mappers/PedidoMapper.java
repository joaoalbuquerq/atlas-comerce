package com.atlascomerce.pedidos.controller.mappers;

import com.atlascomerce.pedidos.controller.dto.NovoPedidoDTO;
import com.atlascomerce.pedidos.model.Pedido;
import org.mapstruct.Mapper;

@Mapper
public interface PedidoMapper {

    Pedido map(NovoPedidoDTO dto);

}
