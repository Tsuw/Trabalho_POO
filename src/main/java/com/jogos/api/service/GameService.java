package com.jogos.api.service;

import com.jogos.api.dto.GameConsoleDTO;
import com.jogos.api.dto.GamePCDTO;
import com.jogos.api.dto.GameVRDTO;
import com.jogos.api.dto.RequirementsDTO;
import com.jogos.api.model.GameConsole;
import com.jogos.api.model.GamePC;
import com.jogos.api.model.GameVR;
import com.jogos.api.repository.GameConsoleRepository;
import com.jogos.api.repository.GamePCRepository;
import com.jogos.api.repository.GameVRRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class GameService {

    private final GamePCRepository repositoryPC;

    private final GameVRRepository repositoryVR;

    private final GameConsoleRepository repositoryConsole;

    private final Date d = new Date();

    public GameService(GamePCRepository repositoryPC, GameVRRepository repositoryVR, GameConsoleRepository repositoryConsole) {
        this.repositoryPC = repositoryPC;
        this.repositoryVR = repositoryVR;
        this.repositoryConsole = repositoryConsole;
    }

    public List<GamePCDTO> getGamesPC(){

        List<GamePCDTO> listGames = new ArrayList<>();

        List<GamePC> games = repositoryPC.findAll();

        for (GamePC tmp : games) {

            GamePCDTO dto = new GamePCDTO(tmp);
            dto.setMinimumRequirements(new RequirementsDTO(tmp.getMinimumRequirements()));
            dto.setRecommendedRequirements(new RequirementsDTO(tmp.getRecommendedRequirements()));

            listGames.add(dto);
        }
        return listGames;
    }

    public List<GameVRDTO> getGamesVR(){

        List<GameVRDTO> listGame = new ArrayList<>();
        List<GameVR> games = repositoryVR.findAll();

        for (GameVR tmp : games) {

            GameVRDTO dto = new GameVRDTO(tmp);
            dto.setMinimumRequirements(new RequirementsDTO(tmp.getMinimumRequirements()));
            dto.setRecommendedRequirements(new RequirementsDTO(tmp.getRecommendedRequirements()));

            listGame.add(dto);
        }

        return listGame;
    }

    public List<GameConsoleDTO> getGamesConsole(){

        List<GameConsoleDTO> listGames = new ArrayList<>();
        List<GameConsole> games = repositoryConsole.findAll();

        for (GameConsole tmp : games) {

            GameConsoleDTO dto = new GameConsoleDTO(tmp);
            dto.setStorage(tmp.getStorage());

            listGames.add(dto);
        }

        return listGames;
    }

    public String validationPC(GamePC gamePC){

        return validationPCSecret(gamePC);
    }

    private String validationPCSecret (GamePC gamePC){

        if(gamePC.getName() == null || gamePC.getName().isEmpty()){
            return "O jogo necessita de um nome";
        }

        if(gamePC.getReleaseDate() == null || this.d.compareTo(gamePC.getReleaseDate()) < 0){
            return "Data invalida";
        }

        if(gamePC.getDescription() == null || gamePC.getDescription().isEmpty()){
            return "O jogo necessita de uma descrição";
        }

        if(gamePC.getDeveloper() == null || gamePC.getDeveloper().isEmpty()){
            return "O jogo necessita de um desenvolvedor";
        }

        if(gamePC.getPeopleInvolved() < 0){
            return "Número de pessoas invalido";
        }

        if(gamePC.getSoldCopies() < 0){
            return "Número de copias invalido";
        }

        if(gamePC.getDistributor() == null || gamePC.getDistributor().isEmpty()){
            return "O jogo necessita de um Distribuidor";
        }

        if(gamePC.getScore() < 0 || gamePC.getScore() > 100){
            return "Nota invalida";
        }

        if(gamePC.getPrice() < 0){
            return "Preço invalido";
        }

        if(gamePC.getGenre() == null || gamePC.getGenre().isEmpty()){
            return "O jogo necessita de um gênero";
        }

        if(gamePC.getRating() > 21 || gamePC.getRating() < 0){
            return "Faixa etária invalida";
        }

        if(gamePC.getMinimumRequirements() == null){
            return "O jogo necessita de requisitos minimos";
        }

        if(gamePC.getRecommendedRequirements() == null){
            return "O jogo necessita de requisitos recomendados";
        }

        return null;
    }

    public String validationVR(GameVR gameVR){

        return validationVRSecret(gameVR);
    }

    private String validationVRSecret(GameVR gameVR){

        if(gameVR.getName() == null || gameVR.getName().isEmpty()){
            return "O jogo necessita de um nome";
        }

        if(gameVR.getReleaseDate() == null || this.d.compareTo(gameVR.getReleaseDate()) < 0){
            return "Data invalida";
        }

        if(gameVR.getDescription() == null || gameVR.getDescription().isEmpty()){
            return "O jogo necessita de uma descrição";
        }

        if(gameVR.getDeveloper() == null || gameVR.getDeveloper().isEmpty()){
            return "O jogo necessita de um desenvolvedor";
        }

        if(gameVR.getPeopleInvolved() < 0){
            return "Número de pessoas invalido";
        }

        if(gameVR.getSoldCopies() < 0){
            return "Número de copias invalido";
        }

        if(gameVR.getDistributor() == null || gameVR.getDistributor().isEmpty()){
            return "O jogo necessita de um Distribuidor";
        }

        if(gameVR.getScore() < 0 || gameVR.getScore() > 100){
            return "Nota invalida";
        }

        if(gameVR.getPrice() < 0){
            return "Preço invalido";
        }

        if(gameVR.getGenre() == null || gameVR.getGenre().isEmpty()){
            return "O jogo necessita de um gênero";
        }

        if(gameVR.getRating() > 21 || gameVR.getRating() < 0){
            return "Faixa etária invalida";
        }

        if(gameVR.getMinimumRequirements() == null){
            return "O jogo necessita de requisitos minimos";
        }

        if(gameVR.getRecommendedRequirements() == null){
            return "O jogo necessita de requisitos recomendados";
        }

        return null;

    }
    public String validationConsole(GameConsole gameConsole){

        return validationConsoleSecret(gameConsole);
    }

    private String validationConsoleSecret(GameConsole gameConsole){

        if(gameConsole.getName() == null || gameConsole.getName().isEmpty()){
            return "O jogo necessita de um nome";
        }

        if(gameConsole.getReleaseDate() == null || this.d.compareTo(gameConsole.getReleaseDate()) < 0){
            return "Data invalida";
        }

        if(gameConsole.getDescription() == null || gameConsole.getDescription().isEmpty()){
            return "O jogo necessita de uma descrição";
        }

        if(gameConsole.getDeveloper() == null || gameConsole.getDeveloper().isEmpty()){
            return "O jogo necessita de um desenvolvedor";
        }

        if(gameConsole.getPeopleInvolved() < 0){
            return "Número de pessoas invalido";
        }

        if(gameConsole.getSoldCopies() < 0){
            return "Número de copias invalido";
        }

        if(gameConsole.getDistributor() == null || gameConsole.getDistributor().isEmpty()){
            return "O jogo necessita de um Distribuidor";
        }

        if(gameConsole.getScore() < 0 || gameConsole.getScore() > 100){
            return "Nota invalida";
        }

        if(gameConsole.getPrice() < 0){
            return "Preço invalido";
        }

        if(gameConsole.getGenre() == null || gameConsole.getGenre().isEmpty()){
            return "O jogo necessita de um gênero";
        }

        if(gameConsole.getRating() > 21 || gameConsole.getRating() < 0){
            return "Faixa etária invalida";
        }

        if(gameConsole.getStorage() == null || gameConsole.getStorage().isEmpty()){
            return "O jogo precisa de um valor de armazenamento";
        }

        return null;
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
            entyUpdate.setHasDLC(entity.isHasDLC());
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
            entyUpdate.setPrice(entity.getPrice());
            entyUpdate.setGenre(entity.getGenre());
            entyUpdate.setRating(entity.getRating());
            entyUpdate.setHasDLC(entity.isHasDLC());
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
            entyUpdate.setPrice(entity.getPrice());
            entyUpdate.setGenre(entity.getGenre());
            entyUpdate.setRating(entity.getRating());
            entyUpdate.setHasDLC(entity.isHasDLC());
            entyUpdate.setPlatform(entity.getPlatform());
            entyUpdate.setStorage(entity.getStorage());

            repositoryConsole.save(entyUpdate);
        }
    }
}