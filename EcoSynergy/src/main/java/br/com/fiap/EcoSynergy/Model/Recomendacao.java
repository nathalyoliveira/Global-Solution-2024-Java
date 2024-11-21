package br.com.fiap.EcoSynergy.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ES_RECOMENDACAO")
public class Recomendacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_RECOMENDACAO")
    private Long id;

    @Column(name="DS_RECOMENDACAO")
    private String recomendacao;

    @Column(name = "DT_RECOMENDACAO")
    private LocalDate data;

    @Column(name="DS_STATUS")
    private String status;

    @Column(name="DS_PRIORIDADE")
    private String prioridade;

    @ManyToOne
    @JoinColumn(name = "ID_SENSOR")
    private Sensor sensor;
}
