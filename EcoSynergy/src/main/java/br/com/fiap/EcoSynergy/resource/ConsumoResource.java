package br.com.fiap.EcoSynergy.resource;

import br.com.fiap.EcoSynergy.Dto.ConsumoDTO;
import br.com.fiap.EcoSynergy.Service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumos")
public class ConsumoResource {

    @Autowired
    private ConsumoService consumoService;

    @GetMapping()
    public List<ConsumoDTO> findAll() {
        return consumoService.getAll();
    }

    @GetMapping("/{id}")
    public ConsumoDTO findById(@PathVariable long id) {
        return consumoService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<ConsumoDTO> criarConsumo(@RequestBody ConsumoDTO consumo) {
        ConsumoDTO novoConsumo = consumoService.criarConsumo(consumo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConsumo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirConsumo(@PathVariable long id) {
        boolean consumoDeletado = consumoService.deletarConsumo(id);
        if (consumoDeletado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumoDTO> atualizarConsumo(@PathVariable long id, @RequestBody ConsumoDTO consumo) {
        ConsumoDTO consumoAtualizado = consumoService.updateConsumo(id, consumo);

        if(consumoAtualizado != null) {
            return ResponseEntity.ok(consumoAtualizado);
        }

        return ResponseEntity.notFound().build();
    }
}
