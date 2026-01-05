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
    private int base_experince;
    private int height;
    private int weight;
    public List<PokemonHabilidades> abilities = new ArrayList<>();
    public List<PokemonTipos> types = new ArrayList<>();
//    Map<String, Object> sprites = new HashMap<>();
    public PokemonSprites sprites;
    
    public PokemonDetail(){
    
    }
    
    public PokemonDetail(int id, String name, int base_experience, int height, int weight){
        this.id = id;
        this.name = name;
        this.base_experince = base_experience;
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

    public int getId_Pokemon() {
        return id;
    }

    public void setId_Pokemon(int id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public int getBase_experince() {
        return base_experince;
    }

    public void setBase_experince(int base_experince) {
        this.base_experince = base_experince;
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

//    public Map<String, Object> getSprites() {
//        return sprites;
//    }
//
//    public void setSprites(Map<String, Object> sprites) {
//        this.sprites = sprites;
//    }
}
