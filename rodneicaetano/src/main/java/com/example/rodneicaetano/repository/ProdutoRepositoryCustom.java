package com.example.rodneicaetano.repository;

import com.example.rodneicaetano.dto.ProdutoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryCustom {

    Page<ProdutoDto> buscarProdutos(Pageable pageable, String searchTerm);

    Page<ProdutoDto> buscarProduto(Pageable pageable, String searchTerm, Long mercadoId, Long id);
}
