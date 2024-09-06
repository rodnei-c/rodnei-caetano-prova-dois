package com.example.rodneicaetano.service.impl;

import com.example.rodneicaetano.dto.ProdutoDto;
import com.example.rodneicaetano.entity.MercadoEntity;
import com.example.rodneicaetano.entity.ProdutoEntity;
import com.example.rodneicaetano.exceptions.MercadoNotFoundException;
import com.example.rodneicaetano.repository.ProdutoRepository;
import com.example.rodneicaetano.service.MercadoService;
import com.example.rodneicaetano.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepo;

    @Autowired
    private MercadoService mercadoService;

    // End-Point 4
    @Override
    public ProdutoDto criarProduto(ProdutoDto produtoDto) {
        var mercado = buscaMercado(produtoDto.getMercadoId());
        var produtoEntity = new ProdutoEntity(produtoDto, mercado);
        produtoRepo.save(produtoEntity);
        return new ProdutoDto(produtoEntity);
    }

    @Override
    public List<ProdutoDto> listarProdutos(Pageable pageable, String searchTerm) {
        return produtoRepo.buscarProdutos(pageable, searchTerm).stream().toList();
    }

    @Override
    public Optional<ProdutoEntity> buscaPorId(Long id) {
        return produtoRepo.findById(id);
    }

    // End-Point 5
    @Override
    public List<ProdutoDto> buscarProduto(Pageable pageable, String searchTerm, Long mercadoId, Long id) {
        return produtoRepo.buscarProduto(pageable, searchTerm, mercadoId, id).stream().toList();
    }

    private MercadoEntity buscaMercado(Long id){
        return mercadoService.buscaPorId(id).orElseThrow(() -> new MercadoNotFoundException());
    }
}
