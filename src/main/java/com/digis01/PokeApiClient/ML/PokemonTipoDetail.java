package com.digis01.PokeApiClient.ML;

import java.util.List;

public class PokemonTipoDetail {

    private int id;
    private String name;
    private String originalName;
    public List<Names> names;
    private DamageRelations damage_relations;
    private String color;
    private List<ResourceEntry> pokemon;

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

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public List<Names> getNames() {
        return names;
    }

    public void setNames(List<Names> names) {
        this.names = names;
    }

    public DamageRelations getDamage_relations() {
        return damage_relations;
    }

    public void setDamage_relations(DamageRelations damage_relations) {
        this.damage_relations = damage_relations;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<ResourceEntry> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<ResourceEntry> pokemon) {
        this.pokemon = pokemon;
    }
    
}
