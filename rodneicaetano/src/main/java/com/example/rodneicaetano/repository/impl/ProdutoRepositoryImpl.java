package com.example.rodneicaetano.repository.impl;

import com.example.rodneicaetano.dto.ProdutoDto;
import com.example.rodneicaetano.entity.QMercadoEntity;
import com.example.rodneicaetano.entity.QProdutoEntity;
import com.example.rodneicaetano.repository.ProdutoRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class ProdutoRepositoryImpl implements ProdutoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    final QMercadoEntity mercado = QMercadoEntity.mercadoEntity;
    final QProdutoEntity produto = QProdutoEntity.produtoEntity;

    @Override
    public Page<ProdutoDto> buscarProdutos(Pageable pageable, String searchTerm) {
        JPAQuery<ProdutoDto> query = new JPAQuery<>(em);

        query.select(Projections.constructor(ProdutoDto.class, produto)).from(produto);

        query.limit(pageable.getPageSize());
        query.offset(pageable.getOffset());

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

    @Override
    public Page<ProdutoDto> buscarProduto(Pageable pageable, String searchTerm, Long mercadoId, Long id) {
        JPAQuery<ProdutoDto> query = new JPAQuery<>(em);

        query.select(Projections.constructor(ProdutoDto.class, produto)).from(mercado).join(mercado.produtos, produto)
                .where(mercado.id.eq(mercadoId).and(produto.nome.containsIgnoreCase(searchTerm)));

        query.limit(pageable.getPageSize());
        query.offset(pageable.getOffset());

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }
}
