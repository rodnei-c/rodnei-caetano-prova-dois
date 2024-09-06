package com.example.rodneicaetano.service.impl;

import com.example.rodneicaetano.dto.MercadoDto;
import com.example.rodneicaetano.entity.MercadoEntity;
import com.example.rodneicaetano.repository.MercadoRepository;
import com.example.rodneicaetano.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class MercadoServiceImpl implements MercadoService {

    @Autowired
    private MercadoRepository mercadoRepo;

    //End-Point 1
    @Override
    public MercadoDto criaMercado(MercadoDto mercadoDto) {
        var mercadoEntity = new MercadoEntity(mercadoDto);
        mercadoRepo.save(mercadoEntity);
        return new MercadoDto(mercadoEntity);
    }

    @Override
    public List<MercadoDto> listarMercados(Pageable pageable, String searchTerm) {
        return mercadoRepo.buscarMercado(pageable, searchTerm).stream().toList();
    }

    @Override
    public Optional<MercadoEntity> buscaPorId(Long id) {
        return mercadoRepo.findById(id);
    }
}
