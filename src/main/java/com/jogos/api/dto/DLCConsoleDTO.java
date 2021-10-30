package com.jogos.api.dto;

import com.jogos.api.model.NeutralDLC;

import java.util.Date;

public class DLCConsoleDTO {

    private String ownedGame;
    private String name;
    private Date releaseDate;
    private String description;
    private String developer;
    private String distributor;
    private int score;
    private Double price;
    private String genre;
    private int rating;
    private String platform;
    private String storage;

    public DLCConsoleDTO(NeutralDLC enty) {
        this.ownedGame = enty.getOwnedGame();
        this.name = enty.getName();
        this.releaseDate = enty.getReleaseDate();
        this.description = enty.getDescription();
        this.developer = enty.getDeveloper();
        this.distributor = enty.getDistributor();
        this.score = enty.getScore();
        this.price = enty.getPrice();
        this.genre = enty.getGenre();
        this.rating = enty.getRating();
        this.platform = enty.getPlatform();
    }

    public String getOwnedGame() {
        return ownedGame;
    }

    public void setOwnedGame(String ownedGame) {
        this.ownedGame = ownedGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
