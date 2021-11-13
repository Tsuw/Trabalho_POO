package com.jogos.api.dto;

import com.jogos.api.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GamePCDTO extends NeutralGDTO{

    private List<DlcPcDTO> dlc = new ArrayList<>();
    private RequirementsDTO minimumRequirements;
    private RequirementsDTO recommendedRequirements;

    public GamePCDTO(Game game) {

        this.name = game.getName();
        this.releaseDate = game.getReleaseDate();
        this.description = game.getDescription();
        this.developer = game.getDeveloper();
        this.distributor = game.getDistributor();
        this.score = game.getScore();
        this.price = game.getPrice();
        this.genre = game.getGenre();
        this.rating = game.getRating();
        this.hasDLC = game.isHasDLC();
        this.platform = game.getPlatform();
        this.minimumRequirements = new RequirementsDTO(game.getMinimumRequirements());
        this.recommendedRequirements = new RequirementsDTO(game.getRecommendedRequirements());
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

    public List<DlcPcDTO> getDlc() {
        return dlc;
    }

    public void setDlc(List<DlcPcDTO> dlc) {
        this.dlc = dlc;
    }
}
