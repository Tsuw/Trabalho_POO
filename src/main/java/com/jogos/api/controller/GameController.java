package com.jogos.api.controller;

import com.jogos.api.dto.GameConsoleDTO;
import com.jogos.api.dto.GamePC1DTO;
import com.jogos.api.dto.GameVRDTO;
import com.jogos.api.model.GameConsole;
import com.jogos.api.model.GamePC;
import com.jogos.api.model.GameVR;
import com.jogos.api.repository.GameConsole1Repository;
import com.jogos.api.repository.GamePCRepository;
import com.jogos.api.repository.GameVRRepository;
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
    private GamePCRepository repositoryPC;

    @Autowired
    private GameVRRepository repositoryVR;

    @Autowired
    private GameConsole1Repository repositoryConsole;

    @GetMapping("/getGames/PC")
    public List<GamePC1DTO> getGamesPC(){

        int retorno;
        List<GamePC1DTO> vazio = new ArrayList<>();
        List<GamePC1DTO> listGames = service.getGamesPC();

        retorno = userService.loginConferer();

        if(retorno == 1){
            return vazio;
        }

        return listGames;
    }

    @GetMapping("/getGames/VR")
    public List<GameVRDTO> getGamesVR(){

        int retorno;
        List<GameVRDTO> vazio = new ArrayList<>();
        List<GameVRDTO> listGames = service.getGamesVR();

        retorno = userService.loginConferer();

        if(retorno == 1){
            return vazio;
        }

        return listGames;
    }

    @GetMapping("/getGames/Console")
    public List<GameConsoleDTO> getGamesConsole(){

        int retorno;
        List<GameConsoleDTO> vazio = new ArrayList<>();
        List<GameConsoleDTO> listGames = service.getGamesConsole();

        retorno = userService.loginConferer();

        if(retorno == 1){
            return vazio;
        }

        return listGames;
    }

    @PostMapping("/postGame/PC")
    public String postGamePC(@RequestBody GamePC game) {

        int retorno;

        retorno = userService.loginConferer();

        if (retorno == 0) {
            return "Esse usuário não tem permissão para esse comando";
        }else if(retorno == 1){
            return "Login necessário";
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
    public String postGameVR(@RequestBody GameVR game){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuario não tem permissão para usar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
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
    public String postGameConsole(@RequestBody GameConsole game){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuario não tem permissão para usar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
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

    @DeleteMapping("/deleteGame/PC/{id}")
    public String deleteGamePC(@PathVariable Long id){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
        }

        if(!service.IdPCExists(id)){
            return "Jogo não encontrado";
        }

        repositoryPC.deleteById(id);

        return "Jogo deletado com sucesso";
    }

    @DeleteMapping("/deleteGame/VR/{id}")
    public String deleteGameVR(@PathVariable Long id){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }else if(retorno == 1){
            return "Login necessãrio";
        }

        if(!service.IdVRExists(id)){
            return "Jogo não encontrado";
        }

        repositoryVR.deleteById(id);

        return "Jogo deletado com sucesso";
    }

    @DeleteMapping("/deleteGame/Console/{id}")
    public String deleteGameConsole(@PathVariable Long id){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }else if(retorno == 1){
            return "Login necessãrio";
        }

        if(!service.IdConsoleExists(id)){
            return "Jogo não encontrado";
        }

        repositoryConsole.deleteById(id);

        return "Jogo deletado com sucesso";
    }

    @PutMapping("/updateGame/PC/{id}")
    public String updateGamePC(@PathVariable Long id, @RequestBody GamePC game){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
        }

        if(!service.IdPCExists(id)){
            return "Jogo não encontrado";
        }

        service.updateGamePC(id, game);

        return "Os dados do jogo foram atualizados";
    }

    @PutMapping("/updateGame/VR/{id}")
    public String updateGameVR(@PathVariable Long id, @RequestBody GameVR game){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
        }

        if(!service.IdVRExists(id)){
            return "Jogo não encontrado";
        }

        service.updateGameVR(id, game);

        return "Os dados do jogo foram atualizados";
    }

    @PutMapping("/updateGame/Console/{id}")
    public String updateGameConsole(@PathVariable Long id, @RequestBody GameConsole game){

        int retorno;

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
        }

        if(!service.IdConsoleExists(id)){
            return "Jogo não encontrado";
        }

        service.updateGameConsole(id, game);

        return "Os dados do jogo foram atualizados";
    }

        /*@DeleteMapping("/delete")
        public String deleteAll(){
            repo.deleteAll();

            return "Apagou";
        }*/
}
