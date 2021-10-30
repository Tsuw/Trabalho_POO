package com.jogos.api.controller;

import com.jogos.api.dto.GameConsoleDTO;
import com.jogos.api.dto.GamePCDTO;
import com.jogos.api.dto.GameVRDTO;
import com.jogos.api.model.GameConsole;
import com.jogos.api.model.GamePC;
import com.jogos.api.model.GameVR;
import com.jogos.api.repository.GameConsoleRepository;
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
    private GameConsoleRepository repositoryConsole;

    @GetMapping("/getGames/PC")
    public List<GamePCDTO> getGamesPC(){

        int retorno;
        List<GamePCDTO> vazio = new ArrayList<>();
        List<GamePCDTO> listGames = service.getGamesPC();

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
        String erro = service.validationPC(game);

        retorno = userService.loginConferer();

        if (retorno == 0) {
            return "Esse usuário não tem permissão para esse comando";
        }else if(retorno == 1){
            return "Login necessário";
        }

        if(erro == null){

            repositoryPC.save(game);

            return "Jogo adicionado com sucesso";

        }else{
            return erro;
        }
    }

    @PostMapping("/postGame/VR")
    public String postGameVR(@RequestBody GameVR game){

        int retorno;
        String erro = service.validationVR(game);

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuario não tem permissão para usar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
        }

        if(erro == null){

            repositoryVR.save(game);

            return "Jogo adicionado com sucesso";

        }else{
            return erro;
        }
    }

    @PostMapping("/postGame/Console")
    public String postGameConsole(@RequestBody GameConsole game){

        int retorno;
        String erro = service.validationConsole(game);

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuario não tem permissão para usar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
        }

        if(erro == null){

            repositoryConsole.save(game);

            return "Jogo adicionado com sucesso";

        }else{
            return erro;
        }
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

        if(!repositoryPC.existsById(id)){
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

        if(!repositoryVR.existsById(id)){
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

        if(!repositoryConsole.existsById(id)){
            return "Jogo não encontrado";
        }

        repositoryConsole.deleteById(id);

        return "Jogo deletado com sucesso";
    }

    @PutMapping("/updateGame/PC/{id}")
    public String updateGamePC(@PathVariable Long id, @RequestBody GamePC game){

        int retorno;
        String erro = service.validationPC(game);

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
        }

        if(!repositoryPC.existsById(id)){
            return "Jogo não encontrado";
        }

        if(erro == null){
            service.updateGamePC(id, game);

            return "Os dados do jogo foram atualizados";
        }else{
            return erro;
        }
    }

    @PutMapping("/updateGame/VR/{id}")
    public String updateGameVR(@PathVariable Long id, @RequestBody GameVR game){

        int retorno;
        String erro = service.validationVR(game);

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
        }

        if(!repositoryVR.existsById(id)){
            return "Jogo não encontrado";
        }

        if(erro == null){
            service.updateGameVR(id, game);

            return "Os dados do jogo foram atualizados";
        }else{
            return erro;
        }
    }

    @PutMapping("/updateGame/Console/{id}")
    public String updateGameConsole(@PathVariable Long id, @RequestBody GameConsole game){

        int retorno;
        String erro = service.validationConsole(game);

        retorno = userService.loginConferer();

        if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }else if(retorno == 1){
            return "Login necessário";
        }

        if(!repositoryConsole.existsById(id)){
            return "Jogo não encontrado";
        }

        if(erro == null){
            service.updateGameConsole(id, game);

            return "Os dados do jogo foram atualizados";
        }else{
            return erro;
        }
    }
}
