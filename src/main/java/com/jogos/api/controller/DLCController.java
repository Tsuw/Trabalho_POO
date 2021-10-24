package com.jogos.api.controller;

import com.jogos.api.dto.DLCDTO;
import com.jogos.api.model.DLCEntity;
import com.jogos.api.repository.DLCRepository;
import com.jogos.api.service.DLCService;
import com.jogos.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DLCController {

    @Autowired
    private UserService uservice;

    @Autowired
    private DLCService service;

    @Autowired
    private DLCRepository repo;

    @GetMapping("/getDLC/{ownedGame}")
    public List<DLCDTO> getDLCbyName(@PathVariable String ownedGame) {

        int retorno;
        List<DLCDTO> vazio = new ArrayList<>();

        retorno = uservice.loginConferer();

        if (retorno == 1) {
            return vazio;
        }

        retorno = service.NameConferer(ownedGame);

        if (retorno == 1) {
            return vazio;
        }

        return service.getDLC(ownedGame);
    }

    @PostMapping("/postDLC")
    public String postDLC(@RequestBody DLCEntity DLC) {

        int retorno;

        retorno = uservice.loginConferer();

        if (retorno == 1) {
            return "Login não indentificado";
        } else if (retorno == 0) {
            return "Esse usuario não tem permição para esse comando";
        }

        repo.save(DLC);

        return "DLC adicionado com sucesso";
    }

    @PutMapping("/updateDLC/{id}")
    public String updateDLC(@RequestBody DLCEntity DLC, @PathVariable Long id) {

        int retorno;

        retorno = uservice.loginConferer();

        if (retorno == 1) {
            return "Login não encontrado";
        } else if (retorno == 0) {
            return "Esse usuario não tem permição para esse comando";
        }

        if (!service.IDExists(id)) {
            return "DLC não encontrada";
        }

        service.update(DLC, id);

        return "Os dados da DLC foram atualizados";
    }

    @DeleteMapping("/deleteDLC/{id}")
    public String deleteDLC(@PathVariable Long id) {

        int retorno;

        retorno = uservice.loginConferer();

        if (retorno == 1) {
            return "Login não encontrado";
        } else if (retorno == 0) {
            return "Esse usuario não tem permição para esse comando";
        }

        repo.deleteById(id);

        return "DLC deletada com sucesso";
    }


}
