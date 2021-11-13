package com.jogos.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DLC")
public class Dlc {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
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

    @Column(name = "platform", nullable = false)
    private String platform;

    @Column(name = "ownedGame", nullable = false)
    private String ownedGame;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "minimumRequirements", referencedColumnName = "id")
    private Requirements minimumRequirements;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recommendedRequirements", referencedColumnName = "id")
    private Requirements recommendedRequirements;

    @Column(name = "storage")
    private String storage;

    public Dlc() {
    }

    public Dlc(String name, Date releaseDate, String description, String developer, int peopleInvolved, int soldCopies,
               String distributor, int score, Double price, String genre, int rating, String platform,
               Requirements minimumRequirements, Requirements recommendedRequirements, String storage, String ownedGame) {
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
        this.platform = platform;
        this.minimumRequirements = minimumRequirements;
        this.recommendedRequirements = recommendedRequirements;
        this.storage = storage;
        this.ownedGame = ownedGame;
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

    public String getOwnedGame() {
        return ownedGame;
    }

    public void setOwnedGame(String ownedGame) {
        this.ownedGame = ownedGame;
    }
}
