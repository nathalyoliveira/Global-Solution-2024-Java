package br.com.fiap.EcoSynergy.Repository;

import br.com.fiap.EcoSynergy.Model.Equipamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends CrudRepository<Equipamento, Long> {
}
