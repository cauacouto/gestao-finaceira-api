package com.example.gestao.financeira.mapper;

import com.example.gestao.financeira.DTO.AtualizaLancamento;
import com.example.gestao.financeira.DTO.LacamentoRequestDto;
import com.example.gestao.financeira.DTO.LacamentoResponseDto;
import com.example.gestao.financeira.model.Lancamento;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

    Lancamento toEntity (LacamentoRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLancamentoFromDto(AtualizaLancamento dto , @MappingTarget Lancamento entity);


    LacamentoResponseDto toResponseDto(Lancamento entity);
}
