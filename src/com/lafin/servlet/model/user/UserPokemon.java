package com.lafin.servlet.model.user;

import com.lafin.servlet.constant.PokemonStatus;

import java.time.LocalDateTime;

public class UserPokemon {

    private int id;

    private int ownerId;

    private int pokemonId;

    private String pokemonCode;

    private boolean main;

    private PokemonStatus status;

    private String originName;

    private String nickName;

    private int hapiness;

    private int hungry;

    private LocalDateTime catchedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public PokemonStatus getStatus() {
        return status;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getPokemonCode() {
        return pokemonCode;
    }

    public void setPokemonCode(String pokemonCode) {
        this.pokemonCode = pokemonCode;
    }

    public void setStatus(PokemonStatus status) {
        this.status = status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getHapiness() {
        return hapiness;
    }

    public void setHapiness(int hapiness) {
        this.hapiness = hapiness;
    }

    public int getHungry() {
        return hungry;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public LocalDateTime getCatchedAt() {
        return catchedAt;
    }

    public void setCatchedAt(LocalDateTime catchedAt) {
        this.catchedAt = catchedAt;
    }
}
