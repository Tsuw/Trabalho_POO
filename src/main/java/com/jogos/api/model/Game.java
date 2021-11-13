package com.jogos.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Game")
public class Game {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "releaseDate", nullable = false)
    private Date releaseDate;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "developer", nullable = false)
    private String developer;

    @Column(name = "peopleInvolved", nullable = false)
    private int peopleInvolved;

    @Column(name = "soldCopies", nullable = false)
    private int soldCopies;

    @Column(name = "distributor", nullable = false)
    private String distributor;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "hasDLC", nullable = false)
    private boolean hasDLC;

    @Column(name = "platform", nullable = false)
    private String platform;

    @OneToOne
    @JoinColumn(name = "minimumRequirements", nullable = false, referencedColumnName = "id")
    private Requirements minimumRequirements;

    @OneToOne
    @JoinColumn(name = "recommendedRequirements", nullable = false, referencedColumnName = "id")
    private Requirements recommendedRequirements;

    @Column(name = "storage", nullable = false)
    private String storage;

    public Game() {
    }

    public Game(String name, Date releaseDate, String description, String developer, int peopleInvolved, int soldCopies,
                String distributor, int score, Double price, String genre, int rating, boolean hasDLC, String platform,
                Requirements minimumRequirements, Requirements recommendedRequirements, String storage) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.description = description;
        this.developer = developer;
        this.peopleInvolved = peopleInvolved;
        this.soldCopies = soldCopies;
        this.distributor = distributor;
        this.score = score;
        this.price = price;
        this.genre = genre;
        this.rating = rating;
        this.hasDLC = hasDLC;
        this.platform = platform;
        this.minimumRequirements = minimumRequirements;
        this.recommendedRequirements = recommendedRequirements;
        this.storage = storage;
    }

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

    public Requirements getMinimumRequirements() {
        return minimumRequirements;
    }

    public void setMinimumRequirements(Requirements minimumRequirements) {
        this.minimumRequirements = minimumRequirements;
    }

    public Requirements getRecommendedRequirements() {
        return recommendedRequirements;
    }

    public void setRecommendedRequirements(Requirements recommendedRequirements) {
        this.recommendedRequirements = recommendedRequirements;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
