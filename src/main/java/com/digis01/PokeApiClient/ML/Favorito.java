package com.digis01.PokeApiClient.ML;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



public class Favorito {

    private int idFavorito;
    
    private int idPokemon;
    
    private Pokemon pokemonData;

    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public Pokemon getPokemonData() {
        return pokemonData;
    }

    public void setPokemonData(Pokemon pokemonData) {
        this.pokemonData = pokemonData;
    }
    
    
      
}
