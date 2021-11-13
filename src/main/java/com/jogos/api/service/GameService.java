package com.jogos.api.service;

import com.jogos.api.dto.*;
import com.jogos.api.model.Game;
import com.jogos.api.model.GameBuilder;
import com.jogos.api.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public String post(Game game){

        String erro = validation(game);

        GameBuilder builder = new GameBuilder();

        if(game.getPlatform().equals("PC") || game.getPlatform().equals("pc")){

            Game gamePC = builder.withName(game.getName())
                    .withReleaseDate(game.getReleaseDate())
                    .withDescription(game.getDescription())
                    .withDeveloper(game.getDeveloper())
                    .withDistributor(game.getDistributor())
                    .withScore(game.getScore())
                    .withPrice(game.getPrice())
                    .withGenre(game.getGenre())
                    .withRating(game.getRating())
                    .withHasDLC(game.isHasDLC())
                    .withPlatform(game.getPlatform())
                    .withMinimumRequirements(game.getMinimumRequirements())
                    .withRecommendedRequirements(game.getRecommendedRequirements())
                    .withPeopleInvolved(game.getPeopleInvolved())
                    .withSoldCopies(game.getSoldCopies())
                    .withDlc(game.getDlc())
                    .build();

            if(erro == null){
                repository.save(gamePC);
                return "Jogo adicionado com sucesso";
            }else{
                return erro;
            }


        }else if(game.getPlatform().equals("VR") || game.getPlatform().equals("vr")){

            Game gameVR = builder.withName(game.getName())
                    .withReleaseDate(game.getReleaseDate())
                    .withDescription(game.getDescription())
                    .withDeveloper(game.getDeveloper())
                    .withDistributor(game.getDistributor())
                    .withScore(game.getScore())
                    .withPrice(game.getPrice())
                    .withGenre(game.getGenre())
                    .withRating(game.getRating())
                    .withHasDLC(game.isHasDLC())
                    .withPlatform(game.getPlatform())
                    .withPeopleInvolved(game.getPeopleInvolved())
                    .withSoldCopies(game.getSoldCopies())
                    .withMinimumRequirements(game.getMinimumRequirements())
                    .withRecommendedRequirements(game.getRecommendedRequirements())
                    .withDlc(game.getDlc())
                    .build();

            if(erro == null){
                repository.save(gameVR);
                return "Jogo adicionado com sucesso";
            }else{
                return erro;
            }

        }else{

            Game gameConsole = builder.withName(game.getName())
                    .withReleaseDate(game.getReleaseDate())
                    .withDescription(game.getDescription())
                    .withDeveloper(game.getDeveloper())
                    .withDistributor(game.getDistributor())
                    .withScore(game.getScore())
                    .withPrice(game.getPrice())
                    .withGenre(game.getGenre())
                    .withRating(game.getRating())
                    .withHasDLC(game.isHasDLC())
                    .withPlatform(game.getPlatform())
                    .withPeopleInvolved(game.getPeopleInvolved())
                    .withSoldCopies(game.getSoldCopies())
                    .withStorage(game.getStorage())
                    .withDlc(game.getDlc())
                    .build();

            if(erro == null){
                repository.save(gameConsole);
                return "Jogo adicionado com sucesso";
            }else{
                return erro;
            }
        }
    }

    private String validation(Game game){

        Date d = new Date();

        if(game.getName() == null || game.getName().isEmpty()){
            return "O jogo necessita de um nome";
        }

        if(game.getReleaseDate() == null || d.compareTo(game.getReleaseDate()) < 0){
            return "Data invalida";
        }

        if(game.getDescription() == null || game.getDescription().isEmpty()){
            return "O jogo necessita de uma descrição";
        }

        if(game.getDeveloper() == null || game.getDeveloper().isEmpty()){
            return "O jogo necessita de um desenvolvedor";
        }

        if(game.getPeopleInvolved() < 0){
            return "Número de pessoas invalido";
        }

        if(game.getSoldCopies() < 0){
            return "Número de copias invalido";
        }

        if(game.getDistributor() == null || game.getDistributor().isEmpty()){
            return "O jogo necessita de um Distribuidor";
        }

        if(game.getScore() < 0 || game.getScore() > 100){
            return "Nota invalida";
        }

        if(game.getPrice() < 0){
            return "Preço invalido";
        }

        if(game.getGenre() == null || game.getGenre().isEmpty()){
            return "O jogo necessita de um gênero";
        }

        if(game.getRating() > 21 || game.getRating() < 0){
            return "Faixa etária invalida";
        }

        if(game.getPlatform() == null || game.getPlatform().isEmpty()){
            return "O jogo necessita de uma plataforma";
        }

        if(game.getPlatform().equals("VR") || game.getPlatform().equals("vr") ||
                game.getPlatform().equals("PC") || game.getPlatform().equals("pc")){

            if(game.getMinimumRequirements() == null){
                return "O jogo necessita de requisitos minimos";
            }

            if(game.getRecommendedRequirements() == null){
                return "O jogo necessita de requisitos recomendados";
            }

        }else{

            if(game.getStorage() == null || game.getStorage().isEmpty()){
                return "O jogo precisa de um valor de armazenamento";
            }

        }

        return null;
    }

    public String update(Game game, Long id){

        Optional<Game> enty = repository.findById(id);
        String erro = validation(game);

        if(erro != null){
            return erro;
        }

        if(enty.isPresent()){

            Game entyUpdate = enty.get();

            entyUpdate.setName(game.getName());
            entyUpdate.setReleaseDate(game.getReleaseDate());
            entyUpdate.setDescription(game.getDescription());
            entyUpdate.setDeveloper(game.getDeveloper());
            entyUpdate.setPeopleInvolved(game.getPeopleInvolved());
            entyUpdate.setSoldCopies(game.getSoldCopies());
            entyUpdate.setDistributor(game.getDistributor());
            entyUpdate.setScore(game.getScore());
            entyUpdate.setPrice(game.getPrice());
            entyUpdate.setGenre(game.getGenre());
            entyUpdate.setRating(game.getRating());
            entyUpdate.setHasDLC(game.isHasDLC());
            entyUpdate.setPlatform(game.getPlatform());
            entyUpdate.setMinimumRequirements(game.getMinimumRequirements());
            entyUpdate.setRecommendedRequirements(game.getRecommendedRequirements());
            entyUpdate.setStorage(game.getStorage());

            repository.save(entyUpdate);

            return "Os dados foram atualizados com sucesso";
        }else{
            return "Jogo não existente";
        }
    }

    public String delete(Long id){

        if(repository.existsById(id)){

            repository.deleteById(id);

            return "Jogo deletado com sucesso";
        }else{
            return "Jogo não existente";
        }
    }

    public List<GamePCDTO> getGamePC(){

        List<GamePCDTO> listGames = new ArrayList<>();

        List<Game> games = repository.findAllByPlatform("PC");

        for (Game game : games) {

            GamePCDTO dto = new GamePCDTO(game);

            for(int i = 0; i < game.getDlc().size(); i++){

                DlcPcDTO dto1 = new DlcPcDTO(game.getDlc().get(i));

                dto.getDlc().add(dto1);

            }

            listGames.add(dto);
        }

        return listGames;
    }

    public List<GameVRDTO> getGameVR(){

        List<GameVRDTO> listGames = new ArrayList<>();

        List<Game> games = repository.findAllByPlatform("VR");

        for(Game game : games){

            GameVRDTO dto = new GameVRDTO(game);

            for(int i = 0; i < games.size(); i++){

                DlcVrDTO dto1 = new DlcVrDTO(game.getDlc().get(i));

                dto.getDlc().add(dto1);
            }

            listGames.add(dto);
        }

        return listGames;
    }

    public List<GameConsoleDTO> getGameConsole(){

        List<GameConsoleDTO> listGames = new ArrayList<>();

        List<Game> games = repository.findAllByConsole();

        for(Game game : games){

            GameConsoleDTO dto = new GameConsoleDTO(game);

            for(int i = 0; i < games.size(); i++){

                DlcConsoleDTO dto1 = new DlcConsoleDTO(game.getDlc().get(i));

                dto.getDlc().add(dto1);
            }

            listGames.add(dto);
        }

        return listGames;
    }

}