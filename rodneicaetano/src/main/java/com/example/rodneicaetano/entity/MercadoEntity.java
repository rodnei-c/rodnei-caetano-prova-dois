package com.example.rodneicaetano.entity;

import com.example.rodneicaetano.dto.MercadoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "mercado")
public class MercadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nomeFantasia;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @OneToMany(mappedBy = "mercadoId", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<ProdutoEntity> produtos;

    @OneToMany(mappedBy = "mercadoId", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<VendaEntity> vendas;

    public MercadoEntity(MercadoDto dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.nomeFantasia = dto.getNomeFantasia();
        this.cnpj = dto.getCnpj();
    }

}
