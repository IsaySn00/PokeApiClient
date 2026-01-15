package com.digis01.PokeApiClient.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/error-view")
public class ErrorViewController {

    @GetMapping()
    public String error(@RequestParam int code, Model model) {

        String message = "";
        String desc = "";
        String image = "";

        switch (code) {
            case 403 -> {
                message = "¡Acceso Bloqueado!";
                desc = "No tienes los permisos necesarios para acceder a esta vista.";
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/143.png";
            }
            case 500 -> {
                message = "Error interno";
                desc = "Algo salió mal en el servidor.";
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/54.png";
            }
            case 404 ->{
                message = "Página no encontrada";
                desc = "La página que buscas no existe";
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/129.png";
            }
        }

        model.addAttribute("code", code);
        model.addAttribute("message", message);
        model.addAttribute("desc", desc);
        model.addAttribute("image", image);

        return "error";
    }
}
