package com.example.rodneicaetano.entity;

import com.example.rodneicaetano.dto.ItemVendaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "item_venda")
public class ItemVendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "venda_id", nullable = false)
    private VendaEntity vendaId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoEntity produtoId;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private BigDecimal valorTotal;


    public ItemVendaEntity(ItemVendaDto dto, VendaEntity venda, ProdutoEntity produto){
        this.id = dto.getId();
        this.vendaId = venda;
        this.produtoId = produto;
        this.quantidade = dto.getQuantidade();
        this.valorTotal = produtoId.getValorUnitario().multiply(BigDecimal.valueOf(quantidade));
    }
}
