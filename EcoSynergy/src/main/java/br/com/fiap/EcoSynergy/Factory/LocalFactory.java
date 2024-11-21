package br.com.fiap.EcoSynergy.Factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.EcoSynergy.Dto.LocalDTO;
import br.com.fiap.EcoSynergy.Model.Local;

@Component
public class LocalFactory {

	@Autowired
	private UsuarioFactory usuarioFactory;

	public List<LocalDTO> toDto(List<Local> locals) {
		return Optional.ofNullable(locals).map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public LocalDTO toDto(Local local) {

		if (local == null) {
			return null;
		}

		LocalDTO dto = new LocalDTO();
		dto.setId(local.getId());
		dto.setNome(local.getNome());
		dto.setUsuario(usuarioFactory.toDto(local.getUsuario()));
		return dto;
	}

	public List<Local> toEntity(List<LocalDTO> locais) {
		return Optional.ofNullable(locais).map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public Local toEntity(LocalDTO local) {

		if (local == null) {
			return null;
		}

		Local entity = new Local();
		entity.setId(local.getId());
		entity.setNome(local.getNome());
		entity.setUsuario(usuarioFactory.toEntity(local.getUsuario()));
		return entity;
	}

}