package br.com.fiap.EcoSynergy.Controller;

import br.com.fiap.EcoSynergy.Dto.AlertaDTO;
import br.com.fiap.EcoSynergy.Service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaService service;

    @GetMapping
    public String listarAlerta(Model model) {
        List<AlertaDTO> alertas = service.getAll();
        model.addAttribute("alertas", alertas);
        return "alertas";
    }

    @PostMapping("/adicionar")
    public String adicionarAlerta(@RequestParam String descricao, Model model) {
        AlertaDTO alerta = new AlertaDTO();
        alerta.setDescricao(descricao);
        service.criarAlerta(alerta);
        return "redirect:/alertas";
    }

    @PostMapping("/editar")
    public String editarAlerta(@RequestParam Long id, @RequestParam String descricao, Model model) {
        AlertaDTO alerta = new AlertaDTO();
        alerta.setId(id);
        alerta.setDescricao(descricao);
        service.updateAlerta(id, alerta);
        return "redirect:/alertas";
    }

    @PostMapping("excluir/{id}")
    public String excluirAlerta(@PathVariable Long id) {
        service.deletarAlerta(id);
        return "redirect:/alertas";
    }

}
