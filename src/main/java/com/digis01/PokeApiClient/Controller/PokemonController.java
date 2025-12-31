package com.digis01.PokeApiClient.Controller;

import com.digis01.PokeApiClient.ML.Pokemon;
import com.digis01.PokeApiClient.ML.Result;
import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {
    
    private final String urlBase = "http://localhost:8080/api/pokemon";

    @GetMapping()
    public String Index(@RequestParam(defaultValue = "1") int page,Model model){
        
        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<Result<Map<String, Object>>> responseEntity = restTemplate.exchange(
                urlBase + "?page=" + page,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<Result<Map<String, Object>>>(){});
        
        Result<Map<String, Object>> result = responseEntity.getBody();
        
        Map<String, Object> data = result.object;
        
        model.addAttribute("pokemons", data.get("pokemons"));
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", data.get("hasNext"));
        model.addAttribute("hasPrevious", data.get("hasPrevious"));
        
        return "index";
    }
}
