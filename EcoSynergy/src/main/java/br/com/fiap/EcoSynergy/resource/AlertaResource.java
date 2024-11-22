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

import br.com.fiap.EcoSynergy.Dto.AlertaDTO;
import br.com.fiap.EcoSynergy.Service.AlertaService;

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

//    @PostMapping()
//    public ResponseEntity<AlertaDTO> criarAlerta(@RequestBody AlertaDTO alerta) {
//        AlertaDTO novoAlerta = alertaService.criarAlerta(alerta);
//        return ResponseEntity.status(HttpStatus.CREATED).body(novoAlerta);
//    }
    
    @PostMapping()
    public ResponseEntity<Void> criarAlerta(@RequestBody AlertaDTO alerta) {
        alertaService.criarAlertaByPackage(alerta);
        return ResponseEntity.noContent().build();
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
