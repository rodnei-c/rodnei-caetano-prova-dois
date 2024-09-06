package com.example.rodneicaetano.service;

import com.example.rodneicaetano.dto.ItemVendaDto;

public interface ItemVendaService {

    ItemVendaDto criarItem(ItemVendaDto itemVendaDto);

    void deletarItem(Long id);

}
