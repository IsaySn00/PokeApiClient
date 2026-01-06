/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.PokeApiClient.ML;

import java.util.List;

public class PokemonHabilidadDetail {
    private int id;
    private String name;
    public List<NamedApiResource> names;

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
}
