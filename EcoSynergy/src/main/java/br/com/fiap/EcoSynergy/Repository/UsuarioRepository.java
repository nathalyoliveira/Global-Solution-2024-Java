package br.com.fiap.EcoSynergy.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.EcoSynergy.Model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Optional<Usuario> findByUsername(@Param("email") String username);
}
