    package com.jogos.api.service;

    import com.jogos.api.dto.GameDTO;
    import com.jogos.api.model.GameEntity;
    import com.jogos.api.repository.GameRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    @Service

    public class GameService{

        @Autowired
        private GameRepository repo;

        public List<GameDTO> getGames() {
            List<GameDTO> ListGames = new ArrayList<>();

            List<GameEntity> games = repo.findAll();

            for(int i = 0; i < games.size();i++){
                GameEntity tmp = games.get(i);

                GameDTO dto = new GameDTO();
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

        public int validation(GameEntity Enty){ // exemplo de encapsulamento

            if(Enty.getPeopleInvolved() < 1){
                return 1;
            }

            if(Enty.getSoldCopies() < 0){
                return 2;
            }

            if(Enty.getScore() < 0 || Enty.getScore() > 100){
                return 3;
            }

            if(Enty.getPrice() <= 0){
                return 4;
            }

            if(Enty.getRating()<0 && Enty.getRating()>21){//
                return 5;
            }

            if(Enty.getGenre().isEmpty()){
                return 6;
            }

            if(Enty.getDeveloper().isEmpty()){
                return 7;
            }

            if(Enty.getName().isEmpty()){
                return 8;
            }

            return 0;
        }

        public Boolean IdExists(Long ID){

            return repo.existsById(ID);

        }

        public void update(Long id, GameEntity Entity){

            Optional<GameEntity> enty = repo.findById(id);

            if(enty.isPresent()){

                GameEntity enty_update = enty.get();

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
