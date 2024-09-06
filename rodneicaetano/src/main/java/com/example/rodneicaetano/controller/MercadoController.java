package com.example.rodneicaetano.controller;

import com.example.rodneicaetano.dto.MercadoDto;
import com.example.rodneicaetano.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercados")
public class MercadoController {

    @Autowired
    private MercadoService mercadoService;

    @PostMapping("/cadastrar-mercado")
    public MercadoDto cadastrarMercado(@RequestBody MercadoDto cadastraMercado){
        return mercadoService.criaMercado(cadastraMercado);
    }

    @GetMapping
    public List<MercadoDto> buscarMercados(@RequestParam(defaultValue = "0", required = false) Integer page,
                                           @RequestParam(defaultValue = "10", required = false) Integer size,
                                           @RequestParam(required = false) String searchTerm){
        return mercadoService.listarMercados(Pageable.ofSize(size).withPage(page), searchTerm);
    }

}
