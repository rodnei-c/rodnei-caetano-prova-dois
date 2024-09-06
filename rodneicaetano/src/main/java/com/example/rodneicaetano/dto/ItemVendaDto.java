package com.example.rodneicaetano.dto;

import com.example.rodneicaetano.entity.ItemVendaEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemVendaDto {

    private Long id;
    private Long vendaId;
    private Long produtoId;
    private Integer quantidade;
    private BigDecimal valorTotal;

    public ItemVendaDto(ItemVendaEntity entity){
        this.id = entity.getId();
        this.vendaId = entity.getVendaId().getId();
        this.produtoId = entity.getProdutoId().getId();
        this.quantidade = entity.getQuantidade();
        this.valorTotal = entity.getValorTotal();
    }
}
