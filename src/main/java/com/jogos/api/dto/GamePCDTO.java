package com.jogos.api.dto;

import com.jogos.api.model.GameRequirements;

import java.util.Date;

public class GamePCDTO {

    private String name;
    private Date releaseDate;
    private String description;
    private String developer;
    private String distributor;
    private int score;
    private Double price;
    private String genre;
    private int rating;
    private boolean hasDLC;
    private GameRequirements minimumRequirements;
    private GameRequirements recommendedRequirements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isHasDLC() {
        return hasDLC;
    }

    public void setHasDLC(boolean hasDLC) {
        this.hasDLC = hasDLC;
    }

    public GameRequirements getMinimumRequirements() {
        return minimumRequirements;
    }

    public void setMinimumRequirements(GameRequirements minimumRequirements) {
        this.minimumRequirements = minimumRequirements;
    }

    public GameRequirements getRecommendedRequirements() {
        return recommendedRequirements;
    }

    public void setRecommendedRequirements(GameRequirements recommendedRequirements) {
        this.recommendedRequirements = recommendedRequirements;
    }
}
