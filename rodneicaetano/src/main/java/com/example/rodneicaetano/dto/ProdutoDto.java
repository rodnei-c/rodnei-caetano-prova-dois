package com.example.rodneicaetano.dto;

import com.example.rodneicaetano.entity.ProdutoEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDto {

    private Long id;
    private Long mercadoId;
    private String nome;
    private Integer estoque;
    private BigDecimal valorUnitario;

    public ProdutoDto(ProdutoEntity entity){
        this.id = entity.getId();
        this.mercadoId = entity.getMercadoId().getId();
        this.nome = entity.getNome();
        this.estoque = entity.getEstoque();
        this.valorUnitario = entity.getValorUnitario();
    }

}
