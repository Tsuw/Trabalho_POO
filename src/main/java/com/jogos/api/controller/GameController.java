package com.jogos.api.controller;

import com.jogos.api.dto.GamePC1DTO;
import com.jogos.api.dto.GamePCDTO;
import com.jogos.api.model.GameConsole1;
import com.jogos.api.model.GamePC;
import com.jogos.api.model.GamePC1;
import com.jogos.api.model.GameVR1;
import com.jogos.api.repository.GameConsole1Repository;
import com.jogos.api.repository.GamePC1Repository;
import com.jogos.api.repository.GamePCRepository;
import com.jogos.api.repository.GameVR1Repository;
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
    private GamePCRepository repo;

    @Autowired
    private GamePC1Repository repositoryPC;

    @Autowired
    private GameVR1Repository repositoryVR;

    @Autowired
    private GameConsole1Repository repositoryConsole;

    @GetMapping("/getGames/PC")
    public List<GamePC1DTO> getGamesPC(){

        int retorno;
        List<GamePC1DTO> vazio = new ArrayList<>();
        List<GamePC1DTO> ListGames = service.getGamesPC();

        retorno = userService.loginConferer();

        if(retorno == 1){
            return vazio;
        }

        return ListGames;
    }



    @PostMapping("/postGame/PC")
    public String postGamePC(@RequestBody GamePC1 game) {

        int retorno;

        retorno = userService.loginConferer();

        if (retorno == 0) {
            return "Esse usuário não tem permição para esse comando";
        }

        retorno = service.validationPC(game);

        if (retorno == 1) {
            return "Não pode ter uma quantidade negativa de pessoas envolvidas";
        } else if (retorno == 2) {
            return "Não pode ter número de cópias negativo";
        } else if (retorno == 3) {
            return "A nota do jogo não pode ser negativa";
        } else if (retorno == 4) {
            return "A nota do jogo não pode ser negativa";
        } else if (retorno == 5) {
            return "A classificação indicativa não pode ser negativa e nem maior do que 21 anos";
        } else if (retorno == 6) {
            return "O genero do jogo não pode estar vazio";
        } else if (retorno == 7) {
            return "O jogo não pode ficar sem um developer";
        } else if (retorno == 8) {
            return "O jogo não pode não ter um nome";
        }

        repositoryPC.save(game);

        return "Jogo adicionado com sucesso";

    }

    @PostMapping("/postGame/VR")
    public String postGameVR(@RequestBody GameVR1 game){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuario não tem permição para usar esse comando";
        }

        retorno = service.validationVR(game);

        if (retorno == 1) {
            return "Não pode ter uma quantidade negativa de pessoas envolvidas";
        } else if (retorno == 2) {
            return "Não pode ter número de cópias negativo";
        } else if (retorno == 3) {
            return "A nota do jogo não pode ser negativa";
        } else if (retorno == 4) {
            return "A nota do jogo não pode ser negativa";
        } else if (retorno == 5) {
            return "A classificação indicativa não pode ser negativa e nem maior do que 21 anos";
        } else if (retorno == 6) {
            return "O genero do jogo não pode estar vazio";
        } else if (retorno == 7) {
            return "O jogo não pode ficar sem um developer";
        } else if (retorno == 8) {
            return "O jogo não pode não ter um nome";
        }

        repositoryVR.save(game);

        return "Jogo adicionado com sucesso";
    }

    @PostMapping("/postGame/Console")
    public String postGameConsole(@RequestBody GameConsole1 game){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuario não tem permição para usar esse comando";
        }

        retorno = service.validationConsole(game);

        if (retorno == 1) {
            return "Não pode ter uma quantidade negativa de pessoas envolvidas";
        } else if (retorno == 2) {
            return "Não pode ter número de cópias negativo";
        } else if (retorno == 3) {
            return "A nota do jogo não pode ser negativa";
        } else if (retorno == 4) {
            return "A nota do jogo não pode ser negativa";
        } else if (retorno == 5) {
            return "A classificação indicativa não pode ser negativa e nem maior do que 21 anos";
        } else if (retorno == 6) {
            return "O genero do jogo não pode estar vazio";
        } else if (retorno == 7) {
            return "O jogo não pode ficar sem um developer";
        } else if (retorno == 8) {
            return "O jogo não pode não ter um nome";
        }

        repositoryConsole.save(game);

        return "Jogo adicionado com sucesso";
    }

    @DeleteMapping("/deleteGame/{id}")
    public String deleteGame(@PathVariable Long id) {

        int retorno;

        retorno = userService.loginConferer();

        if (retorno == 0) {
            return "Esse usuário não tem permição para esse comando";
        }

        if (!service.IdExists(id)) {
            return "Jogo não encontrado";
        }

        repo.deleteById(id);

        return "Jogo deletado com sucesso";
    }

    @PutMapping("/updateGame/PC/{id}")
    public String updateGamePC(@PathVariable Long id, @RequestBody GamePC1 game){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuário não tem permição para esse comando";
        }

        if(!service.IdPCExists(id)){
            return "Jogo não encontrado";
        }

        service.updateGamePC(id, game);

        return "Os dados do jogo foram atualizados";
    }

        /*@DeleteMapping("/delete")
        public String deleteAll(){
            repo.deleteAll();

            return "Apagou";
        }*/
}
