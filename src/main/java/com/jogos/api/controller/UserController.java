package com.jogos.api.controller;

import com.jogos.api.dto.UserDTO;
import com.jogos.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService service;

    private String retorno;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDTO User) {

        this.retorno = service.signup(User);

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Usuario adicionado");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO User) {

        this.retorno = service.login(User);

        if (this.retorno != null) {
            return ResponseEntity.badRequest().body(this.retorno);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Login efetuado com sucesso");
        }
    }
}
