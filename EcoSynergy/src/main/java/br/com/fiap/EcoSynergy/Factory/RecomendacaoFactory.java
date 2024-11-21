package br.com.fiap.EcoSynergy.Factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.EcoSynergy.Dto.RecomendacaoDTO;
import br.com.fiap.EcoSynergy.Model.Recomendacao;

@Component
public class RecomendacaoFactory {

	@Autowired
	private SensorFactory sensorFactory;

	public List<RecomendacaoDTO> toDto(List<Recomendacao> recomendacoes) {
		return Optional.ofNullable(recomendacoes)
				.map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public RecomendacaoDTO toDto(Recomendacao recomendacao) {

		if (recomendacao == null) {
			return null;
		}

		RecomendacaoDTO dto = new RecomendacaoDTO();
		dto.setId(recomendacao.getId());
		dto.setRecomendacao(recomendacao.getRecomendacao());
		dto.setStatus(recomendacao.getStatus());
		dto.setPrioridade(recomendacao.getPrioridade());
		dto.setData(recomendacao.getData());
		dto.setSensor(sensorFactory.toDto(recomendacao.getSensor()));

		return dto;
	}

	public List<Recomendacao> toEntity(List<RecomendacaoDTO> recomendacoes) {
		return Optional.ofNullable(recomendacoes)
				.map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public Recomendacao toEntity(RecomendacaoDTO recomendacaoDTO) {

		if (recomendacaoDTO == null) {
			return null;
		}

		Recomendacao entity = new Recomendacao();
		entity.setId(recomendacaoDTO.getId());
		entity.setRecomendacao(recomendacaoDTO.getRecomendacao());
		entity.setStatus(recomendacaoDTO.getStatus());
		entity.setPrioridade(recomendacaoDTO.getPrioridade());
		entity.setData(recomendacaoDTO.getData());
		entity.setSensor(sensorFactory.toEntity(recomendacaoDTO.getSensor()));
		return entity;
	}
}