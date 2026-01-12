package com.digis01.PokeApiClient.ML;

import java.util.List;

public class PokemonTipoDetail {
    private int id;
    private String name;
    public List<NamedApiResource> names;
    private DamageRelations damage_relations;
    private String color;

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

    public List<NamedApiResource> getNames() {
        return names;
    }

    public void setNames(List<NamedApiResource> names) {
        this.names = names;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
