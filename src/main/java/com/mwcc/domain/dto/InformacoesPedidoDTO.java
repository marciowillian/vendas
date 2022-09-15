package com.mwcc.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformacoesPedidoDTO {

    private Integer codigo;
    private String cpf;
    private BigDecimal total;
    private List<InformacoesItemPedidoDTO> itens;
}
