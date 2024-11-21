package br.com.fiap.EcoSynergy.Factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.fiap.EcoSynergy.Dto.EquipamentoDTO;
import br.com.fiap.EcoSynergy.Model.Equipamento;

@Component
public class EquipamentoFactory {

	public List<EquipamentoDTO> toDto(List<Equipamento> equipamentos) {
		return Optional.ofNullable(equipamentos)
				.map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public EquipamentoDTO toDto(Equipamento equipamento) {

		if (equipamento == null) {
			return null;
		}

		EquipamentoDTO dto = new EquipamentoDTO();
		dto.setId(equipamento.getId());
		dto.setNome(equipamento.getNome());
		dto.setTipo(equipamento.getTipo());
		return dto;
	}

	public List<Equipamento> toEntity(List<EquipamentoDTO> equipamentoDTOs) {
		return Optional.ofNullable(equipamentoDTOs)
				.map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public Equipamento toEntity(EquipamentoDTO equipamentoDTO) {

		if (equipamentoDTO == null) {
			return null;
		}
		Equipamento entity = new Equipamento();
		entity.setId(equipamentoDTO.getId());
		entity.setNome(equipamentoDTO.getNome());
		entity.setTipo(equipamentoDTO.getTipo());
		return entity;
	}

}