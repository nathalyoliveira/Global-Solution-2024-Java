package br.com.fiap.EcoSynergy.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.fiap.EcoSynergy.Dto.UsuarioDTO;
import br.com.fiap.EcoSynergy.Factory.UsuarioFactory;
import br.com.fiap.EcoSynergy.Model.Usuario;
import br.com.fiap.EcoSynergy.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioFactory factory;

    public List<UsuarioDTO> getAll() {
        return factory.toDto((List<Usuario>) usuarioRepository.findAll());
    }

    public UsuarioDTO getById(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.map(factory::toDto).orElse(null);
    }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario novoUsuario = usuarioRepository.save(factory.toEntity(usuarioDTO));
        return factory.toDto(novoUsuario);
    }

    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);

        if (usuarioExistente != null) {
            Usuario atualizado = factory.toEntity(usuarioDTO);
            atualizado.setId(id);

            Usuario usuarioAtualizado = usuarioRepository.save(atualizado);
            return factory.toDto(usuarioAtualizado);
        } else {
            return null;
        }
    }

    public boolean deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByUsername(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Usuário já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }
    
    public Usuario getUsuarioLogado() {
        String email = getUsuarioLogadoEmail();
        return usuarioRepository.findByUsername(email)
                .orElseThrow(() -> new IllegalStateException("Usuário não encontrado: " + email));
    }

    private String getUsuarioLogadoEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        throw new IllegalStateException("Usuário não autenticado");
    }
}
