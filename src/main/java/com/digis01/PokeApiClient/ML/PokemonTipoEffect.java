package com.digis01.PokeApiClient.ML;

public class PokemonTipoEffect {
    private String name;
    private String color;
    private double multiplier;

    public PokemonTipoEffect(String name, String color, double multiplier) {
        this.name = name;
        this.color = color;
        this.multiplier = multiplier;
    }
    
    public PokemonTipoEffect(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}
