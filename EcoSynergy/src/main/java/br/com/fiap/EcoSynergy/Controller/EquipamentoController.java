package br.com.fiap.EcoSynergy.Controller;

import br.com.fiap.EcoSynergy.Dto.EquipamentoDTO;
import br.com.fiap.EcoSynergy.Service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService service;

    @GetMapping
    public String listarEquipamentos(Model model) {
        List<EquipamentoDTO> equipamentos = service.getAll();
        model.addAttribute("equipamentos", equipamentos);
        return "equipamentos";
    }

    @PostMapping("/adicionar")
    public String adicionarEquipamento(@RequestParam String nome, Model model) {
        EquipamentoDTO equipamento = new EquipamentoDTO();
        equipamento.setNome(nome);
        service.criarEquipamento(equipamento);
        return "redirect:/equipamentos";
    }

    @PostMapping("/editar")
    public String editarEquipamento(@RequestParam Long id,@RequestParam String nome, Model model) {

        EquipamentoDTO equipamento = new EquipamentoDTO();
        equipamento.setId(id);
        equipamento.setNome(nome);
        service.updateEquipamento(id, equipamento);
        return "redirect:/equipamentos";
    }

    @PostMapping("/excluir/{id}")
    public String excluirEquipamento(@PathVariable Long id) {
        service.deletarEquipamento(id);
        return "redirect:/equipamentos";
    }

}
