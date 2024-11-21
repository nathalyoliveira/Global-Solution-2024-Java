package br.com.fiap.EcoSynergy.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ES_CONSUMO")
public class Consumo {

    @Id
    @Column(name="ID_CONSUMO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NR_KWH")
    private Double kwh;

    @Column(name="DT_CONSUMO")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "ID_SENSOR")
    private Sensor sensor;
    
    //@OneToMany
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CONSUMO")
    private List<Alerta> alertas;
}
