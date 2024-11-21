package br.com.fiap.EcoSynergy.Controller;

import br.com.fiap.EcoSynergy.Dto.ConsumoDTO;
import br.com.fiap.EcoSynergy.Service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consumo")
public class ConsumoController {

    @Autowired
    private ConsumoService service;

    @GetMapping
    public String listarConsumos(Model model){
        List<ConsumoDTO> consumos = service.getAll();
        model.addAttribute("consumos", consumos);
        return "consumo";
    }

    @PostMapping("/adicionar")
    public String adicionarConsumo(@RequestParam Double kwh, Model model){
        ConsumoDTO consumo = new ConsumoDTO();
        consumo.setKwh(kwh);
        service.criarConsumo(consumo);
        return "redirect:/consumo";
    }

    @PostMapping("/editar")
    public String editarConsumo(@RequestParam Long id,@RequestParam Double kwh, Model model){
        ConsumoDTO consumo = new ConsumoDTO();
        consumo.setId(id);
        consumo.setKwh(kwh);
        service.updateConsumo(id, consumo);
        return "redirect:/consumo";
    }

    @PostMapping("/excluir/{id}")
    public String excluirConsumo(@PathVariable Long id){
        service.deletarConsumo(id);
        return "redirect:/consumo";
    }


}
