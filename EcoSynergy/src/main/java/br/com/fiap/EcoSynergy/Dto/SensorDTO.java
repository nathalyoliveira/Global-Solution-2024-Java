package br.com.fiap.EcoSynergy.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDTO {

    private Long id;
    private String status;
    private Double consumoPadrao;
    private EquipamentoDTO equipamento;
    private LocalDTO local;
}
