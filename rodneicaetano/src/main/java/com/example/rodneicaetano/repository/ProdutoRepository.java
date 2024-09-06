package com.example.rodneicaetano.repository;

import com.example.rodneicaetano.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long>, ProdutoRepositoryCustom {



}
