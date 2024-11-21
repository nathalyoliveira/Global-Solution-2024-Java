package br.com.fiap.EcoSynergy.Repository;

import br.com.fiap.EcoSynergy.Model.Local;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends CrudRepository<Local, Long> {
}
