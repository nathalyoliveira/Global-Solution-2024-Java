package br.com.fiap.EcoSynergy.resource;

import br.com.fiap.EcoSynergy.Dto.EquipamentoDTO;
import br.com.fiap.EcoSynergy.Service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoResource {

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping()
    public List<EquipamentoDTO> findAll() {
        return equipamentoService.getAll();
    }

    @GetMapping("/{id}")
    public EquipamentoDTO findById(@PathVariable long id) {
        return equipamentoService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<EquipamentoDTO> criarEquipamento(@RequestBody EquipamentoDTO equipamento) {
        EquipamentoDTO novoEquipamento = equipamentoService.criarEquipamento(equipamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEquipamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEquipamento(@PathVariable long id) {
        boolean equipamentoDeletado = equipamentoService.deletarEquipamento(id);
        if (equipamentoDeletado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> atualizarEquipamento(@PathVariable long id, @RequestBody EquipamentoDTO equipamento) {
        EquipamentoDTO equipamentoAtualizado = equipamentoService.updateEquipamento(id, equipamento);

        if(equipamentoAtualizado != null) {
            return ResponseEntity.ok(equipamentoAtualizado);
        }

        return ResponseEntity.notFound().build();
    }
}
