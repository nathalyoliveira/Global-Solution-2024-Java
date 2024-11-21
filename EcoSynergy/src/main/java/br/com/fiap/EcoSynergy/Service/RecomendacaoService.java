package br.com.fiap.EcoSynergy.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.EcoSynergy.Dto.RecomendacaoDTO;
import br.com.fiap.EcoSynergy.Factory.RecomendacaoFactory;
import br.com.fiap.EcoSynergy.Model.Recomendacao;
import br.com.fiap.EcoSynergy.Repository.RecomendacaoRepository;

@Service
public class RecomendacaoService {

    @Autowired
    private RecomendacaoRepository recomendacaoRepository;

    @Autowired
    private RecomendacaoFactory factory;

    public List<RecomendacaoDTO> getAll() {
        return factory.toDto((List<Recomendacao>) recomendacaoRepository.findAll());
    }

    public RecomendacaoDTO getById(Long id) {
        Optional<Recomendacao> recomendacaoOptional = recomendacaoRepository.findById(id);
        return recomendacaoOptional.map(factory::toDto).orElse(null);
    }

    public RecomendacaoDTO criarRecomendacao(RecomendacaoDTO recomendacaoDTO) {
        Recomendacao novaRecomendacao = recomendacaoRepository.save(factory.toEntity(recomendacaoDTO));
        return factory.toDto(novaRecomendacao);
    }

    public RecomendacaoDTO updateRecomendacao(Long id, RecomendacaoDTO recomendacaoDTO) {
        Recomendacao recomendacaoExistente = recomendacaoRepository.findById(id).orElse(null);

        if (recomendacaoExistente != null) {
            Recomendacao atualizado = factory.toEntity(recomendacaoDTO);
            atualizado.setId(id);

            Recomendacao recomendacaoAtualizada = recomendacaoRepository.save(atualizado);
            return factory.toDto(recomendacaoAtualizada);
        } else {
            return null;
        }
    }

    public boolean deletarRecomendacao(Long id) {
        if (recomendacaoRepository.existsById(id)) {
            recomendacaoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
