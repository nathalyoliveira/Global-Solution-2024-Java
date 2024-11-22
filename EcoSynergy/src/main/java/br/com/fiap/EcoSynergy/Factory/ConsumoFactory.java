package br.com.fiap.EcoSynergy.Factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.EcoSynergy.Dto.ConsumoDTO;
import br.com.fiap.EcoSynergy.Model.Consumo;

@Component
public class ConsumoFactory {

	@Autowired
	private SensorFactory sensorFactory;
//	@Autowired
//	private AlertaFactory alertaFactory;

	public List<ConsumoDTO> toDTO(List<Consumo> consumos) {
		return Optional.ofNullable(consumos).map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public ConsumoDTO toDto(Consumo consumo) {

		if (consumo == null) {
			return null;
		}

		ConsumoDTO dto = new ConsumoDTO();
		dto.setId(consumo.getId());
		dto.setKwh(consumo.getKwh());
		dto.setData(consumo.getData());
		dto.setSensor(sensorFactory.toDto(consumo.getSensor()));
//		dto.setAlertas(alertaFactory.toDto(consumo.getAlertas()));
		return dto;
	}

	public List<Consumo> toEntity(List<ConsumoDTO> consumos) {
		return Optional.ofNullable(consumos)
				.map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public Consumo toEntity(ConsumoDTO consumoDTO) {

		if (consumoDTO == null) {
			return null;
		}

		Consumo entity = new Consumo();
		entity.setId(consumoDTO.getId());
		entity.setKwh(consumoDTO.getKwh());
		entity.setData(consumoDTO.getData());
		entity.setSensor(sensorFactory.toEntity(consumoDTO.getSensor()));
//		entity.setAlertas(alertaFactory.toEntity(consumoDTO.getAlertas()));
		return entity;
	}

}