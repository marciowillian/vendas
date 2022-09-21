package com.mwcc.domain.dto;

import com.mwcc.domain.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {

    private Integer produto;
    private Integer quantidade;

}
