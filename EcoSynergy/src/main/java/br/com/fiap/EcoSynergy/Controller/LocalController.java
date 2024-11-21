package br.com.fiap.EcoSynergy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.EcoSynergy.Dto.LocalDTO;
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
        List<LocalDTO> locais = service.getAll();
        model.addAttribute("locais", locais);
        return "local";
    }

    @PostMapping("/adicionar")
    public String adicionarLocal(@RequestParam String nome, @AuthenticationPrincipal User loggedUser, Model model) {
        
    	//UsuarioDTO usuario = usuarioService.getById(idUsuario);
    	
    	System.out.println(loggedUser.toString());
    	
    	LocalDTO local = new LocalDTO();
        local.setNome(nome);
        //local.setUsuario(usuario);
        service.criarLocal(local);
        return "redirect:/local";
    }

    @PostMapping("/editar")
    public String editarLocal(@RequestParam Long id,@RequestParam String nome, Model model) {

        LocalDTO local = new LocalDTO();
        local.setId(id);
        local.setNome(nome);
        service.updateLocal(id, local);
        return "redirect:/local";
    }

    @PostMapping("/excluir/{id}")
    public String excluirLocal(@PathVariable Long id) {
        service.deletarLocal(id);
        return "redirect:/local";
    }

}
