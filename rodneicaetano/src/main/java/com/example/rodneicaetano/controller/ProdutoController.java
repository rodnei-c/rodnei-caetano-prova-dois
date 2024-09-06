package com.example.rodneicaetano.controller;

import com.example.rodneicaetano.dto.MercadoDto;
import com.example.rodneicaetano.dto.ProdutoDto;
import com.example.rodneicaetano.exceptions.MercadoNotFoundException;
import com.example.rodneicaetano.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/cadastrar-produto")
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoDto criaProduto){
        try {
            return ResponseEntity.ok(produtoService.criarProduto(criaProduto));
        } catch(MercadoNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<ProdutoDto> buscarProdutos(@RequestParam(defaultValue = "0", required = false) Integer page,
                                           @RequestParam(defaultValue = "10", required = false) Integer size,
                                           @RequestParam(required = false) String searchTerm){
        return produtoService.listarProdutos(Pageable.ofSize(size).withPage(page), searchTerm);
    }

    @GetMapping("/buscar-produto")
    public List<ProdutoDto> buscarProduto(@RequestParam(defaultValue = "0", required = false) Integer page,
                                          @RequestParam(defaultValue = "10", required = false) Integer size,
                                          @RequestParam(required = false) String searchTerm,
                                          @RequestParam Long mercadoId,
                                          Long id){
        return produtoService.buscarProduto(Pageable.ofSize(size).withPage(page), searchTerm, mercadoId, id);
    }
}
