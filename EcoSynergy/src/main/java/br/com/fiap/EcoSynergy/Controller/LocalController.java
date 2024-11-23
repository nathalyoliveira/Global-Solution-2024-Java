package br.com.fiap.EcoSynergy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.EcoSynergy.Dto.LocalDTO;
import br.com.fiap.EcoSynergy.Dto.UsuarioDTO;
import br.com.fiap.EcoSynergy.Model.Usuario;
import br.com.fiap.EcoSynergy.Service.LocalService;
import br.com.fiap.EcoSynergy.Service.UsuarioService;

@Controller
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService service;
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarLocal(Model model) {
    	List<LocalDTO> locais = service.getAllFromUser(usuarioService.getUsuarioLogado());
        model.addAttribute("locais", locais);
        return "local";
    }

    @PostMapping("/adicionar")
    public String adicionarLocal(@RequestParam String nome, Model model) {
        
    	Usuario usuario = usuarioService.getUsuarioLogado();
    	UsuarioDTO usuarioDTO = new UsuarioDTO();
    	
    	if(usuario != null) {
    		usuarioDTO.setId(usuario.getId());
    		LocalDTO local = new LocalDTO();
            local.setNome(nome);
            local.setUsuario(usuarioDTO);
            service.criarLocal(local);
    	}
    	
        return "redirect:/local";
    }

    @PostMapping("/editar")
    public String editarLocal(@RequestParam Long id,@RequestParam String nome, Model model) {
    	
    	Usuario usuario = usuarioService.getUsuarioLogado();
    	UsuarioDTO usuarioDTO = new UsuarioDTO();
    	
    	if(usuario != null) {
    		usuarioDTO.setId(usuario.getId());
    		LocalDTO local = new LocalDTO();
    		local.setId(id);
            local.setNome(nome);
            local.setUsuario(usuarioDTO);
            service.updateLocal(id, local);
    	}

        return "redirect:/local";
    }

    @PostMapping("/excluir/{id}")
    public String excluirLocal(@PathVariable Long id) {
        service.deletarLocal(id);
        return "redirect:/local";
    }

}
