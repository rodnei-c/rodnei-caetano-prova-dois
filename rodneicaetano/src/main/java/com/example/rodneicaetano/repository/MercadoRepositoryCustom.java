package com.example.rodneicaetano.repository;

import com.example.rodneicaetano.dto.MercadoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MercadoRepositoryCustom {

    Page<MercadoDto> buscarMercado(Pageable pageable, String searchTerm);

}
