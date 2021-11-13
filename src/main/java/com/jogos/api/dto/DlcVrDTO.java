package com.jogos.api.dto;

import com.jogos.api.model.Dlc;

public class DlcVrDTO extends NeutralDDTO{

    private RequirementsDTO minimumRequirements;
    private RequirementsDTO recommendedRequirements;

    public DlcVrDTO(Dlc dlc) {

        this.name = dlc.getName();
        this.releaseDate = dlc.getReleaseDate();
        this.description = dlc.getDescription();
        this.developer = dlc.getDeveloper();
        this.distributor = dlc.getDistributor();
        this.score = dlc.getScore();
        this.price = dlc.getPrice();
        this.genre = dlc.getGenre();
        this.rating = dlc.getRating();
        this.platform = dlc.getPlatform();
        this.minimumRequirements = new RequirementsDTO(dlc.getMinimumRequirements());
        this.recommendedRequirements = new RequirementsDTO(dlc.getRecommendedRequirements());
    }

    public RequirementsDTO getMinimumRequirements() {
        return minimumRequirements;
    }

    public void setMinimumRequirements(RequirementsDTO minimumRequirements) {
        this.minimumRequirements = minimumRequirements;
    }

    public RequirementsDTO getRecommendedRequirements() {
        return recommendedRequirements;
    }

    public void setRecommendedRequirements(RequirementsDTO recommendedRequirements) {
        this.recommendedRequirements = recommendedRequirements;
    }
}
