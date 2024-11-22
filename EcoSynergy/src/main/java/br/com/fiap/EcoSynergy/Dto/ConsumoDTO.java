package br.com.fiap.EcoSynergy.Dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumoDTO {

    private Long id;
    private Double kwh;
    private LocalDate data;
    private SensorDTO sensor;
//    private List<AlertaDTO> alertas;
}
