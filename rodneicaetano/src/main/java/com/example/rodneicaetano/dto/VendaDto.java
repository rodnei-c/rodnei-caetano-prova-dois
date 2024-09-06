package com.example.rodneicaetano.dto;

import com.example.rodneicaetano.entity.VendaEntity;
import com.example.rodneicaetano.enuns.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaDto {

    private Long id;
    private Long mercadoId;
    private StatusEnum status;
    private BigDecimal valorTotal;
    private LocalDate dataCriacao;

    public VendaDto(VendaEntity entity){
        this.id = entity.getId();
        this.mercadoId = entity.getMercadoId().getId();
        this.status = entity.getStatus();
        this.valorTotal = entity.getValorTotal();
        this.dataCriacao = entity.getDataCriacao();
    }
}
