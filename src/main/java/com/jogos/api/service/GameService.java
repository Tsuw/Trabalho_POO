package com.jogos.api.service;

import com.jogos.api.dto.GamePCDTO;
import com.jogos.api.model.GamePC;
import com.jogos.api.model.GameVR;
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

    public List<GamePCDTO> getGames() {
        List<GamePCDTO> ListGames = new ArrayList<>();

        List<GamePC> games = repo.findAll();

        for (int i = 0; i < games.size(); i++) {
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

            ListGames.add(dto);
        }

        return ListGames;
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

    public int validationVR(GameVR Enti) { // exemplo de encapsulamento

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

    public Boolean IdExists(Long ID) {

        return repo.existsById(ID);

    }

    public void update(Long id, GamePC Entity) {

        Optional<GamePC> enty = repo.findById(id);

        if (enty.isPresent()) {

            GamePC enty_update = enty.get();

            enty_update.setName(Entity.getName());
            enty_update.setReleaseDate(Entity.getReleaseDate());
            enty_update.setDescription(Entity.getDescription());
            enty_update.setDeveloper(Entity.getDeveloper());
            enty_update.setPeopleInvolved(Entity.getPeopleInvolved());
            enty_update.setSoldCopies(Entity.getSoldCopies());
            enty_update.setDistributor(Entity.getDistributor());
            enty_update.setScore(Entity.getScore());
            enty_update.setPrice(Entity.getPrice());
            enty_update.setGenre(Entity.getGenre());
            enty_update.setRating(Entity.getRating());
            enty_update.setHasDLC(Entity.isHasDLC());

            repo.save(enty_update);
        }

    }

}