    package com.jogos.api.model;

    import javax.persistence.*;
    import java.util.Date;

    @Entity
    @Table(name = "GamesConsole")
    public class GameConsole extends NeutralGame{

        @Id
        @Column(name = "ID", nullable = false)
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

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
