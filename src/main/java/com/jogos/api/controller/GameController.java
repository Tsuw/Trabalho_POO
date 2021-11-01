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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {

    private final GameService service;

    private final UserService userService;

    private final GamePCRepository repositoryPC;

    private final GameVRRepository repositoryVR;

    private final GameConsoleRepository repositoryConsole;

    private String retorno;

    public GameController(GameService service, UserService userService, GamePCRepository repositoryPC, GameVRRepository repositoryVR, GameConsoleRepository repositoryConsole) {
        this.service = service;
        this.userService = userService;
        this.repositoryPC = repositoryPC;
        this.repositoryVR = repositoryVR;
        this.repositoryConsole = repositoryConsole;
    }

    @GetMapping("/getGames/PC")
    public ResponseEntity<List<GamePCDTO>> getGamesPC(){

        List<GamePCDTO> vazio = new ArrayList<>();
        List<GamePCDTO> listGames = service.getGamesPC();
        int retorno;

        retorno = userService.alternativeLoginConferer();

        if(retorno == 1){
            return ResponseEntity.badRequest().body(vazio);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(listGames);
        }
    }

    @GetMapping("/getGames/VR")
    public ResponseEntity<List<GameVRDTO>> getGamesVR(){

        List<GameVRDTO> vazio = new ArrayList<>();
        List<GameVRDTO> listGames = service.getGamesVR();
        int retorno;

        retorno = userService.alternativeLoginConferer();

        if(retorno == 1){
            return ResponseEntity.badRequest().body(vazio);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(listGames);
        }
    }

    @GetMapping("/getGames/Console")
    public ResponseEntity<List<GameConsoleDTO>> getGamesConsole(){

        List<GameConsoleDTO> vazio = new ArrayList<>();
        List<GameConsoleDTO> listGames = service.getGamesConsole();
        int retorno;

        retorno = userService.alternativeLoginConferer();

        if(retorno == 1){
            return ResponseEntity.badRequest().body(vazio);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(listGames);
        }
    }

    @PostMapping("/postGame/PC")
    public ResponseEntity<String> postGamePC(@RequestBody GamePC game) {

        String erro = service.validationPC(game);

        this.retorno = userService.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(erro == null){

            repositoryPC.save(game);

            return ResponseEntity.status(HttpStatus.OK).body("Jogo adicionado com sucesso");

        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PostMapping("/postGame/VR")
    public ResponseEntity<String> postGameVR(@RequestBody GameVR game){

        String erro = service.validationVR(game);

        this.retorno = userService.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(erro == null){

            repositoryVR.save(game);

            return ResponseEntity.status(HttpStatus.OK).body("Jogo adicionado com sucesso");

        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PostMapping("/postGame/Console")
    public ResponseEntity<String> postGameConsole(@RequestBody GameConsole game){

        String erro = service.validationConsole(game);

        this.retorno = userService.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(erro == null){

            repositoryConsole.save(game);

            return ResponseEntity.status(HttpStatus.OK).body("Jogo adicionado com sucesso");

        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @DeleteMapping("/deleteGame/PC/{id}")
    public ResponseEntity<String> deleteGamePC(@PathVariable Long id){

        this.retorno = userService.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(!repositoryPC.existsById(id)){
            return ResponseEntity.badRequest().body("Jogo não encontrado");
        }

        repositoryPC.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Jogo deletado com sucesso");
    }

    @DeleteMapping("/deleteGame/VR/{id}")
    public ResponseEntity<String> deleteGameVR(@PathVariable Long id){

        this.retorno = userService.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(!repositoryVR.existsById(id)){
            return ResponseEntity.badRequest().body("Jogo não encontrado");
        }

        repositoryVR.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Jogo deletado com sucesso");
    }

    @DeleteMapping("/deleteGame/Console/{id}")
    public ResponseEntity<String> deleteGameConsole(@PathVariable Long id){

        this.retorno = userService.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(!repositoryConsole.existsById(id)){
            return ResponseEntity.badRequest().body("Jogo não encontrado");
        }

        repositoryConsole.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Jogo deletado com sucesso");
    }

    @PutMapping("/updateGame/PC/{id}")
    public ResponseEntity<String> updateGamePC(@PathVariable Long id, @RequestBody GamePC game){

        String erro = service.validationPC(game);

        this.retorno = userService.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(!repositoryPC.existsById(id)){
            return ResponseEntity.badRequest().body("Jogo não encontrado");
        }

        if(erro == null){
            service.updateGamePC(id, game);

            return ResponseEntity.status(HttpStatus.OK).body("Os dados do jogo foram atualizados");
        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PutMapping("/updateGame/VR/{id}")
    public ResponseEntity<String> updateGameVR(@PathVariable Long id, @RequestBody GameVR game){

        String erro = service.validationVR(game);

        this.retorno = userService.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(!repositoryVR.existsById(id)){
            return ResponseEntity.badRequest().body("Jogo não encontrado");
        }

        if(erro == null){
            service.updateGameVR(id, game);

            return ResponseEntity.status(HttpStatus.OK).body("Os dados do jogo foram atualizados");
        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PutMapping("/updateGame/Console/{id}")
    public ResponseEntity<String> updateGameConsole(@PathVariable Long id, @RequestBody GameConsole game){

        String erro = service.validationConsole(game);

        this.retorno = userService.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(!repositoryConsole.existsById(id)){
            return ResponseEntity.badRequest().body("Jogo não encontrado");
        }

        if(erro == null){
            service.updateGameConsole(id, game);

            return ResponseEntity.status(HttpStatus.OK).body("Os dados do jogo foram atualizados");
        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }
}
