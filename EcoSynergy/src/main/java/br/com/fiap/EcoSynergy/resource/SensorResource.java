package br.com.fiap.EcoSynergy.resource;

import br.com.fiap.EcoSynergy.Dto.SensorDTO;
import br.com.fiap.EcoSynergy.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensores")
public class SensorResource {

    @Autowired
    private SensorService sensorService;

    @GetMapping()
    public List<SensorDTO> findAll() {
        return sensorService.getAll();
    }

    @GetMapping("/{id}")
    public SensorDTO findById(@PathVariable long id) {
        return sensorService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<SensorDTO> criarSensor(@RequestBody SensorDTO sensor) {
        SensorDTO novoSensor = sensorService.criarSensor(sensor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoSensor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSensor(@PathVariable long id) {
        boolean sensorDeletado = sensorService.deletarSensor(id);
        if (sensorDeletado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorDTO> atualizarSensor(@PathVariable long id, @RequestBody SensorDTO sensor) {
        SensorDTO sensorAtualizado = sensorService.updateSensor(id, sensor);

        if(sensorAtualizado != null) {
            return ResponseEntity.ok(sensorAtualizado);
        }

        return ResponseEntity.notFound().build();
    }
}
