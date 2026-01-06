/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.PokeApiClient.ML;

import java.util.ArrayList;
import java.util.List;

public class PokemonDetail {
    private int id;
    private String name;
    private int base_experience;
    private int height;
    private int weight;
    public List<PokemonHabilidades> abilities;
    public List<PokemonTipos> types = new ArrayList<>();
//    Map<String, Object> sprites = new HashMap<>();
    public PokemonSprites sprites;
    
    public PokemonDetail(){
    
    }
    
    public PokemonDetail(int id, String name, int base_experience, int height, int weight){
        this.id = id;
        this.name = name;
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
//        sprites.put("back_default", "");
//        sprites.put("back_female", "");
//        sprites.put("back_shiny", "");
//        sprites.put("back_shiny_female", "");
//        sprites.put("front_default", "");
//        sprites.put("front_female", "");
//        sprites.put("front_shiny", "");
//        sprites.put("front_shiny_female", "");
//        sprites.remove("other");
//        sprites.remove("home");
//        sprites.remove("official-artwork");
//        sprites.remove("showdown");
    }

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

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int experience) {
        this.base_experience = experience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<PokemonHabilidades> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<PokemonHabilidades> abilities) {
        this.abilities = abilities;
    }

    public List<PokemonTipos> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonTipos> types) {
        this.types = types;
    }

    public PokemonSprites getSprites() {
        return sprites;
    }

    public void setSprites(PokemonSprites sprites) {
        this.sprites = sprites;
    }
}
