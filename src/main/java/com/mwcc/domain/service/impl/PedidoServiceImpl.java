package com.mwcc.domain.service.impl;

import com.mwcc.api.exception.RegraNegocioException;
import com.mwcc.domain.dto.ItemPedidoDTO;
import com.mwcc.domain.dto.PedidoDTO;
import com.mwcc.domain.entity.Cliente;
import com.mwcc.domain.entity.ItemPedido;
import com.mwcc.domain.entity.Pedido;
import com.mwcc.domain.entity.Produto;
import com.mwcc.domain.repository.Clientes;
import com.mwcc.domain.repository.ItensPedido;
import com.mwcc.domain.repository.Pedidos;
import com.mwcc.domain.repository.Produtos;
import com.mwcc.domain.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos pedidos;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItensPedido itensPedidoRepository;

    @Override @Transactional
    public Pedido salvar(PedidoDTO pedidoDTO) {
        Integer idCliente = pedidoDTO.getCliente();
        Cliente cliente = clientesRepository.findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itens = converterItens(pedido, pedidoDTO.getItens());
        pedidos.save(pedido);
        itensPedidoRepository.saveAll(itens);
        pedido.setItens(itens);
        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer idPedido) {
        return pedidos.findByIdFetchItens(idPedido);
    }

    private List<ItemPedido> converterItens(Pedido pedido ,List<ItemPedidoDTO> itens){
        if(itens.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar o pedido sem itens.");
        }

        return itens
                .stream()
                .map(itemPedidoDTO -> {
                    Integer idProduto = itemPedidoDTO.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                                .orElseThrow(() -> new RegraNegocioException("Código de produto inválido: " + idProduto));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }
}
