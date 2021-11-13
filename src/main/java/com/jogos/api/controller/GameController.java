package com.jogos.api.controller;
import com.jogos.api.dto.GameConsoleDTO;
import com.jogos.api.dto.GamePCDTO;
import com.jogos.api.dto.GameVRDTO;
import com.jogos.api.model.Game;
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

    public GameController(GameService service, UserService userService){
        this.service = service;
        this.userService = userService;
    }

    private String userAuth;

    @GetMapping("/getGames/PC")
    public ResponseEntity<List<GamePCDTO>> getGamePC(){

        List<GamePCDTO> vazio = new ArrayList<>();
        List<GamePCDTO> list = service.getGamePC();
        int userAuth = userService.alternativeLoginConferer();

        if(userAuth == 1){
            return ResponseEntity.badRequest().body(vazio);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }

    @GetMapping("/getGames/VR")
    public ResponseEntity<List<GameVRDTO>> getGameVR(){

        List<GameVRDTO> vazio = new ArrayList<>();
        List<GameVRDTO> list = service.getGameVR();
        int userAuth = userService.alternativeLoginConferer();

        if(userAuth == 1){
            return ResponseEntity.badRequest().body(vazio);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }

    @GetMapping("/getGames/Console")
    public ResponseEntity<List<GameConsoleDTO>> getGameConsole(){

        List<GameConsoleDTO> vazio = new ArrayList<>();
        List<GameConsoleDTO> list = service.getGameConsole();
        int userAuth = userService.alternativeLoginConferer();

        if(userAuth == 1){
            return ResponseEntity.badRequest().body(vazio);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }

    @PostMapping("/postGame")
    public ResponseEntity<String> postGame(@RequestBody Game game){

        String retorno = service.post(game);
        this.userAuth = userService.loginConferer();

        if(this.userAuth != null){
            return ResponseEntity.badRequest().body(this.userAuth);
        }

        if(retorno.equals("Jogo adicionado com sucesso")){

            return ResponseEntity.status(HttpStatus.OK).body(retorno);

        }else{

            return ResponseEntity.badRequest().body(retorno);

        }
    }

    @PutMapping("/updateGame/{id}")
    public ResponseEntity<String> updateGame(@RequestBody Game game, @PathVariable Long id){

        String retorno = service.update(game, id);
        this.userAuth = userService.loginConferer();

        if(this.userAuth != null){
            return ResponseEntity.badRequest().body(this.userAuth);
        }

        if(retorno.equals("Os dados foram atualizados com sucesso")){

            return ResponseEntity.status(HttpStatus.OK).body(retorno);

        }else{

            return ResponseEntity.badRequest().body(retorno);

        }
    }

    @DeleteMapping("/deleteGame/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable Long id){

        String retorno = service.delete(id);
        this.userAuth = userService.loginConferer();

        if(this.userAuth != null){
            return ResponseEntity.badRequest().body(this.userAuth);       }

        if(retorno.equals("Jogo deletado com sucesso")){

            return ResponseEntity.status(HttpStatus.OK).body(retorno);
        }else{
            return ResponseEntity.badRequest().body(retorno);
        }
    }

}
