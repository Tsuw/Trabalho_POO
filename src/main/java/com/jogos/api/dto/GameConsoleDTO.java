package com.jogos.api.dto;

import com.jogos.api.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameConsoleDTO extends NeutralGDTO{

    private List<DlcConsoleDTO> dlc = new ArrayList<>();
    private String storage;

    public GameConsoleDTO(Game game) {
        this.name = game.getName();
        this.releaseDate = game.getReleaseDate();
        this.description = game.getDescription();
        this.developer = game.getDeveloper();
        this.distributor = game.getDistributor();
        this.score = game.getScore();
        this.price = game.getPrice();
        this.genre = game.getGenre();
        this.rating = game.getRating();
        this.platform = game.getPlatform();
        this.storage = game.getStorage();
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public List<DlcConsoleDTO> getDlc() {
        return dlc;
    }

    public void setDlc(List<DlcConsoleDTO> dlc) {
        this.dlc = dlc;
    }
}