package br.com.fiap.EcoSynergy.resource;

import br.com.fiap.EcoSynergy.Dto.RecomendacaoDTO;
import br.com.fiap.EcoSynergy.Service.RecomendacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recomendacoes")
public class RecomendacaoResource {

    @Autowired
    private RecomendacaoService recomendacaoService;

    @GetMapping()
    public List<RecomendacaoDTO> findAll() {
        return recomendacaoService.getAll();
    }

    @GetMapping("/{id}")
    public RecomendacaoDTO findById(@PathVariable long id) {
        return recomendacaoService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<RecomendacaoDTO> criarRecomendacao(@RequestBody RecomendacaoDTO recomendacao) {
        RecomendacaoDTO novaRecomendacao = recomendacaoService.criarRecomendacao(recomendacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaRecomendacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRecomendacao(@PathVariable long id) {
        boolean recomendacaoDeletada = recomendacaoService.deletarRecomendacao(id);
        if (recomendacaoDeletada) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecomendacaoDTO> atualizarRecomendacao(@PathVariable long id, @RequestBody RecomendacaoDTO recomendacao) {
        RecomendacaoDTO recomendacaoAtualizada = recomendacaoService.updateRecomendacao(id, recomendacao);

        if(recomendacaoAtualizada != null) {
            return ResponseEntity.ok(recomendacaoAtualizada);
        }

        return ResponseEntity.notFound().build();
    }
}
