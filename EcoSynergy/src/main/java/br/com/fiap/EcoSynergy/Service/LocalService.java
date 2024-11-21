package br.com.fiap.EcoSynergy.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.EcoSynergy.Dto.LocalDTO;
import br.com.fiap.EcoSynergy.Factory.LocalFactory;
import br.com.fiap.EcoSynergy.Model.Local;
import br.com.fiap.EcoSynergy.Repository.LocalRepository;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private LocalFactory factory;

    public List<LocalDTO> getAll() {
        return factory.toDto((List<Local>) localRepository.findAll());
    }

    public LocalDTO getById(Long id) {
        Optional<Local> localOptional = localRepository.findById(id);
        return localOptional.map(factory::toDto).orElse(null);
    }

    public LocalDTO criarLocal(LocalDTO localDTO) {
        Local novoLocal = localRepository.save(factory.toEntity(localDTO));
        return factory.toDto(novoLocal);
    }

    public LocalDTO updateLocal(Long id, LocalDTO localDTO) {
        Local localExistente = localRepository.findById(id).orElse(null);

        if (localExistente != null) {
            Local atualizado = factory.toEntity(localDTO);
            atualizado.setId(id);

            Local localAtualizado = localRepository.save(atualizado);
            return factory.toDto(localAtualizado);
        } else {
            return null;
        }
    }

    public boolean deletarLocal(Long id) {
        if (localRepository.existsById(id)) {
            localRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
