package br.com.fiap.EcoSynergy.resource;

import br.com.fiap.EcoSynergy.Dto.AlertaDTO;
import br.com.fiap.EcoSynergy.Service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaResource {

    @Autowired
    private AlertaService alertaService;

    @GetMapping()
    public List<AlertaDTO> findAll() {
        return alertaService.getAll();
    }

    @GetMapping("/{id}")
    public AlertaDTO findById(@PathVariable long id) {
        return alertaService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<AlertaDTO> criarAlerta(@RequestBody AlertaDTO alerta) {
        AlertaDTO novoAlerta = alertaService.criarAlerta(alerta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAlerta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAlerta(@PathVariable long id) {
        boolean alertaDeletado = alertaService.deletarAlerta(id);
        if (alertaDeletado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertaDTO> atualizarAlerta(@PathVariable long id, @RequestBody AlertaDTO alerta) {
        AlertaDTO alertaAtualizado = alertaService.updateAlerta(id, alerta);

        if(alertaAtualizado != null) {
            return ResponseEntity.ok(alertaAtualizado);
        }

        return ResponseEntity.notFound().build();
    }
}
