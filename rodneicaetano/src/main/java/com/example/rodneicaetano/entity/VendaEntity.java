package com.example.rodneicaetano.entity;

import com.example.rodneicaetano.dto.VendaDto;
import com.example.rodneicaetano.enuns.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "venda")
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "mercado_id", nullable = false)
    private MercadoEntity mercadoId;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private LocalDate dataCriacao;

    @OneToMany(mappedBy = "vendaId", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<ItemVendaEntity> itemVendas;

    public VendaEntity(VendaDto dto, MercadoEntity mercado){
        this.id = dto.getId();
        this.mercadoId = mercado;
        this.status = dto.getStatus();
        this.valorTotal = dto.getValorTotal();
        this.dataCriacao = LocalDate.now();
    }

    public VendaEntity defineEmAberto(StatusEnum status){
        this.status = status;
        return this;
    }

}
