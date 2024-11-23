package br.com.fiap.EcoSynergy.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.EcoSynergy.Model.Local;
import br.com.fiap.EcoSynergy.Model.Sensor;

@Repository
public interface SensorRepository extends CrudRepository<Sensor, Long> {

	List<Sensor> findByLocal(Local local);
}
