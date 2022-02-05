package com.lafin.servlet.service;

import com.lafin.servlet.model.pokemon.Pokemon;
import com.lafin.servlet.persistence.PokemonPersistence;

import java.util.Arrays;
import java.util.List;

public class PokemonService {

    private final String[] STARTER_POKEMON_ID = new String[]{"001", "004", "007"};

    private PokemonPersistence pokemonPersistence;

    public PokemonService() {
        pokemonPersistence = new PokemonPersistence();
    }

    public List<Pokemon> getStarterPokemons() {
        return pokemonPersistence.getPokemonByIds(Arrays.asList(STARTER_POKEMON_ID));
    }
}
