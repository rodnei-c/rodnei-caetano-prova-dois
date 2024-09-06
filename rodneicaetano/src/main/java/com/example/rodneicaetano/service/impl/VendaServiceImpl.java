package com.example.rodneicaetano.service.impl;

import com.example.rodneicaetano.dto.VendaDto;
import com.example.rodneicaetano.entity.MercadoEntity;
import com.example.rodneicaetano.entity.VendaEntity;
import com.example.rodneicaetano.enuns.StatusEnum;
import com.example.rodneicaetano.exceptions.MercadoNotFoundException;
import com.example.rodneicaetano.repository.VendaRepository;
import com.example.rodneicaetano.service.MercadoService;
import com.example.rodneicaetano.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Primary
@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    VendaRepository vendaRepo;

    @Autowired
    MercadoService mercadoService;

    // End-Point 8
    @Override
    public VendaDto criarVendaEmAberto(VendaDto vendaDto) {
        var mercado = buscaMercado(vendaDto.getMercadoId());
        var vendaEntity = new VendaEntity(vendaDto, mercado);
        vendaEntity.defineEmAberto(StatusEnum.EM_ABERTO);
        vendaRepo.save(vendaEntity);
        return new VendaDto(vendaEntity);
    }


    // End-Point 9
    @Override
    public VendaDto criarVendaFinalizada(VendaDto vendaDto) {
        var mercado = buscaMercado(vendaDto.getMercadoId());
        var vendaEntity = new VendaEntity(vendaDto, mercado);
        vendaEntity.defineEmAberto(StatusEnum.FINALIZADO);
        vendaRepo.save(vendaEntity);
        return new VendaDto(vendaEntity);
    }

    @Override
    public Optional<VendaEntity> buscaPorId(Long id) {
        return vendaRepo.findById(id);
    }

    // End-Point 10
    @Override
    public VendaDto adicionarItemVendaAberto(VendaDto vendaDto, Long id) {


        return null;
    }

    @Override
    public void deletarVenda(Long id) {
        vendaRepo.deleteById(id);
    }

    private MercadoEntity buscaMercado(Long id){
        return mercadoService.buscaPorId(id).orElseThrow(() -> new MercadoNotFoundException());
    }
}
