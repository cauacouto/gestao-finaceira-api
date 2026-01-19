package com.example.gestao.financeira.controller;

import com.example.gestao.financeira.DTO.AtualizaLancamento;
import com.example.gestao.financeira.DTO.LacamentoRequestDto;
import com.example.gestao.financeira.DTO.LacamentoResponseDto;
import com.example.gestao.financeira.DTO.RelatorioResumoDto;
import com.example.gestao.financeira.service.LacamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    private final LacamentoService lacamentoService;

    public LancamentoController(LacamentoService lacamentoService) {
        this.lacamentoService = lacamentoService;
    }
    @PostMapping
    public ResponseEntity<LacamentoResponseDto> criarLancamento(@RequestBody LacamentoRequestDto dto) {
        LacamentoResponseDto response =  lacamentoService.criarLancamento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }
    @GetMapping("/relatorio")
    public ResponseEntity<RelatorioResumoDto> gerarRelatorio(@RequestParam int mes,@RequestParam int ano){
        RelatorioResumoDto relatorio = lacamentoService.gerarRelatorio(mes, ano);
        return ResponseEntity.ok(relatorio);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LacamentoResponseDto> atualizarParcialmente(@RequestBody @PathVariable Integer id, AtualizaLancamento dto){
        LacamentoResponseDto response = lacamentoService.atualizarLancamento(id,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLancamento(@PathVariable Integer id){
        lacamentoService.excluirLancamento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
