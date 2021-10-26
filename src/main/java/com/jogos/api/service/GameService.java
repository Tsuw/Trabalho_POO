package com.jogos.api.service;

import com.jogos.api.dto.GamePC1DTO;
import com.jogos.api.dto.GamePCDTO;
import com.jogos.api.model.GameConsole1;
import com.jogos.api.model.GamePC;
import com.jogos.api.model.GamePC1;
import com.jogos.api.model.GameVR1;
import com.jogos.api.repository.GamePC1Repository;
import com.jogos.api.repository.GamePCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class GameService {

    @Autowired
    private GamePCRepository repo;

    @Autowired
    private GamePC1Repository repositoryPC;

    public List<GamePC1DTO> getGamesPC(){
        List<GamePC1DTO> ListGames = new ArrayList<>();

        List<GamePC1> games = repositoryPC.findAll();

        for(int i = 0; i < games.size();i++){

            GamePC1 tmp = games.get(i);

            GamePC1DTO dto = new GamePC1DTO();

            dto.setId(tmp.getId());
            dto.setName(tmp.getName());
            dto.setReleaseDate(tmp.getReleaseDate());
            dto.setDescription(tmp.getDescription());
            dto.setDeveloper(tmp.getDeveloper());
            dto.setDistributor(tmp.getDistributor());
            dto.setScore(tmp.getScore());
            dto.setPrice(tmp.getPrice());
            dto.setGenre(tmp.getGenre());
            dto.setRating(tmp.getRating());
            dto.setHasDLC(tmp.isHasDLC());
            dto.setMinimumRequirements(tmp.getMinimumRequirements());
            dto.setRecommendedRequirements(tmp.getRecommendedRequirements());

            ListGames.add(dto);

        }

        return ListGames;
    }

    public int validationPC(GamePC1 Enty) {

        if (Enty.getPeopleInvolved() < 1) {
            return 1;
        }

        if (Enty.getSoldCopies() < 0) {
            return 2;
        }

        if (Enty.getScore() < 0 || Enty.getScore() > 100) {
            return 3;
        }

        if (Enty.getPrice() <= 0) {
            return 4;
        }

        if (Enty.getRating() < 0 && Enty.getRating() > 21) {//
            return 5;
        }

        if (Enty.getGenre().isEmpty()) {
            return 6;
        }

        if (Enty.getDeveloper().isEmpty()) {
            return 7;
        }

        if (Enty.getName().isEmpty()) {
            return 8;
        }

        return 0;
    }

    public int validationVR(GameVR1 Enti) { // exemplo de encapsulamento

        if (Enti.getPeopleInvolved() < 1) {
            return 1;
        }

        if (Enti.getSoldCopies() < 0) {
            return 2;
        }

        if (Enti.getScore() < 0 || Enti.getScore() > 100) {
            return 3;
        }

        if (Enti.getPrice() <= 0) {
            return 4;
        }

        if (Enti.getRating() < 0 && Enti.getRating() > 21) {//
            return 5;
        }

        if (Enti.getGenre().isEmpty()) {
            return 6;
        }

        if (Enti.getDeveloper().isEmpty()) {
            return 7;
        }

        if (Enti.getName().isEmpty()) {
            return 8;
        }

        return 0;
    }

    public int validationConsole(GameConsole1 gameConsole1) { // exemplo de encapsulamento

        if (gameConsole1.getPeopleInvolved() < 1) {
            return 1;
        }

        if (gameConsole1.getSoldCopies() < 0) {
            return 2;
        }

        if (gameConsole1.getScore() < 0 || gameConsole1.getScore() > 100) {
            return 3;
        }

        if (gameConsole1.getPrice() <= 0) {
            return 4;
        }

        if (gameConsole1.getRating() < 0 && gameConsole1.getRating() > 21) {//
            return 5;
        }

        if (gameConsole1.getGenre().isEmpty()) {
            return 6;
        }

        if (gameConsole1.getDeveloper().isEmpty()) {
            return 7;
        }

        if (gameConsole1.getName().isEmpty()) {
            return 8;
        }

        return 0;
    }

    public Boolean IdExists(Long ID) {

        return repo.existsById(ID);

    }

    public Boolean IdPCExists(Long ID){

        return repositoryPC.existsById(ID);
    }

    public void updateGamePC(Long id, GamePC1 entity){

        Optional<GamePC1> enty = repositoryPC.findById(id);

        if(enty.isPresent()){

            GamePC1 entyUpdate = enty.get();

            entyUpdate.setName(entity.getName());
            entyUpdate.setReleaseDate(entity.getReleaseDate());
            entyUpdate.setDescription(entity.getDescription());
            entyUpdate.setDeveloper(entity.getDeveloper());
            entyUpdate.setPeopleInvolved(entity.getPeopleInvolved());
            entyUpdate.setSoldCopies(entity.getSoldCopies());
            entyUpdate.setDistributor(entity.getDistributor());
            entyUpdate.setScore(entity.getScore());
            entyUpdate.setPrice(entyUpdate.getPrice());
            entyUpdate.setGenre(entity.getGenre());
            entyUpdate.setRating(entity.getRating());
            entyUpdate.setHasDLC(entyUpdate.isHasDLC());
            entyUpdate.setPlatform(entity.getPlatform());
            entyUpdate.setMinimumRequirements(entity.getMinimumRequirements());
            entyUpdate.setRecommendedRequirements(entity.getRecommendedRequirements());

            repositoryPC.save(entyUpdate);
        }

    }

}