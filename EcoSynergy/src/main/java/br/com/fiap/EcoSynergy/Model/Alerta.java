package br.com.fiap.EcoSynergy.Model;

import java.time.LocalDate;

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
@Table(name="ES_ALERTA")
public class Alerta {

    @Id
    @Column(name="ID_ALERTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DS_ALERTA")
    private String descricao;

    @Column(name = "DT_ALERTA")
    private LocalDate data;

    @Column(name = "DS_STATUS")
    private String status;
}
