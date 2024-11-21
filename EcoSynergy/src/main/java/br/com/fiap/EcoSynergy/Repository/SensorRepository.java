package br.com.fiap.EcoSynergy.Repository;

import br.com.fiap.EcoSynergy.Model.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends CrudRepository<Sensor, Long> {
}
