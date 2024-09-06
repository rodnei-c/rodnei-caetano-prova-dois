package com.example.rodneicaetano.dto;

import com.example.rodneicaetano.entity.MercadoEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MercadoDto {

    private Long id;
    private String nome;
    private String nomeFantasia;
    private String cnpj;

    public MercadoDto(MercadoEntity entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.nomeFantasia = entity.getNomeFantasia();
        this.cnpj = entity.getCnpj();
    }

}
