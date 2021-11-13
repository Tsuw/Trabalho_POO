package com.jogos.api.dto;

import com.jogos.api.model.Dlc;

public class DlcConsoleDTO extends NeutralDDTO{

    private String storage;

    public DlcConsoleDTO(Dlc dlc) {

        this.name = dlc.getName();
        this.releaseDate = dlc.getReleaseDate();
        this.description = dlc.getDescription();
        this.developer = dlc.getDeveloper();
        this.distributor = dlc.getDistributor();
        this.score = dlc.getScore();
        this.price = dlc.getPrice();
        this.genre = dlc.getGenre();
        this.rating = dlc.getRating();
        this.platform = dlc.getPlatform();
        this.storage = dlc.getStorage();
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
