package br.com.fiap.EcoSynergy.resource;

import br.com.fiap.EcoSynergy.Dto.UsuarioDTO;
import br.com.fiap.EcoSynergy.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public List<UsuarioDTO> findAll() {
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable long id) {
        return usuarioService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable long id) {
        boolean usuarioDeletado = usuarioService.deletarUsuario(id);
        if (usuarioDeletado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable long id, @RequestBody UsuarioDTO usuario) {
        UsuarioDTO usuarioAtualizado = usuarioService.updateUsuario(id, usuario);

        if(usuarioAtualizado != null) {
            return ResponseEntity.ok(usuarioAtualizado);
        }

        return ResponseEntity.notFound().build();
    }
}
