package com.jogos.api.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GameVR")
public class GameVR extends NeutralGame {

    @OneToOne
    @JoinColumn(name = "minimumRequirements",  nullable = false, referencedColumnName = "id")
    private Requirements minimumRequirements;

    @OneToOne
    @JoinColumn(name = "recommendedRequirements",  nullable = false, referencedColumnName = "id")
    private Requirements recommendedRequirements;

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
}
