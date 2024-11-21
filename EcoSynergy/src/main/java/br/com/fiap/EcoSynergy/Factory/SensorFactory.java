package br.com.fiap.EcoSynergy.Factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.EcoSynergy.Dto.SensorDTO;
import br.com.fiap.EcoSynergy.Model.Sensor;

@Component
public class SensorFactory {

	@Autowired
	private EquipamentoFactory equipamentoFactory;
	@Autowired
	private LocalFactory localFactory;

	public List<SensorDTO> toDto(List<Sensor> sensors) {
		return Optional.ofNullable(sensors).map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public SensorDTO toDto(Sensor sensor) {

		if (sensor == null) {
			return null;
		}

		SensorDTO dto = new SensorDTO();
		dto.setId(sensor.getId());
		dto.setConsumoPadrao(sensor.getConsumoPadrao());
		dto.setStatus(sensor.getStatus());
		dto.setLocal(localFactory.toDto(sensor.getLocal()));
		dto.setEquipamento(equipamentoFactory.toDto(sensor.getEquipamento()));
		return dto;
	}

	public List<Sensor> toEntity(List<SensorDTO> sensors) {
		return Optional.ofNullable(sensors)
				.map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public Sensor toEntity(SensorDTO sensor) {

		if (sensor == null) {
			return null;
		}
		Sensor entity = new Sensor();
		entity.setId(sensor.getId());
		entity.setConsumoPadrao(sensor.getConsumoPadrao());
		entity.setStatus(sensor.getStatus());
		entity.setLocal(localFactory.toEntity(sensor.getLocal()));
		entity.setEquipamento(equipamentoFactory.toEntity(sensor.getEquipamento()));
		return entity;
	}

}