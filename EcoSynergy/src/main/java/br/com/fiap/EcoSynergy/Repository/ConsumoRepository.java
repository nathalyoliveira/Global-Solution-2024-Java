package br.com.fiap.EcoSynergy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.EcoSynergy.Model.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
}
