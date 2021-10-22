    package com.jogos.api.controller;

    import com.jogos.api.dto.GameDTO;
    import com.jogos.api.model.GameEntity;
    import com.jogos.api.repository.GameRepository;
    import com.jogos.api.service.GameService;
    import com.jogos.api.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import java.util.ArrayList;
    import java.util.List;

    @RestController
    public class GameController {

        @Autowired
        private GameService service;

        @Autowired
        private UserService userService;

        @Autowired
        private GameRepository repo;

        @GetMapping("/getGame")
        public List<GameDTO> getGame(){
            int retorno;
            List<GameDTO> vazio = new ArrayList<>();

            retorno = userService.loginConferer();

            if(retorno == 1){
                return vazio;
            }

            List<GameDTO> dtos= service.getGames();

            return dtos;
        }

        @PostMapping("/postGame")
        public String postGame(@RequestBody GameEntity game){ // exemplo de encapsulamento, método public

            int retorno;

            retorno = userService.loginConferer();

            if(retorno == 0){
                return "Esse usuário não tem permição para esse comando";
            }

            retorno = service.validation(game);

            if(retorno == 1){
                return "Não pode ter uma quantidade negativa de pessoas envolvidas";
            }else if(retorno == 2){
                return "Não pode ter número de cópias negativo";
            }else if(retorno == 3){
                return "A nota do jogo não pode ser negativa";
            }else if(retorno ==4){
                return "A nota do jogo não pode ser negativa";
            }else if(retorno ==5){
                return "A classificação indicativa não pode ser negativa e nem maior do que 21 anos";
            }else if(retorno ==6){
                return "O genero do jogo não pode estar vazio";
            }else if(retorno ==7){
                return "O jogo não pode ficar sem um developer";
            } else if (retorno ==8){
                return "O jogo não pode não ter um nome";
            }

            repo.save(game);

            return "Jogo adicionado com sucesso";

        }

        @DeleteMapping("/deleteGame/{id}")
        public String deleteGame(@PathVariable Long id){

            int retorno;

            retorno = userService.loginConferer();

            if(retorno == 0){
                return "Esse usuário não tem permição para esse comando";
            }

            if(!service.IdExists(id)){
                return "Jogo não encontrado";
            }

            repo.deleteById(id);

            return "Jogo deletado com sucesso";
        }

        @PutMapping("/updateGame/{id}")
        public String updateGame(@PathVariable Long id, @RequestBody GameEntity game){ //exemplo de encapsulamento

            int retorno;

            retorno = userService.loginConferer();

            if(retorno == 0){
                return "Esse usuário não tem permição para esse comando";
            }

            if(!service.IdExists(id)){
                return "Jogo não encontrado";
            }

            service.update(id, game);

            return "Os dados do jogo foram atualizados";
        }

        /*@DeleteMapping("/delete")
        public String deleteAll(){
            repo.deleteAll();

            return "Apagou";
        }*/

    }
