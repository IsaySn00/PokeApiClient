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
    private NamedApiResource ability;
    
    private PokemonHabilidadDetail abilityDetail;
    
    public PokemonHabilidades(){
    
    }
    
    public PokemonHabilidades(boolean is_hidden, int slot, NamedApiResource ability){
        this.is_hidden = is_hidden;
        this.slot = slot;
        this.ability = ability;
    }

    public boolean getIs_hidden() {
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

    public NamedApiResource getAbility() {
        return ability;
    }

    public void setAbility(NamedApiResource ability) {
        this.ability = ability;
    }

    public PokemonHabilidadDetail getAbilityDetail() {
        return abilityDetail;
    }

    public void setAbilityDetail(PokemonHabilidadDetail abilityDetail) {
        this.abilityDetail = abilityDetail;
    }
    
}
