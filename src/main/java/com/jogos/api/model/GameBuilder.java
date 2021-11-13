package com.jogos.api.model;

import java.util.Date;
import java.util.List;

public class GameBuilder {
    private String name;
    private Date releaseDate;
    private String description;
    private String developer;
    private int peopleInvolved;
    private int soldCopies;
    private String distributor;
    private int score;
    private Double price;
    private String genre;
    private int rating;
    private String platform;
    private Requirements minimumRequirements;
    private Requirements recommendedRequirements;
    private String storage;
    private List<Dlc> dlc;

    public GameBuilder(){
    }

    public GameBuilder withDlc(List<Dlc> dlc){
        this.dlc = dlc;
        return this;
    }

    public GameBuilder withName(String name){
        this.name = name;
        return this;
    }

    public GameBuilder withReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
        return this;
    }

    public GameBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public GameBuilder withDeveloper(String developer){
        this.developer = developer;
        return this;
    }

    public GameBuilder withPeopleInvolved(int peopleInvolved){
        this.peopleInvolved = peopleInvolved;
        return this;
    }

    public GameBuilder withSoldCopies(int soldCopies){
        this.soldCopies = soldCopies;
        return this;
    }

    public GameBuilder withDistributor(String distributor){
        this.distributor = distributor;
        return this;
    }

    public GameBuilder withScore(int score){
        this.score = score;
        return this;
    }

    public GameBuilder withPrice(Double price){
        this.price = price;
        return this;
    }

    public GameBuilder withGenre(String genre){
        this.genre = genre;
        return this;
    }

    public GameBuilder withRating(int rating){
        this.rating = rating;
        return this;
    }

    public GameBuilder withPlatform(String platform){
        this.platform = platform;
        return this;
    }

    public GameBuilder withStorage(String storage){
        this.storage = storage;
        return this;
    }

    public GameBuilder withMinimumRequirements(Requirements minimumRequirements){
        this.minimumRequirements = minimumRequirements;
        return this;
    }

    public GameBuilder withRecommendedRequirements(Requirements recommendedRequirements){
        this.recommendedRequirements = recommendedRequirements;
        return this;
    }

    public Game build(){
        return new Game(name, releaseDate, description, developer, peopleInvolved, soldCopies, distributor,
                score, price, genre, rating, platform, minimumRequirements, recommendedRequirements, storage, dlc);
    }
}
