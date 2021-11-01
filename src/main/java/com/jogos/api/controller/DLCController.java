package com.jogos.api.controller;

import com.jogos.api.dto.DLCConsoleDTO;
import com.jogos.api.dto.DlcPcDto;
import com.jogos.api.dto.DlcVrDto;
import com.jogos.api.model.DLCConsole;
import com.jogos.api.model.DlcPC;
import com.jogos.api.model.DlcVR;
import com.jogos.api.repository.*;
import com.jogos.api.service.DLCService;
import com.jogos.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DLCController {

    private final UserService uservice;

    private final DLCService service;

    private final DLCPCRepository repositoryDLCPC;

    private final DLCVRRepository repositoryDLCVR;

    private final DLCConsoleRepository repositoryDLCConsole;

    private final GamePCRepository repositoryPC;

    private final GameVRRepository repositoryVR;

    private final GameConsoleRepository repositoryConsole;

    private String retorno;

    public DLCController(UserService uservice, DLCService service, DLCPCRepository repositoryDLCPC, DLCVRRepository repositoryDLCVR, DLCConsoleRepository repositoryDLCConsole, GamePCRepository repositoryPC, GameVRRepository repositoryVR, GameConsoleRepository repositoryConsole) {
        this.uservice = uservice;
        this.service = service;
        this.repositoryDLCPC = repositoryDLCPC;
        this.repositoryDLCVR = repositoryDLCVR;
        this.repositoryDLCConsole = repositoryDLCConsole;
        this.repositoryPC = repositoryPC;
        this.repositoryVR = repositoryVR;
        this.repositoryConsole = repositoryConsole;
    }

    @GetMapping("/getDLC/PC/{ownedGame}")
    public ResponseEntity<List<DlcPcDto>> getDLCPCbyName(@PathVariable("ownedGame") String ownedGame){

        List<DlcPcDto> vazio = new ArrayList<>();
        int retorno;

        retorno = uservice.alternativeLoginConferer();

        if(retorno == 1){
            return ResponseEntity.badRequest().body(vazio);
        }

        if(!repositoryPC.existsByName(ownedGame)){
            return ResponseEntity.badRequest().body(vazio);
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.getDLCPC(ownedGame));
    }

    @GetMapping("/getDLC/VR/{ownedGame}")
    public ResponseEntity<List<DlcVrDto>> getDLCVRbyName(@PathVariable("ownedGame") String ownedGame){

        List<DlcVrDto> vazio = new ArrayList<>();
        int retorno;

        retorno = uservice.alternativeLoginConferer();

        if(retorno == 1){
            return ResponseEntity.badRequest().body(vazio);
        }

        if(!repositoryVR.existsByName(ownedGame)){
            return ResponseEntity.badRequest().body(vazio);
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.getDLCVR(ownedGame));

    }

    @GetMapping("/getDLC/Console/{ownedGame}")
    public ResponseEntity<List<DLCConsoleDTO>> getDLCConsolebyName(@PathVariable("ownedGame") String ownedGame){

        List<DLCConsoleDTO> vazio = new ArrayList<>();
        int retorno;

        retorno = uservice.alternativeLoginConferer();

        if(retorno == 1){
            return ResponseEntity.badRequest().body(vazio);
        }

        if(!repositoryConsole.existsByName(ownedGame)){
            return ResponseEntity.badRequest().body(vazio);
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.getDLCConsele(ownedGame));
    }

    @PostMapping("/postDLC/PC")
    public ResponseEntity<String> postDLCPC(@RequestBody DlcPC dlc){

        String erro = service.validationDLCPC(dlc);

        this.retorno = uservice.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(erro == null){
            repositoryDLCPC.save(dlc);

            return ResponseEntity.status(HttpStatus.OK).body("DLC adicionado com sucesso");
        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PostMapping("/postDLC/VR")
    public ResponseEntity<String> postDLCVR(@RequestBody DlcVR dlc){

        String erro = service.validationDLCVR(dlc);

        this.retorno = uservice.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(erro == null){

            repositoryDLCVR.save(dlc);

            return ResponseEntity.status(HttpStatus.OK).body("DLC adicionado com sucesso");
        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PostMapping("/postDLC/Console")
    public ResponseEntity<String> postDLCConsole(@RequestBody DLCConsole dlc){

        String erro = service.validationDLCConsole(dlc);

        this.retorno = uservice.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(erro == null){
            repositoryDLCConsole.save(dlc);

            return ResponseEntity.status(HttpStatus.OK).body("DLC adicionado com sucesso");
        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PutMapping("/updateDLC/PC/{id}")
    public ResponseEntity<String> updateDLCPC(@RequestBody DlcPC dlc, @PathVariable("id") Long id){

        String erro = service.validationDLCPC(dlc);

        this.retorno = uservice.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(!repositoryDLCPC.existsById(id)){
            return ResponseEntity.badRequest().body("DLC não encontrada");
        }

        if(erro == null){
            service.updateDLCPC(dlc, id);

            return ResponseEntity.status(HttpStatus.OK).body("Os dados da DLC foram atualizados");
        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PutMapping("/updateDLC/VR/{id}")
    public ResponseEntity<String> updateDLCVR(@RequestBody DlcVR dlc, @PathVariable("id") Long id){

        String erro = service.validationDLCVR(dlc);

        this.retorno = uservice.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(!repositoryDLCVR.existsById(id)){
            return ResponseEntity.badRequest().body("DLC não encontrada");
        }

        if(erro == null){
            service.updateDLCVR(dlc, id);

            return ResponseEntity.status(HttpStatus.OK).body("Os dados da DLC foram atualizados");
        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PutMapping("/updateDLC/Console/{id}")
    public ResponseEntity<String> updateDLCConsole(@RequestBody DLCConsole dlc, @PathVariable("id") Long id){

        String erro = service.validationDLCConsole(dlc);

        this.retorno = uservice.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(!repositoryDLCConsole.existsById(id)){
            return ResponseEntity.status(HttpStatus.OK).body("DLC não encontrada");
        }

        if(erro == null){
            service.updateDLCConsole(dlc, id);

            return ResponseEntity.status(HttpStatus.OK).body("Os dados da DLC foram atualizados");
        }else{
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @DeleteMapping("/deleteDLC/PC/{id}")
    public ResponseEntity<String> deleteDLCPC(@PathVariable("id") Long id){

        this.retorno = uservice.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(!repositoryDLCPC.existsById(id)){
            return ResponseEntity.badRequest().body("DLC não encontrada");
        }

        repositoryDLCPC.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("DLC deletada com sucesso");
    }

    @DeleteMapping("/deleteDLC/VR/{id}")
    public ResponseEntity<String> deleteDLCVR(@PathVariable("id") Long id){

        this.retorno = uservice.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(repositoryDLCVR.existsById(id)){
            return ResponseEntity.badRequest().body("DLC não encontrada");
        }

        repositoryDLCVR.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("DLC deletada com sucesso");
    }

    @DeleteMapping("/deleteDLC/Console/{id}")
    public ResponseEntity<String> deleteDLCConsole(@PathVariable("id") Long id){

        this.retorno = uservice.loginConferer();

        if(this.retorno != null){
            return ResponseEntity.badRequest().body(this.retorno);
        }

        if(repositoryDLCConsole.existsById(id)){
            return ResponseEntity.badRequest().body("DLC não encontrada");
        }

        repositoryDLCConsole.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("DLC deletada com sucesso");
    }
}