package br.com.fiap.EcoSynergy.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.EcoSynergy.Dto.EquipamentoDTO;
import br.com.fiap.EcoSynergy.Factory.EquipamentoFactory;
import br.com.fiap.EcoSynergy.Model.Equipamento;
import br.com.fiap.EcoSynergy.Repository.EquipamentoRepository;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private EquipamentoFactory factory;

    public List<EquipamentoDTO> getAll() {
        return factory.toDto((List<Equipamento>) equipamentoRepository.findAll());
    }

    public EquipamentoDTO getById(Long id) {
        Optional<Equipamento> equipamentoOptional = equipamentoRepository.findById(id);
        return equipamentoOptional.map(factory::toDto).orElse(null);
    }

    public EquipamentoDTO criarEquipamento(EquipamentoDTO equipamentoDTO) {
        Equipamento novoEquipamento = equipamentoRepository.save(factory.toEntity(equipamentoDTO));
        return factory.toDto(novoEquipamento);
    }

    public EquipamentoDTO updateEquipamento(Long id, EquipamentoDTO equipamentoDTO) {
        Equipamento equipamentoExistente = equipamentoRepository.findById(id).orElse(null);

        if (equipamentoExistente != null) {
            Equipamento atualizado = factory.toEntity(equipamentoDTO);
            atualizado.setId(id);

            Equipamento equipamentoAtualizado = equipamentoRepository.save(atualizado);
            return factory.toDto(equipamentoAtualizado);
        } else {
            return null;
        }
    }

    public boolean deletarEquipamento(Long id) {
        if (equipamentoRepository.existsById(id)) {
            equipamentoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
