package com.jogos.api.service;

import com.jogos.api.model.Dlc;
import com.jogos.api.model.DlcBuilder;
import com.jogos.api.model.Game;
import com.jogos.api.repository.DLCRepository;
import com.jogos.api.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DLCService {

    private final DLCRepository dlcRepository;

    private final GameRepository gameRepository;

    public DLCService(DLCRepository dlcRepository, GameRepository gameRepository) {
        this.dlcRepository = dlcRepository;
        this.gameRepository = gameRepository;
    }

    public String post(Dlc dlc){

        String erro = validation(dlc);

        DlcBuilder builder = new DlcBuilder();

        Optional<Game> game = gameRepository.findGameByNameAndPlatform(dlc.getOwnedGame(), dlc.getPlatform());

        if(dlc.getPlatform().equals("PC") || dlc.getPlatform().equals("pc")) {

            Dlc dlcPC = builder.withName(dlc.getName())
                    .withReleaseDate(dlc.getReleaseDate())
                    .withDescription(dlc.getDescription())
                    .withDeveloper(dlc.getDeveloper())
                    .withDistributor(dlc.getDistributor())
                    .withScore(dlc.getScore())
                    .withPrice(dlc.getPrice())
                    .withRating(dlc.getRating())
                    .withPlatform(dlc.getPlatform())
                    .withOwnedGame(dlc.getOwnedGame())
                    .withMinimumRequirements(dlc.getMinimumRequirements())
                    .withRecommendedRequirements(dlc.getRecommendedRequirements())
                    .withPeopleInvolved(dlc.getPeopleInvolved())
                    .withSoldCopies(dlc.getSoldCopies())
                    .build();

            if(erro == null){

                if(game.isPresent()){

                    Game entGame = game.get();

                    entGame.getDlc().add(dlc);

                    dlcRepository.save(dlc);

                    return "DLC adicionada com sucesso";
                }else{
                    return "Jogo não encontrado";
                }

            }else{
                return erro;
            }

        }else if(dlc.getPlatform().equals("VR") || dlc.getPlatform().equals("vr")){

            Dlc dlcVR = builder.withName(dlc.getName())
                    .withReleaseDate(dlc.getReleaseDate())
                    .withDescription(dlc.getDescription())
                    .withDeveloper(dlc.getDeveloper())
                    .withDistributor(dlc.getDistributor())
                    .withScore(dlc.getScore())
                    .withPrice(dlc.getPrice())
                    .withRating(dlc.getRating())
                    .withPlatform(dlc.getPlatform())
                    .withOwnedGame(dlc.getOwnedGame())
                    .withMinimumRequirements(dlc.getMinimumRequirements())
                    .withRecommendedRequirements(dlc.getRecommendedRequirements())
                    .withPeopleInvolved(dlc.getPeopleInvolved())
                    .withSoldCopies(dlc.getSoldCopies())
                    .build();

            if(erro == null){

                if(game.isPresent()){

                    Game entGame = game.get();

                    entGame.getDlc().add(dlc);

                    dlcRepository.save(dlc);

                    return "DLC adicionada com sucesso";
                }else{
                    return "Jogo não encontrado";
                }

            }else{
                return erro;
            }

        }else{

            Dlc dlcConsole = builder.withName(dlc.getName())
                    .withReleaseDate(dlc.getReleaseDate())
                    .withDescription(dlc.getDescription())
                    .withDeveloper(dlc.getDeveloper())
                    .withDistributor(dlc.getDistributor())
                    .withScore(dlc.getScore())
                    .withPrice(dlc.getPrice())
                    .withRating(dlc.getRating())
                    .withPlatform(dlc.getPlatform())
                    .withPeopleInvolved(dlc.getPeopleInvolved())
                    .withSoldCopies(dlc.getSoldCopies())
                    .withOwnedGame(dlc.getOwnedGame())
                    .withStorage(dlc.getStorage())
                    .build();

            if(erro == null){

                if(game.isPresent()){

                    Game entGame = game.get();

                    entGame.getDlc().add(dlc);

                    dlcRepository.save(dlc);

                    return "DLC adicionada com sucesso";
                }else{
                    return "Jogo não encontrado";
                }

            }else{
                return erro;
            }
        }
    }

    private String validation(Dlc dlc){

        Date d = new Date();

        if(dlc.getOwnedGame() == null || dlc.getOwnedGame().isEmpty()){
            return "A DLC necessita do jogo de origem";
        }

        if(dlc.getName() == null || dlc.getName().isEmpty()){
            return "A DLC necessita de um nome";
        }

        if(dlc.getReleaseDate() == null || d.compareTo(dlc.getReleaseDate()) < 0){
            return "Data invalida";
        }

        if(dlc.getDescription() == null || dlc.getDescription().isEmpty()){
            return "A DLC necessita de uma descrição";
        }

        if(dlc.getDeveloper() == null || dlc.getDeveloper().isEmpty()){
            return "A DLC necessita de um desenvolvedor";
        }

        if(dlc.getPeopleInvolved() < 0){
            return "Número de pessoas invalido";
        }

        if(dlc.getSoldCopies() < 0){
            return "Número de copias invalido";
        }

        if(dlc.getDistributor() == null || dlc.getDistributor().isEmpty()){
            return "A DLC necessita de um Distribuidor";
        }

        if(dlc.getScore() < 0 || dlc.getScore() > 100){
            return "Nota invalida";
        }

        if(dlc.getPrice() < 0){
            return "Preço invalido";
        }

        if(dlc.getGenre() == null || dlc.getGenre().isEmpty()){
            return "A DLC necessita de um gênero";
        }

        if(dlc.getRating() > 21 || dlc.getRating() < 0){
            return "Faixa etária invalida";
        }

        if(dlc.getPlatform() == null || dlc.getPlatform().isEmpty()){
            return "A DLC necessita de uma plataforma";
        }

        if(dlc.getPlatform().equals("VR") || dlc.getPlatform().equals("vr") ||
                dlc.getPlatform().equals("PC") || dlc.getPlatform().equals("pc")){

            if(dlc.getMinimumRequirements() == null){
                return "A DLC necessita de requisitos minimos";
            }

            if(dlc.getRecommendedRequirements() == null){
                return "A DLC necessita de requisitos recomendados";
            }

        }else{

            if(dlc.getStorage() == null || dlc.getStorage().isEmpty()){
                return "A DLC precisa de um valor de armazenamento";
            }

        }

        return null;
    }

    public String update(Dlc dlc, Long id){

        Optional<Dlc> enty = dlcRepository.findById(id);
        String erro = validation(dlc);

        if(erro != null){
            return erro;
        }

        if(enty.isPresent()){

            Dlc entyUpdate = enty.get();

            entyUpdate.setName(dlc.getName());
            entyUpdate.setReleaseDate(dlc.getReleaseDate());
            entyUpdate.setDescription(dlc.getDescription());
            entyUpdate.setDeveloper(dlc.getDeveloper());
            entyUpdate.setPeopleInvolved(dlc.getPeopleInvolved());
            entyUpdate.setSoldCopies(dlc.getSoldCopies());
            entyUpdate.setDistributor(dlc.getDistributor());
            entyUpdate.setScore(dlc.getScore());
            entyUpdate.setPrice(dlc.getPrice());
            entyUpdate.setGenre(dlc.getGenre());
            entyUpdate.setRating(dlc.getRating());
            entyUpdate.setPlatform(dlc.getPlatform());
            entyUpdate.setMinimumRequirements(dlc.getMinimumRequirements());
            entyUpdate.setRecommendedRequirements(dlc.getRecommendedRequirements());
            entyUpdate.setStorage(dlc.getStorage());

            dlcRepository.save(entyUpdate);

            return "Os dados foram atualizados com sucesso";
        }else{
            return "DLC não existente";
        }
    }

    public String delete(Long id){

        if(dlcRepository.existsById(id)){

            dlcRepository.deleteById(id);

            return "DLC deletada com sucesso";
        }else{
            return "DLC não existente";
        }
    }

}
