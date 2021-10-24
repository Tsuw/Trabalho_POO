package com.jogos.api.service;

import com.jogos.api.model.GamePC;
import com.jogos.api.model.GameVR;
import com.jogos.api.model.NeutralGame;
import com.jogos.api.repository.GamePCRepository;
import com.jogos.api.repository.GameVRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class Separador {

    @Autowired
    private GameService service;

    @Autowired
    private GamePCRepository repositoryPC;

    @Autowired
    private GameVRRepository repositoryVR;

    public int postSeparator(NeutralGame game){

        int retorno;

        if(game.getPlatform().equals("PC") || game.getPlatform().equals("pc")){

            GamePC gamePC = GamePCConversor(game);

            retorno = service.validationPC(gamePC);

            if(retorno == 0){
                repositoryPC.save(gamePC);
            }else{
                return retorno;
            }

        }else if(game.getPlatform().equals("VR") || game.getPlatform().equals("vr")){

            GameVR gameVR = GameVRConversor(game);

            retorno = service.validationVR(gameVR);

            if(retorno == 0){
                repositoryVR.save(gameVR);
            }else{
                return retorno;
            }

        }

        return 0;
    }

    private GamePC GamePCConversor(NeutralGame game){

        GamePC Enty = new GamePC();

        Enty.setName(game.getName());
        Enty.setReleaseDate(game.getReleaseDate());
        Enty.setDescription(game.getDescription());
        Enty.setDeveloper(game.getDeveloper());
        Enty.setPeopleInvolved(game.getPeopleInvolved());
        Enty.setSoldCopies(game.getSoldCopies());
        Enty.setDistributor(game.getDistributor());
        Enty.setScore(game.getScore());
        Enty.setPrice(game.getPrice());
        Enty.setGenre(game.getGenre());
        Enty.setRating(game.getRating());
        Enty.setHasDLC(game.isHasDLC());
        Enty.setPlatform(game.getPlatform());
        Enty.setMinimumRequirements(game.getMinimumRequirements());
        Enty.setRecommendedRequirements(game.getRecommendedRequirements());

        return Enty;

    }

    private GameVR GameVRConversor(NeutralGame game){

        GameVR enti = new GameVR();

        enti.setName(game.getName());
        enti.setReleaseDate(game.getReleaseDate());
        enti.setDescription(game.getDescription());
        enti.setDeveloper(game.getDeveloper());
        enti.setPeopleInvolved(game.getPeopleInvolved());
        enti.setSoldCopies(game.getSoldCopies());
        enti.setDistributor(game.getDistributor());
        enti.setScore(game.getScore());
        enti.setPrice(game.getPrice());
        enti.setGenre(game.getGenre());
        enti.setRating(game.getRating());
        enti.setHasDLC(game.isHasDLC());
        enti.setPlatform(game.getPlatform());
        enti.setMinimumRequirements(game.getMinimumRequirements());
        enti.setRecommendedRequirements(game.getRecommendedRequirements());

        return enti;
    }

}
