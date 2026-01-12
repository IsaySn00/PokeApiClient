package com.digis01.PokeApiClient.ML;

import java.util.ArrayList;
import java.util.List;

public class PokemonEvolucion {
    private int id;
    private String name;
    private String image;

    public PokemonEvolucion(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
    
    public PokemonEvolucion(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
