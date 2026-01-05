/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.PokeApiClient.ML;

import java.util.HashMap;
import java.util.Map;

public class PokemonTipos {
    private int slot;
    Map<String, String> type = new HashMap<>();
    
    public PokemonTipos(){
    
    }
    
    public PokemonTipos(int slot){
        this.slot = slot;
        type.put("name", "");
        type.put("url", "");
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Map<String, String> getType() {
        return type;
    }

    public void setType(Map<String, String> type) {
        this.type = type;
    }

}
