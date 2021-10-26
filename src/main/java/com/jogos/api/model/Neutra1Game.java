package com.jogos.api.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Neutra1Game {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "releaseDate", nullable = false)
    protected Date releaseDate;

    @Column(name = "description", nullable = false)
    protected String description;

    @Column(name = "developer", nullable = false)
    protected String developer;

    @Column(name = "peopleInvolved", nullable = false)
    protected int peopleInvolved;

    @Column(name = "soldCopies", nullable = false)
    protected int soldCopies;

    @Column(name = "distributor", nullable = false)
    protected String distributor;

    @Column(name = "score", nullable = false)
    protected int score;

    @Column(name = "price", nullable = false, scale = 2)
    protected Double price;

    @Column(name = "genre", nullable = false)
    protected String genre;

    @Column(name = "rating", nullable = false)
    protected int rating;

    @Column(name = "hasDLC")
    protected boolean hasDLC;

    @Column(name = "platform")
    protected String platform;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getPeopleInvolved() {
        return peopleInvolved;
    }

    public void setPeopleInvolved(int peopleInvolved) {
        this.peopleInvolved = peopleInvolved;
    }

    public int getSoldCopies() {
        return soldCopies;
    }

    public void setSoldCopies(int soldCopies) {
        this.soldCopies = soldCopies;
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

    public boolean isHasDLC() {
        return hasDLC;
    }

    public void setHasDLC(boolean hasDLC) {
        this.hasDLC = hasDLC;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
