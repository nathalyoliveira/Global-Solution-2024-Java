package br.com.fiap.EcoSynergy.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.EcoSynergy.Dto.LocalDTO;
import br.com.fiap.EcoSynergy.Service.LocalService;
import br.com.fiap.EcoSynergy.Service.UsuarioService;

@RestController
@RequestMapping("/api/locais")
public class LocalResource {

    @Autowired
    private LocalService localService;
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public List<LocalDTO> findAll() {
        return localService.getAllFromUser(usuarioService.getUsuarioLogado());
    }

    @GetMapping("/{id}")
    public LocalDTO findById(@PathVariable long id) {
        return localService.getById(id);
    }

//    @PostMapping()
//    public ResponseEntity<LocalDTO> criarLocal(@RequestBody LocalDTO local) {
//        LocalDTO novoLocal = localService.criarLocal(local);
//        return ResponseEntity.status(HttpStatus.CREATED).body(novoLocal);
//    }
    
    @PostMapping()
    public ResponseEntity<Void> criarLocal(@RequestBody LocalDTO local) {
        localService.criarLocalByPackage(local);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLocal(@PathVariable long id) {
        boolean localDeletado = localService.deletarLocal(id);
        if (localDeletado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalDTO> atualizarLocal(@PathVariable long id, @RequestBody LocalDTO local) {
        LocalDTO localAtualizado = localService.updateLocal(id, local);

        if(localAtualizado != null) {
            return ResponseEntity.ok(localAtualizado);
        }

        return ResponseEntity.notFound().build();
    }
}
