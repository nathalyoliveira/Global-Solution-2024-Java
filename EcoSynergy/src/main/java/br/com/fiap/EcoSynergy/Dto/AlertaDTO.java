package br.com.fiap.EcoSynergy.Dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlertaDTO {
    private Long id;
    private String descricao;
    private LocalDate data;
    private String status;
    private ConsumoDTO consumo;
}
