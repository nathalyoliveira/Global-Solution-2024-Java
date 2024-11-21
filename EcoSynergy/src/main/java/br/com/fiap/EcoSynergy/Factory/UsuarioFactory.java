package br.com.fiap.EcoSynergy.Factory;

import br.com.fiap.EcoSynergy.Dto.UsuarioDTO;
import br.com.fiap.EcoSynergy.Model.Usuario;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UsuarioFactory {

	public List<UsuarioDTO> toDto(List<Usuario> usuarios) {
		return Optional.ofNullable(usuarios).map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public UsuarioDTO toDto(Usuario usuario) {
		if (usuario == null) {
			return null;
		}

		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		dto.setEmail(usuario.getEmail());
		dto.setSenha(usuario.getSenha());
		return dto;
	}

	public List<Usuario> toEntity(List<UsuarioDTO> usuarios) {
		return Optional.ofNullable(usuarios)
				.map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public Usuario toEntity(UsuarioDTO usuarioDTO) {

		if (usuarioDTO == null) {
			return null;
		}

		Usuario entity = new Usuario();
		entity.setId(usuarioDTO.getId());
		entity.setNome(usuarioDTO.getNome());
		entity.setEmail(usuarioDTO.getEmail());
		entity.setSenha(usuarioDTO.getSenha());
		return entity;
	}

}