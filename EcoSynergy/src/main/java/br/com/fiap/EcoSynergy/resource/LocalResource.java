package br.com.fiap.EcoSynergy.resource;

import br.com.fiap.EcoSynergy.Dto.LocalDTO;
import br.com.fiap.EcoSynergy.Service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locais")
public class LocalResource {

    @Autowired
    private LocalService localService;

    @GetMapping()
    public List<LocalDTO> findAll() {
        return localService.getAll();
    }

    @GetMapping("/{id}")
    public LocalDTO findById(@PathVariable long id) {
        return localService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<LocalDTO> criarLocal(@RequestBody LocalDTO local) {
        LocalDTO novoLocal = localService.criarLocal(local);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLocal);
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
