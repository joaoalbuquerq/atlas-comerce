package com.atlascomerce.pedidos.controller.dto;

import com.atlascomerce.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(
        String dados, TipoPagamento tipoPagamento
) {
}
