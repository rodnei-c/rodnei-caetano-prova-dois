package com.example.rodneicaetano.service;

import com.example.rodneicaetano.dto.VendaDto;
import com.example.rodneicaetano.entity.VendaEntity;

import java.util.Optional;

public interface VendaService {

    VendaDto criarVendaEmAberto(VendaDto vendaDto);

    VendaDto criarVendaFinalizada(VendaDto vendaDto);

    Optional<VendaEntity> buscaPorId(Long id);

    VendaDto adicionarItemVendaAberto(VendaDto vendaDto, Long id);

    void deletarVenda(Long id);
}
