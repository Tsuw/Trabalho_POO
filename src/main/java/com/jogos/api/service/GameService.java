package com.jogos.api.service;

import com.jogos.api.dto.GameConsoleDTO;
import com.jogos.api.dto.GamePCDTO;
import com.jogos.api.dto.GameVRDTO;
import com.jogos.api.model.GameConsole;
import com.jogos.api.model.GamePC;
import com.jogos.api.model.GameVR;
import com.jogos.api.repository.GameConsoleRepository;
import com.jogos.api.repository.GamePCRepository;
import com.jogos.api.repository.GameVRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class GameService {

    @Autowired
    private GamePCRepository repositoryPC;

    @Autowired
    private GameVRRepository repositoryVR;

    @Autowired
    private GameConsoleRepository repositoryConsole;

    public List<GamePCDTO> getGamesPC(){
        List<GamePCDTO> listGames = new ArrayList<>();

        List<GamePC> games = repositoryPC.findAll();

        for(int i = 0; i < games.size();i++){

            GamePC tmp = games.get(i);

            GamePCDTO dto = new GamePCDTO();

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
            dto.setPlatform(tmp.getPlatform());

            listGames.add(dto);

        }

        return listGames;
    }

    public List<GameVRDTO> getGamesVR(){

        List<GameVRDTO> listGame = new ArrayList<>();
        List<GameVR> games = repositoryVR.findAll();

        for(int i = 0; i < games.size(); i++){

            GameVR tmp = games.get(i);
            GameVRDTO dto = new GameVRDTO();

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
            dto.setPlatform(tmp.getPlatform());
            dto.setMinimumRequirements(tmp.getMinimumRequirements());
            dto.setRecommendedRequirements(tmp.getRecommendedRequirements());

            listGame.add(dto);
        }

        return listGame;
    }

    public List<GameConsoleDTO> getGamesConsole(){
        List<GameConsoleDTO> listGames = new ArrayList<>();
        List<GameConsole> games = repositoryConsole.findAll();

        for(int i = 0; i < games.size(); i++){

            GameConsole tmp = games.get(i);
            GameConsoleDTO dto = new GameConsoleDTO();

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
            dto.setPlatform(tmp.getPlatform());
            dto.setStorage(tmp.getStorage());

            listGames.add(dto);
        }

        return listGames;
    }



    public int validationPC(GamePC Enty) {

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

    public int validationVR(GameVR Enti) {

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

    public int validationConsole(GameConsole gameConsole1) {

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

    public Boolean IdPCExists(Long id){

        return repositoryPC.existsById(id);
    }

    public Boolean IdVRExists(Long id){

        return repositoryVR.existsById(id);
    }

    public Boolean IdConsoleExists(Long id){

        return repositoryConsole.existsById(id);
    }

    public void updateGamePC(Long id, GamePC entity){

        Optional<GamePC> enty = repositoryPC.findById(id);

        if(enty.isPresent()){

            GamePC entyUpdate = enty.get();

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

    public void updateGameVR(Long id, GameVR entity){

        Optional<GameVR> enty = repositoryVR.findById(id);

        if(enty.isPresent()){

            GameVR entyUpdate = enty.get();

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

            repositoryVR.save(entyUpdate);
        }

    }

    public void updateGameConsole(Long id, GameConsole entity){

        Optional<GameConsole> enty = repositoryConsole.findById(id);

        if(enty.isPresent()){

            GameConsole entyUpdate = enty.get();

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
            entyUpdate.setStorage(entity.getStorage());

            repositoryConsole.save(entyUpdate);
        }
    }

}