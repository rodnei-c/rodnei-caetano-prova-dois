package com.example.rodneicaetano.controller;

import com.example.rodneicaetano.dto.ItemVendaDto;
import com.example.rodneicaetano.exceptions.ProdutoNotFoundException;
import com.example.rodneicaetano.exceptions.VendaNotFoundException;
import com.example.rodneicaetano.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itens")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @PostMapping("/cadastrar-item")
    public ResponseEntity<?> cadastrarItem(@RequestBody ItemVendaDto criaItem) throws ProdutoNotFoundException, VendaNotFoundException {
        try{
            return ResponseEntity.ok(itemVendaService.criarItem(criaItem));
        } catch(RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/deletar-item/{id}")
    public void excluirItem(@PathVariable Long id){
        itemVendaService.deletarItem(id);
    }
}
