package br.com.fiap.EcoSynergy.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.EcoSynergy.Dto.ConsumoDTO;
import br.com.fiap.EcoSynergy.Factory.ConsumoFactory;
import br.com.fiap.EcoSynergy.Model.Consumo;
import br.com.fiap.EcoSynergy.Repository.ConsumoRepository;

@Service
public class ConsumoService {

	@Autowired
	private ConsumoRepository consumoRepository;
	@Autowired
	private ConsumoFactory factory;

	public List<ConsumoDTO> getAll() {
		return factory.toDTO((List<Consumo>) consumoRepository.findAll());
	}

	public ConsumoDTO getById(Long id) {
		Optional<Consumo> consumoOptional = consumoRepository.findById(id);
		return consumoOptional.map(factory::toDto).orElse(null);
	}

	public ConsumoDTO criarConsumo(ConsumoDTO consumoDTO) {
		Consumo novoConsumo = consumoRepository.save(factory.toEntity(consumoDTO));
		return factory.toDto(novoConsumo);
	}

	public ConsumoDTO updateConsumo(Long id, ConsumoDTO consumoDTO) {
		Consumo consumoExistente = consumoRepository.findById(id).orElse(null);

		if (consumoExistente != null) {
			Consumo atualizado = factory.toEntity(consumoDTO);
			atualizado.setId(id);

			Consumo consumoAtualizado = consumoRepository.save(atualizado);
			return factory.toDto(consumoAtualizado);
		} else {
			return null;
		}
	}

	public boolean deletarConsumo(Long id) {
		if (consumoRepository.existsById(id)) {
			consumoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
