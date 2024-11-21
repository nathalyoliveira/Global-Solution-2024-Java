package br.com.fiap.EcoSynergy.Security;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.EcoSynergy.Model.Usuario;
import br.com.fiap.EcoSynergy.Repository.UsuarioRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {	
	
	private final UsuarioRepository repository;

    public CustomUserDetailsService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> login = repository.findByUsername(username);
        if (login.isPresent()) {
            var usernameobj = login.get();
            return User.builder()
                    .username(usernameobj.getEmail())
                    .password(usernameobj.getSenha())
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username );
        }
    }
}