package com.mwcc.domain.dto;

import com.mwcc.domain.validation.NotEmptyList;
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
    @NotEmptyList(message = "Pedido não pode ser realizada sem itens.")
    private List<ItemPedidoDTO> itens;


}
