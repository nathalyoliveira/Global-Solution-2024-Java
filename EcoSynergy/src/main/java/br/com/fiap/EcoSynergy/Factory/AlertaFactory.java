package br.com.fiap.EcoSynergy.Factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.EcoSynergy.Dto.AlertaDTO;
import br.com.fiap.EcoSynergy.Model.Alerta;

@Component
public class AlertaFactory {
	
	@Autowired
	ConsumoFactory consumoFactory;

	public List<AlertaDTO> toDto(List<Alerta> alertas) {
		return Optional.ofNullable(alertas).map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public AlertaDTO toDto(Alerta alerta) {

		if (alerta == null) {
			return null;
		}

		AlertaDTO dto = new AlertaDTO();
		dto.setId(alerta.getId());
		dto.setStatus(alerta.getStatus());
		dto.setData(alerta.getData());
		dto.setDescricao(alerta.getDescricao());
		dto.setConsumo(consumoFactory.toDto(alerta.getConsumo()));
		return dto;
	}

	public List<Alerta> toEntity(List<AlertaDTO> alertas) {
		return Optional.ofNullable(alertas)
				.map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public Alerta toEntity(AlertaDTO alerta) {

		if (alerta == null) {
			return null;
		}

		Alerta entity = new Alerta();
		entity.setId(alerta.getId());
		entity.setStatus(alerta.getStatus());
		entity.setData(alerta.getData());
		entity.setDescricao(alerta.getDescricao());
		entity.setConsumo(consumoFactory.toEntity(alerta.getConsumo()));
		return entity;
	}
}
