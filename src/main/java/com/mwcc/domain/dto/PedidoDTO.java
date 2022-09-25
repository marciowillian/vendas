package com.mwcc.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    @NotNull(message = "Informe o código do Cliente")
    private Integer cliente;
    @NotNull(message = "O valor total é obrigatório.")
    private BigDecimal total;
    private List<ItemPedidoDTO> itens;


}
