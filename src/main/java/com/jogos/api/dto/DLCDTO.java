    package com.jogos.api.dto;

    import java.util.Date;

    public class DLCDTO {

        private Long id;
        private String ownedGame;
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

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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
    }