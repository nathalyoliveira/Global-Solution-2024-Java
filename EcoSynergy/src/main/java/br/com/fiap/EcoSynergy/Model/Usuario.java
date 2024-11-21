package br.com.fiap.EcoSynergy.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ES_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_USUARIO")
    private Long id;

    @Column(name="DS_NOME")
    private String nome;

    @Column(name="DS_EMAIl")
    private String email;

    @Column(name="DS_SENHA")
    private String senha;
}
