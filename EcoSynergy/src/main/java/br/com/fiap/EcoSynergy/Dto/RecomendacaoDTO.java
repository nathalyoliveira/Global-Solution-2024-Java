package br.com.fiap.EcoSynergy.Dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecomendacaoDTO {

    private Long id;
    private String recomendacao;
    private LocalDate data;
    private String status;
    private String prioridade;
    private SensorDTO sensor; 
}
