package br.com.fiap.EcoSynergy.Repository;

import br.com.fiap.EcoSynergy.Model.Recomendacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendacaoRepository extends CrudRepository<Recomendacao, Long> {
}
