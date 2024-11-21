package br.com.fiap.EcoSynergy.Repository;

import br.com.fiap.EcoSynergy.Model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
