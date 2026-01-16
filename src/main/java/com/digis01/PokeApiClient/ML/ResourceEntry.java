package com.digis01.PokeApiClient.ML;

public class ResourceEntry {

    private NamedApiResource pokemon;
    private int slot;

    public NamedApiResource getPokemon() {
        return pokemon;
    }

    public void setPokemon(NamedApiResource pokemon) {
        this.pokemon = pokemon;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
