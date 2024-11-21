package br.com.fiap.EcoSynergy.Controller;

import br.com.fiap.EcoSynergy.Dto.RecomendacaoDTO;
import br.com.fiap.EcoSynergy.Service.RecomendacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recomendacao")
public class RecomendacaoController {

    @Autowired
    private RecomendacaoService service;

    // Listar todas as recomendações
    @GetMapping
    public String listarRecomendacao(Model model) {
        List<RecomendacaoDTO> recomendacoes = service.getAll();
        model.addAttribute("recomendacoes", recomendacoes);
        return "recomendacao";  // Retorna a view "recomendacao"
    }

    // Adicionar uma nova recomendação
    @PostMapping("/adicionar")
    public String adicionarRecomendacao(@RequestParam String recomendacao,
                                        @RequestParam String prioridade,
                                        @RequestParam String status,
                                        Model model) {
        RecomendacaoDTO recomendacaoDTO = new RecomendacaoDTO();
        recomendacaoDTO.setRecomendacao(recomendacao);
        recomendacaoDTO.setPrioridade(prioridade);
        recomendacaoDTO.setStatus(status);

        service.criarRecomendacao(recomendacaoDTO);
        return "redirect:/recomendacao";  // Redireciona para a lista de recomendações
    }

    // Editar uma recomendação existente
    @PostMapping("/editar")
    public String editarRecomendacao(@RequestParam Long id,
                                     @RequestParam String recomendacao,
                                     @RequestParam String prioridade,
                                     @RequestParam String status, Model model) {
        RecomendacaoDTO recomendacaoDTO = new RecomendacaoDTO();
        recomendacaoDTO.setId(id);
        recomendacaoDTO.setRecomendacao(recomendacao);
        recomendacaoDTO.setPrioridade(prioridade);
        recomendacaoDTO.setStatus(status);
        service.updateRecomendacao(id, recomendacaoDTO);
        return "redirect:/recomendacao";  // Redireciona para a lista de recomendações
    }

    // Excluir uma recomendação
    @PostMapping("/excluir/{id}")
    public String excluirRecomendacao(@PathVariable Long id) {
        service.deletarRecomendacao(id);
        return "redirect:/recomendacao";  // Redireciona para a lista de recomendações
    }
}
