package com.example.rodneicaetano.controller;

import com.example.rodneicaetano.dto.VendaDto;
import com.example.rodneicaetano.exceptions.MercadoNotFoundException;
import com.example.rodneicaetano.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @PostMapping("/cadastrar-venda-aberta")
    public ResponseEntity<?> cadastrarVendaEmAberto(@RequestBody VendaDto criaVenda){
        try {
            return ResponseEntity.ok(vendaService.criarVendaEmAberto(criaVenda));
        } catch(MercadoNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cadastrar-venda-finalizada")
    public ResponseEntity<?> cadastrarVendaFinalizada(@RequestBody VendaDto criaVenda){
        try{
            return ResponseEntity.ok(vendaService.criarVendaFinalizada(criaVenda));
        } catch(MercadoNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deletar-venda/{id}")
    public void excluirVenda(@PathVariable Long id){
        vendaService.deletarVenda(id);
    }
}
