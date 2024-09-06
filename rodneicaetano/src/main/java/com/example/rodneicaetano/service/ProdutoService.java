package com.example.rodneicaetano.service;

import com.example.rodneicaetano.dto.ProdutoDto;
import com.example.rodneicaetano.entity.ProdutoEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    ProdutoDto criarProduto(ProdutoDto produtoDto);

    List<ProdutoDto> listarProdutos(Pageable pageable, String searchTerm);

    Optional<ProdutoEntity> buscaPorId(Long id);

    List<ProdutoDto> buscarProduto(Pageable pageable, String searchTerm, Long mercadoId, Long id);
}
