package br.com.fiap.EcoSynergy.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalDTO {

    private Long id;
    private String nome;
    private UsuarioDTO usuario;
}
