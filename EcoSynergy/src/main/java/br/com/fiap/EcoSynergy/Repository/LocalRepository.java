package br.com.fiap.EcoSynergy.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.EcoSynergy.Model.Local;
import br.com.fiap.EcoSynergy.Model.Usuario;

@Repository
public interface LocalRepository extends CrudRepository<Local, Long> {
	
	List<Local> findByUsuario(Usuario usuario);
}
