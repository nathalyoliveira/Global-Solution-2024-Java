package br.com.fiap.EcoSynergy.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.EcoSynergy.Dto.AlertaDTO;
import br.com.fiap.EcoSynergy.Factory.AlertaFactory;
import br.com.fiap.EcoSynergy.Model.Alerta;
import br.com.fiap.EcoSynergy.Repository.AlertaRepository;

@Service
public class AlertaService {
    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private AlertaFactory factory;

    public List<AlertaDTO> getAll() {
        return factory.toDto((List<Alerta>) alertaRepository.findAll());
    }

    public AlertaDTO getById(Long id) {
        Optional<Alerta> alertaOptional = alertaRepository.findById(id);
        return alertaOptional.map(factory::toDto).orElse(null);
    }

    public AlertaDTO criarAlerta(AlertaDTO Alerta){
        Alerta novoAlerta = alertaRepository.save(factory.toEntity(Alerta));
        return factory.toDto(novoAlerta);
    }

    public AlertaDTO updateAlerta(Long id, AlertaDTO alerta){
        Alerta alertaExistente = alertaRepository.findById(id).orElse(null);

        if(alertaExistente != null){
            Alerta desatualizado = factory.toEntity(alerta);
            desatualizado.setId(id);

            Alerta atualizado = alertaRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
            return factory.toDto(alertaExistente);
        }
    }

    public boolean deletarAlerta(Long id) {
        if (alertaRepository.existsById(id)) {
            alertaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
