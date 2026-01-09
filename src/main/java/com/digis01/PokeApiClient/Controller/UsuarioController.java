package com.digis01.PokeApiClient.Controller;

import com.digis01.PokeApiClient.ML.Result;
import com.digis01.PokeApiClient.ML.Rol;
import com.digis01.PokeApiClient.ML.Usuario;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final String urlBase = "http://localhost:8080/api/";

    @GetMapping("registroUsuario")
    public String AddUsuario(Model model) {

        Usuario usuario = new Usuario();

        model.addAttribute("usuario", usuario);

        return "usuarioForm";
    }

    @PostMapping("add")
    public String AddUsuario(@ModelAttribute("Usuario") Usuario usuario, RedirectAttributes redirectAttributes, HttpSession session) {
        Result result = new Result();

        Rol rol = new Rol();

        rol.setIdRol(2);
        usuario.setRol(rol);

        RestTemplate restTemplate = new RestTemplate();

        String tkn = (String) session.getAttribute("tkn");

        HttpHeaders httpHeader = new HttpHeaders();

        httpHeader.setContentType(MediaType.APPLICATION_JSON);
        httpHeader.setBearerAuth(tkn);

        HttpEntity entity = new HttpEntity<>(usuario, httpHeader);

        ResponseEntity<Result> responseEntity = restTemplate.exchange(
                urlBase + "usuario",
                HttpMethod.POST,
                entity,
                Result.class);

        redirectAttributes.addFlashAttribute("sucess", "EL usuario" + usuario.getUserName() + "Se creo con exito");
        redirectAttributes.addFlashAttribute("icon", "success");

        return "redirect:/pokemon";
    }

    @GetMapping("/{id}")
    public String GetDetailUsuario(@PathVariable("id") int id, Model model, HttpSession session) {

        RestTemplate restTemplate = new RestTemplate();

        String tkn = (String) session.getAttribute("tkn");

        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(tkn);

        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<Result<Usuario>> responseEntity = restTemplate.exchange(
                urlBase + "/usuario/" + id,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Result<Usuario>>() {
        });

        Result result = responseEntity.getBody();
        model.addAttribute("usuario", result.object);

        return "detailUsuario";
    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @PostMapping("/login")
    public String Login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {

        try {
            Usuario usuario = new Usuario();
            usuario.setEmailUsuario(email);
            usuario.setPasswordUsuario(password);

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders header = new HttpHeaders();

            header.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Usuario> entity = new HttpEntity<>(usuario, header);

            ResponseEntity<Result<Map<String, Object>>> responseEntity = restTemplate.exchange(
                    urlBase + "auth/login",
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<Result<Map<String, Object>>>() {
            });

            Map<String, Object> data = responseEntity.getBody().object;

            String rol = data.get("rol").toString();
            Integer idUsuario = (Integer) data.get("idUsuario");
            String tkn = data.get("token").toString();

            session.setAttribute("tkn", tkn);
            session.setAttribute("role", rol);
            session.setAttribute("id", idUsuario);

            return "redirect:/pokemon";

        } catch (Exception ex) {
            model.addAttribute("error", true);
            return "redirect:/usuario/login";
        }
    }

    @GetMapping()
    public String GetAllUsuario(Model model, HttpSession session) {
        String tkn = (String) session.getAttribute("tkn");

        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(tkn);

        HttpEntity entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Result<List<Usuario>>> responseEntity = restTemplate.exchange(urlBase + "usuario",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Result<List<Usuario>>>() {
        });

        Result result = responseEntity.getBody();
        model.addAttribute("usuarios", result.object);

        return "usuarioIndex";
    }

    @DeleteMapping("/{idUsuario}")
    public String DeleteUsuario(@PathVariable("idUsuario") int id, Model model, HttpSession session) {
        String tkn = (String) session.getAttribute("tkn");

        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(tkn);

        HttpEntity entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Result<List<Usuario>>> responseEntity = restTemplate.exchange(urlBase + "usuario/" + id,
                HttpMethod.DELETE,
                entity,
                new ParameterizedTypeReference<Result<List<Usuario>>>() {
        });

        Result result = responseEntity.getBody();
        model.addAttribute("usuarios", result.object);

        return "redirect:/usuario";
    }

    @PatchMapping("/update")
    public String UpdateUsuario(@ModelAttribute("usuario") Usuario usuario, HttpSession session, Model model, RedirectAttributes redirectAttributes) {

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        try {
            String tkn = (String) session.getAttribute("tkn");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(tkn);

            HttpEntity entity = new HttpEntity<>(usuario, headers);

            ResponseEntity<Result> responseEntity = restTemplate.exchange(
                    urlBase + "usuario",
                    HttpMethod.PATCH,
                    entity,
                    Result.class);

            redirectAttributes.addFlashAttribute("successMessage", "Se han actualizado los datos correctamente");
            redirectAttributes.addFlashAttribute("iconModal", "success");

        } catch (Exception ex) {
            model.addAttribute("error", true);
        }

        return "redirect:/usuario/" + usuario.getIdUsuario();
    }
}
