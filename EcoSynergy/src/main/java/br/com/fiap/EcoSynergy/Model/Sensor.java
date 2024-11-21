package br.com.fiap.EcoSynergy.Model;

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
@Table(name="ES_SENSOR")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_SENSOR")
    private Long id;

    @Column(name="DS_STATUS")
    private String status;

    @Column(name="NR_CONSUMO_PADRAO")
    private Double consumoPadrao;

    @ManyToOne
    @JoinColumn(name = "ID_LOCAL")
    private Local local;

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPAMENTO")
    private Equipamento equipamento;

}
