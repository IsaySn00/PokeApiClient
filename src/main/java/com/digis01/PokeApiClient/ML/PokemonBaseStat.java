package com.digis01.PokeApiClient.ML;

public class PokemonBaseStat {
    private int base_stat;
    private int effort;
    private NamedApiResource stat;

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public NamedApiResource getStat() {
        return stat;
    }

    public void setStat(NamedApiResource stat) {
        this.stat = stat;
    }
}
