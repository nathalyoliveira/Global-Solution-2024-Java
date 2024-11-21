package br.com.fiap.EcoSynergy.Controller;

import br.com.fiap.EcoSynergy.Dto.LocalDTO;
import br.com.fiap.EcoSynergy.Service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService service;

    @GetMapping
    public String listarLocal(Model model) {
        List<LocalDTO> locais = service.getAll();
        model.addAttribute("locais", locais);
        return "local";
    }

    @PostMapping("/adicionar")
    public String adicionarLocal(@RequestParam String nome, Model model) {
        LocalDTO locais = new LocalDTO();
        locais.setNome(nome);
        service.criarLocal(locais);
        return "redirect:/local";
    }

    @PostMapping("/editar")
    public String editarLocal(@RequestParam Long id,@RequestParam String nome, Model model) {

        LocalDTO locais = new LocalDTO();
        locais.setId(id);
        locais.setNome(nome);
        service.updateLocal(id, locais);
        return "redirect:/local";
    }

    @PostMapping("/excluir/{id}")
    public String excluirLocal(@PathVariable Long id) {
        service.deletarLocal(id);
        return "redirect:/local";
    }

}
