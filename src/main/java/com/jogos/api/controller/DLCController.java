package com.jogos.api.controller;

import com.jogos.api.model.Dlc;
import com.jogos.api.service.DLCService;
import com.jogos.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DLCController {

    private final DLCService service;

    private final UserService userService;

    public DLCController(DLCService service, UserService userService){
        this.service = service;
        this.userService = userService;
    }

    private String userAuth;

    @PostMapping("/postDLC")
    public ResponseEntity<String> postDLC(@RequestBody Dlc dlc){

        String retorno = service.post(dlc);
        this.userAuth = userService.loginConferer();

        if(this.userAuth != null){
            return ResponseEntity.badRequest().body(this.userAuth);
        }

        if(retorno.equals("DLC adicionada com sucesso")){
            return ResponseEntity.status(HttpStatus.OK).body(retorno);
        }else{
            return ResponseEntity.badRequest().body(retorno);
        }
    }

    @PutMapping("/updateDLC/{id}")
    public ResponseEntity<String> updateDLC(@RequestBody Dlc dlc, @PathVariable Long id){

        String retorno = service.update(dlc, id);
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

    @DeleteMapping("/deleteDLC/{id}")
    public ResponseEntity<String> deleteDLC(@PathVariable Long id){

        String retorno = service.delete(id);
        this.userAuth = userService.loginConferer();

        if(this.userAuth != null){
            return ResponseEntity.badRequest().body(this.userAuth);
        }

        if(retorno.equals("DLC deletada com sucesso")){
            return ResponseEntity.status(HttpStatus.OK).body(retorno);
        }else{
            return ResponseEntity.badRequest().body(retorno);
        }
    }

}
