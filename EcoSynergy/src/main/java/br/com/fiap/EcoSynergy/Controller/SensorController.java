package br.com.fiap.EcoSynergy.Controller;

import br.com.fiap.EcoSynergy.Dto.SensorDTO;
import br.com.fiap.EcoSynergy.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    private SensorService service;


    @GetMapping
    public String listarSensor(Model model) {
        List<SensorDTO> sensores = service.getAll();
        model.addAttribute("sensores", sensores);
        return "sensor";
    }

    @PostMapping("/adicionar")
    public String adicionarSensor(@RequestParam String status,
                                  @RequestParam Double consumoPadrao,
                                  Model model) {
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setStatus(status);
        sensorDTO.setConsumoPadrao(consumoPadrao);

        service.criarSensor(sensorDTO);
        return "redirect:/sensor";
    }

    @PostMapping("/editar")
    public String editarSensor(@RequestParam Long id,
                               @RequestParam String status,
                               @RequestParam Double consumoPadrao,
                               @RequestParam Long idLocal,
                               @RequestParam Long idEquipamento, Model model) {
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setId(id);
        sensorDTO.setStatus(status);
        sensorDTO.setConsumoPadrao(consumoPadrao);
        service.updateSensor(id, sensorDTO);
        return "redirect:/sensor";
    }

    @PostMapping("/excluir/{id}")
    public String excluirSensor(@PathVariable Long id) {
        service.deletarSensor(id);
        return "redirect:/sensor";
    }
}
