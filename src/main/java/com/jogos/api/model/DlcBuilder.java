package com.jogos.api.model;

import java.util.Date;

public class DlcBuilder {

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
    private String ownedGame;
    private Requirements minimumRequirements;
    private Requirements recommendedRequirements;
    private String storage;

    public DlcBuilder() {
    }

    public DlcBuilder withName(String name){
        this.name = name;
        return this;
    }

    public DlcBuilder withReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
        return this;
    }

    public DlcBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public DlcBuilder withDeveloper(String developer){
        this.developer = developer;
        return this;
    }

    public DlcBuilder withPeopleInvolved(int peopleInvolved){
        this.peopleInvolved = peopleInvolved;
        return this;
    }

    public DlcBuilder withSoldCopies(int soldCopies){
        this.soldCopies = soldCopies;
        return this;
    }

    public DlcBuilder withDistributor(String distributor){
        this.distributor = distributor;
        return this;
    }

    public DlcBuilder withScore(int score){
        this.score = score;
        return this;
    }

    public DlcBuilder withPrice(Double price){
        this.price = price;
        return this;
    }

    public DlcBuilder withGenre(String genre){
        this.genre = genre;
        return this;
    }

    public DlcBuilder withRating(int rating){
        this.rating = rating;
        return this;
    }

    public DlcBuilder withPlatform(String platform){
        this.platform = platform;
        return this;
    }

    public DlcBuilder withOwnedGame(String ownedGame){
        this.ownedGame = ownedGame;
        return this;
    }

    public DlcBuilder withStorage(String storage){
        this.storage = storage;
        return this;
    }

    public DlcBuilder withMinimumRequirements(Requirements minimumRequirements){
        this.minimumRequirements = minimumRequirements;
        return this;
    }

    public DlcBuilder withRecommendedRequirements(Requirements recommendedRequirements){
        this.recommendedRequirements = recommendedRequirements;
        return this;
    }

    public Dlc build(){
        return new Dlc(name, releaseDate, description, developer, peopleInvolved, soldCopies, distributor, score, price,
                genre, rating, platform, minimumRequirements, recommendedRequirements, storage, ownedGame);
    }

}
