package br.com.fiap.EcoSynergy.Controller;

import br.com.fiap.EcoSynergy.Dto.UsuarioDTO;
import br.com.fiap.EcoSynergy.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public String listarUsuario(Model model) {
        List<UsuarioDTO> usuarios = service.getAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario";  // Retorna a view "usuario"
    }

    @PostMapping("/adicionar")
    public String adicionarUsuario(@RequestParam String nome,
                                   @RequestParam String email,
                                   @RequestParam String senha, Model model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome(nome);
        usuarioDTO.setEmail(email);
        usuarioDTO.setSenha(senha);
        service.criarUsuario(usuarioDTO);
        return "redirect:/usuario";
    }

    @PostMapping("/editar")
    public String editarUsuario(@RequestParam Long id,
                                @RequestParam String nome,
                                @RequestParam String email,
                                @RequestParam String senha, Model model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(id);
        usuarioDTO.setNome(nome);
        usuarioDTO.setEmail(email);
        usuarioDTO.setSenha(senha);
        service.updateUsuario(id, usuarioDTO);
        return "redirect:/usuario";
    }

    @PostMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable Long id) {
        service.deletarUsuario(id);
        return "redirect:/usuario";
    }
}
