package com.mwcc.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AtualizacaoStatusPedidoDTO {
    @NotEmpty(message = "O campo status é obrigatório." )
    private String novoStatus;
}
