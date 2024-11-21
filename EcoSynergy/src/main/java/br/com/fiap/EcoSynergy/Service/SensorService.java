package br.com.fiap.EcoSynergy.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.EcoSynergy.Dto.SensorDTO;
import br.com.fiap.EcoSynergy.Factory.SensorFactory;
import br.com.fiap.EcoSynergy.Model.Sensor;
import br.com.fiap.EcoSynergy.Repository.SensorRepository;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private SensorFactory factory;

    public List<SensorDTO> getAll() {
        return factory.toDto((List<Sensor>) sensorRepository.findAll());
    }

    public SensorDTO getById(Long id) {
        Optional<Sensor> sensorOptional = sensorRepository.findById(id);
        return sensorOptional.map(factory::toDto).orElse(null);
    }

    public SensorDTO criarSensor(SensorDTO sensorDTO) {
        Sensor novoSensor = sensorRepository.save(factory.toEntity(sensorDTO));
        return factory.toDto(novoSensor);
    }

    public SensorDTO updateSensor(Long id, SensorDTO sensorDTO) {
        Sensor sensorExistente = sensorRepository.findById(id).orElse(null);

        if (sensorExistente != null) {
            Sensor atualizado = factory.toEntity(sensorDTO);
            atualizado.setId(id);

            Sensor sensorAtualizado = sensorRepository.save(atualizado);
            return factory.toDto(sensorAtualizado);
        } else {
            return null;
        }
    }

    public boolean deletarSensor(Long id) {
        if (sensorRepository.existsById(id)) {
            sensorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
