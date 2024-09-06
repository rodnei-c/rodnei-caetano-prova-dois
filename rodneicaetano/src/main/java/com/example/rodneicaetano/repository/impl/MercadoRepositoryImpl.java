package com.example.rodneicaetano.repository.impl;

import com.example.rodneicaetano.dto.MercadoDto;
import com.example.rodneicaetano.repository.MercadoRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.example.rodneicaetano.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class MercadoRepositoryImpl implements MercadoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    final QMercadoEntity mercado = QMercadoEntity.mercadoEntity;


    @Override
    public Page<MercadoDto> buscarMercado(Pageable pageable, String searchTerm) {

        JPAQuery<MercadoDto> query = new JPAQuery<>(em);

        query.select(Projections.constructor(MercadoDto.class, mercado)).from(mercado);

        query.limit(pageable.getPageSize());
        query.offset(pageable.getOffset());

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }
}
