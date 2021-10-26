package com.jogos.api.model;

import javax.persistence.*;

@Entity
@Table(name = "DLCVR")
public class DLCVR extends NeutralDLC{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "minimumRequirements",  nullable = false, referencedColumnName = "id")
    private Requirements minimumRequirements;

    @OneToOne(cascade = CascadeType.ALL)
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
