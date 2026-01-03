package com.digis01.PokeApiClient.Controller;

import com.digis01.PokeApiClient.ML.Result;
import com.digis01.PokeApiClient.ML.Usuario;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final String urlBase = "http://localhost:8080/api/usuario";

    @GetMapping("registroUsuario")
    public String AddUsuario(Model model) {

        Usuario usuario = new Usuario();

        model.addAttribute("usuario", usuario);

        return "usuarioForm";
    }

    @PostMapping("add")
    public String AddUsuario(@ModelAttribute("Usuario") Usuario usuario, RedirectAttributes redirectAttributes) {
        Result result = new Result();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeader = new HttpHeaders();

        httpHeader.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity<>(usuario, httpHeader);

        ResponseEntity<Result> responseEntity = restTemplate.exchange(
                urlBase,
                HttpMethod.POST,
                entity,
                Result.class);

        redirectAttributes.addFlashAttribute("sucess", "EL usuario" + usuario.getUserName() + "Se creo con exito");
        redirectAttributes.addFlashAttribute("icon", "success");

        return "redirect:/pokemon/index";
    }
}
