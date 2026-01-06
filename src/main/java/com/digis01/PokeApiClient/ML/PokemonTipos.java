/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.PokeApiClient.ML;

import java.util.HashMap;
import java.util.Map;

public class PokemonTipos {
    private int slot;
    private NamedApiResource type;
    
    public PokemonTipos(){
    
    }
    
    public PokemonTipos(int slot, NamedApiResource type){
        this.slot = slot;
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public NamedApiResource getType() {
        return type;
    }

    public void setType(NamedApiResource type) {
        this.type = type;
    }

    
}
