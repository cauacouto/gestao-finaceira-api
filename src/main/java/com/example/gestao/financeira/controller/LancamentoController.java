package com.example.gestao.financeira.controller;

import com.example.gestao.financeira.DTO.LacamentoDto;
import com.example.gestao.financeira.DTO.LacamentoResponseDto;
import com.example.gestao.financeira.service.LacamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    private final LacamentoService lacamentoService;

    public LancamentoController(LacamentoService lacamentoService) {
        this.lacamentoService = lacamentoService;
    }
@PostMapping
    public ResponseEntity<LacamentoResponseDto> criarLancamento(@RequestBody LacamentoDto dto) {
         LacamentoResponseDto response =  lacamentoService.criarLancamento(dto);
           return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }
}
