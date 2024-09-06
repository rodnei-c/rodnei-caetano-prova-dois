package com.example.rodneicaetano.repository;

import com.example.rodneicaetano.entity.ItemVendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVendaEntity, Long> {


}
