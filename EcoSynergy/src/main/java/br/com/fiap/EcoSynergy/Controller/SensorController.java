package br.com.fiap.EcoSynergy.Controller;

import br.com.fiap.EcoSynergy.Dto.LocalDTO;
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
    
    @GetMapping("/{idLocal}")
    public String listarSensor(@PathVariable Long idLocal, Model model) {
        List<SensorDTO> sensores = service.getAll(idLocal);
        model.addAttribute("sensores", sensores);
        model.addAttribute("idLocal", idLocal);
        return "sensor";
    }

    @PostMapping("/adicionar")
    public String adicionarSensor(@RequestParam String status,
                                  @RequestParam Double consumoPadrao,
                                  @RequestParam Long idLocal,
                                  Model model) {
    	
    	LocalDTO local = new LocalDTO();
    	local.setId(idLocal);
    	
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setStatus(status);
        sensorDTO.setConsumoPadrao(consumoPadrao);
        sensorDTO.setLocal(local);

        service.criarSensor(sensorDTO);
        return "redirect:/sensor/" + idLocal;
    }

    @PostMapping("/editar")
    public String editarSensor(@RequestParam Long id,
                               @RequestParam String status,
                               @RequestParam Double consumoPadrao,
                               @RequestParam Long idLocal,
                               //@RequestParam Long idEquipamento, 
                               Model model) {
    	
    	LocalDTO local = new LocalDTO();
    	local.setId(idLocal);
    	
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setId(id);
        sensorDTO.setStatus(status);
        sensorDTO.setConsumoPadrao(consumoPadrao);
        sensorDTO.setLocal(local);
        service.updateSensor(id, sensorDTO);
        
        //model.addAttribute("idLocal", idLocal);
       // return "sensor";
        
        //return "redirect:/sensor";
        
        //listarSensor(idLocal, model);
        
        List<SensorDTO> sensores = service.getAll(idLocal);
        model.addAttribute("sensores", sensores);
        model.addAttribute("idLocal", idLocal);
        return "sensor";
    }

    @PostMapping("/excluir/{id}")
    public String excluirSensor(@PathVariable Long id) {
        service.deletarSensor(id);
        return "redirect:/sensor";
    }
}
