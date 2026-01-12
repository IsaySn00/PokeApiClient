package com.digis01.PokeApiClient.ML;

import java.util.List;

public class DamageRelations {
    private List<NamedApiResource> double_damage_to;
    private List<NamedApiResource> double_damage_from;
    private List<NamedApiResource> half_damage_from;
    private List<NamedApiResource> half_damage_to;

    public List<NamedApiResource> getDouble_damage_to() {
        return double_damage_to;
    }

    public void setDouble_damage_to(List<NamedApiResource> double_damage_to) {
        this.double_damage_to = double_damage_to;
    }

    public List<NamedApiResource> getDouble_damage_from() {
        return double_damage_from;
    }

    public void setDouble_damage_from(List<NamedApiResource> double_damage_from) {
        this.double_damage_from = double_damage_from;
    }

    public List<NamedApiResource> getHalf_damage_from() {
        return half_damage_from;
    }

    public void setHalf_damage_from(List<NamedApiResource> half_damage_from) {
        this.half_damage_from = half_damage_from;
    }

    public List<NamedApiResource> getHalf_damage_to() {
        return half_damage_to;
    }

    public void setHalf_damage_to(List<NamedApiResource> half_damage_to) {
        this.half_damage_to = half_damage_to;
    }
}
