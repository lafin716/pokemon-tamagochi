package com.lafin.servlet.model.pokemon;

public class Revolution {

    private int id;

    private int pokemonId;

    private int nextPokemonId;

    private int requireLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public int getNextPokemonId() {
        return nextPokemonId;
    }

    public void setNextPokemonId(int nextPokemonId) {
        this.nextPokemonId = nextPokemonId;
    }

    public int getRequireLevel() {
        return requireLevel;
    }

    public void setRequireLevel(int requireLevel) {
        this.requireLevel = requireLevel;
    }
}
