package com.example.rodneicaetano.entity;

import com.example.rodneicaetano.dto.ProdutoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "mercado_id", nullable = false)
    private MercadoEntity mercadoId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer estoque;

    @Column(nullable = false)
    private BigDecimal valorUnitario;

    @OneToMany(mappedBy = "produtoId", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<ItemVendaEntity> itemVendas;

    public ProdutoEntity(ProdutoDto dto, MercadoEntity mercado){

        this.id = dto.getId();
        this.mercadoId = mercado;
        this.nome = dto.getNome();
        this.estoque = dto.getEstoque();
        this.valorUnitario = dto.getValorUnitario();

    }

}
