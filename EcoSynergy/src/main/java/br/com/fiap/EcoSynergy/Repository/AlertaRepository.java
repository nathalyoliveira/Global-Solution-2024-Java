package br.com.fiap.EcoSynergy.Repository;

import br.com.fiap.EcoSynergy.Model.Alerta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends CrudRepository<Alerta, Long> {
}
