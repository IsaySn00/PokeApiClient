package com.digis01.PokeApiClient.Controller;

import com.digis01.PokeApiClient.ML.Pokemon;
import com.digis01.PokeApiClient.ML.PokemonDetail;
import com.digis01.PokeApiClient.ML.PokemonTipoDetail;
import com.digis01.PokeApiClient.ML.Result;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

    private final String urlBase = "http://localhost:8080/api/pokemon";
    private final String urlBaseFav = "http://localhost:8080/api/favorito/";

    @GetMapping()
    public String Index(@RequestParam(defaultValue = "1") int page, Model model, HttpSession session) {

        RestTemplate restTemplate = new RestTemplate();
        
        String tkn = (String) session.getAttribute("tkn");
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setBearerAuth(tkn);
        
        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<Result<Map<String, Object>>> responseEntity = restTemplate.exchange(
                urlBase + "?page=" + page,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Result<Map<String, Object>>>() {
        });

        Result<Map<String, Object>> result = responseEntity.getBody();

        Map<String, Object> data = result.object;

        model.addAttribute("pokemons", data.get("pokemons"));
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", data.get("hasNext"));
        model.addAttribute("hasPrevious", data.get("hasPrevious"));
        model.addAttribute("totalPages", data.get("totalPages"));
        model.addAttribute("startPage", data.get("startPage"));
        model.addAttribute("endPage", data.get("endPage"));

        return "index";
    }

    @GetMapping("/detail/{id}")
    public String Detail(@PathVariable("id") int Id_Pokemon, Model model, HttpSession session) {
        
        RestTemplate restTemplate = new RestTemplate();
        
        String tkn = (String) session.getAttribute("tkn");
        int idUsuario = (int) session.getAttribute("id");
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setBearerAuth(tkn);
        
        HttpEntity entity = new HttpEntity<>(headers);
        
        ResponseEntity<Result<PokemonDetail>> responseEntity = restTemplate.exchange(
                urlBase + "/" + Id_Pokemon,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Result<PokemonDetail>>() {
        });
        
        ResponseEntity<Result<Boolean>> responseFavorito = restTemplate.exchange(
                urlBaseFav + "existe?idUsuario=" + idUsuario + "&idPokemon=" + Id_Pokemon,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Result<Boolean>>(){});

        Result result = responseEntity.getBody();
        
        Result resultFav = responseFavorito.getBody();
        
        boolean isFavorito = false;
        
        if(resultFav != null && resultFav.correct && resultFav.object != null){
            isFavorito = (Boolean) resultFav.object;
        }

        model.addAttribute("pokemon", result.object);
        model.addAttribute("isFavorito", isFavorito);

        return "detail";
    }
    
    @GetMapping("/tipos")
    public String GetTipos(HttpSession session, Model model){
        
        RestTemplate restTemplate = new RestTemplate();
        
        String tkn = (String) session.getAttribute("tkn");
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setBearerAuth(tkn);
        
        HttpEntity entity = new HttpEntity<>(headers);
                
        ResponseEntity<Result<List<PokemonTipoDetail>>> responseEntity = restTemplate.exchange(
                urlBase + "/tipos",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Result<List<PokemonTipoDetail>>>(){});
        
        Result<List<PokemonTipoDetail>> result = responseEntity.getBody();
        
        model.addAttribute("tipos", result.object);
        
        return "tiposPokemon";
    }

    @GetMapping("/realizar-busqueda")
    public String Buscador(@RequestParam("name") String name, Model model, HttpSession session) {
        RestTemplate restTemplate = new RestTemplate();
        
        String tkn = (String) session.getAttribute("tkn");
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setBearerAuth(tkn);
        
        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<Result<Map<String, Object>>> responseEntity = restTemplate.exchange(
                urlBase + "/buscador?name=" + name,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Result<Map<String, Object>>>() {
        });

        Result<Map<String, Object>> result = responseEntity.getBody();

        Map<String, Object> data = result.object;

        model.addAttribute("pokemons", Collections.singleton(data));

        model.addAttribute("startPage", 1);
        model.addAttribute("endPage", 1);

        return "index";
    }
}
