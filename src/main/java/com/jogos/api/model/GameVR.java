package com.jogos.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GameVR")
public class GameVR extends NeutralGame{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
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

    @Column(name = "price", nullable = false, scale = 2)
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
    private GameRequirements minimumRequirements;

    @OneToOne
    @JoinColumn(name = "recommendedRequirements", nullable = false, referencedColumnName = "id")
    private GameRequirements recommendedRequirements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}