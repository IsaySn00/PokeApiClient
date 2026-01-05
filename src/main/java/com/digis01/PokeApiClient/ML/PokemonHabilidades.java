/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.PokeApiClient.ML;

import java.util.HashMap;
import java.util.Map;

public class PokemonHabilidades {
    private boolean is_hidden;
    private int slot;
    Map<String, String> ability = new HashMap<>();
    
    public PokemonHabilidades(){
    
    }
    
    public PokemonHabilidades(boolean is_hidden, int slot){
        this.is_hidden = is_hidden;
        this.slot = slot;
        ability.put("name", "");
        ability.put("url", "");
    }

    public boolean isIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Map<String, String> getAbility() {
        return ability;
    }

    public void setAbility(Map<String, String> ability) {
        this.ability = ability;
    }
    
}
