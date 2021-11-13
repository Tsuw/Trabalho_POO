package com.jogos.api.controller;
import com.jogos.api.model.Game;
import com.jogos.api.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    private final GameService service;

    public TestController(GameService service){
        this.service = service;
    }


    @PostMapping("/postGame")
    public ResponseEntity<String> postGame(@RequestBody Game game){

        String retorno = service.post(game);

        if(retorno.equals("Jogo adicionado com sucesso")){

            return ResponseEntity.status(HttpStatus.OK).body(retorno);

        }else{

            return ResponseEntity.badRequest().body(retorno);

        }
    }

    @PutMapping("/updateGame/{id}")
    public ResponseEntity<String> updateGame(@RequestBody Game game, @PathVariable Long id){

        String retorno = service.update(game, id);

        if(retorno.equals("Os dados foram atualizados com sucesso")){

            return ResponseEntity.status(HttpStatus.OK).body(retorno);

        }else{

            return ResponseEntity.badRequest().body(retorno);

        }
    }

    @DeleteMapping("/deleteGame/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable Long id){

        String retorno = service.delete(id);

        if(retorno.equals("Jogo deletado com sucesso")){

            return ResponseEntity.status(HttpStatus.OK).body(retorno);
        }else{
            return ResponseEntity.badRequest().body(retorno);
        }
    }

}
