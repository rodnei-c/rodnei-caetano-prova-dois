package com.example.rodneicaetano.service.impl;

import com.example.rodneicaetano.dto.ItemVendaDto;
import com.example.rodneicaetano.entity.ItemVendaEntity;
import com.example.rodneicaetano.entity.ProdutoEntity;
import com.example.rodneicaetano.entity.VendaEntity;
import com.example.rodneicaetano.exceptions.ProdutoNotFoundException;
import com.example.rodneicaetano.exceptions.VendaNotFoundException;
import com.example.rodneicaetano.repository.ItemVendaRepository;
import com.example.rodneicaetano.service.ItemVendaService;
import com.example.rodneicaetano.service.ProdutoService;
import com.example.rodneicaetano.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ItemVendaServiceImpl implements ItemVendaService {

    @Autowired
    ItemVendaRepository itemRepo;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    VendaService vendaService;

    @Override
    public ItemVendaDto criarItem(ItemVendaDto itemVendaDto) {
        var produto = buscaProduto(itemVendaDto.getProdutoId());
        var venda = buscaVenda(itemVendaDto.getVendaId());
        var itemVendaEntity = new ItemVendaEntity(itemVendaDto, venda, produto);
        itemRepo.save(itemVendaEntity);
        return new ItemVendaDto(itemVendaEntity);
    }


    // End-Point 11
    @Override
    public void deletarItem(Long id) {
        itemRepo.deleteById(id);
    }

    private ProdutoEntity buscaProduto(Long id){
        return produtoService.buscaPorId(id).orElseThrow(() -> new ProdutoNotFoundException("Não existe esse produto"));
    }

    private VendaEntity buscaVenda(Long id){
        return vendaService.buscaPorId(id).orElseThrow(() -> new VendaNotFoundException("Não existe essa venda"));
    }
}
