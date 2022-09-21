package com.mwcc.domain.dto;

import com.mwcc.domain.enums.StatusPedido;
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
    private String nomeCliente;
    private BigDecimal total;
    private String dataPedido;
    private List<InformacoesItemPedidoDTO> itens;
    private String status;
}
