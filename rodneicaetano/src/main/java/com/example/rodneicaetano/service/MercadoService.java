package com.example.rodneicaetano.service;

import com.example.rodneicaetano.dto.MercadoDto;
import com.example.rodneicaetano.entity.MercadoEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MercadoService {

    MercadoDto criaMercado(MercadoDto mercadoDto);

    List<MercadoDto> listarMercados(Pageable pageable, String searchTerm);

    Optional<MercadoEntity> buscaPorId(Long id);
}
