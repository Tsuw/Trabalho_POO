package com.jogos.api.controller;

import com.jogos.api.dto.DLCConsoleDTO;
import com.jogos.api.dto.DLCPCDTO;
import com.jogos.api.dto.DLCVRDTO;
import com.jogos.api.model.DLCConsole;
import com.jogos.api.model.DLCPC;
import com.jogos.api.model.DLCVR;
import com.jogos.api.repository.*;
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
    private DLCPCRepository repositoryDLCPC;

    @Autowired
    private DLCVRRepository repositoryDLCVR;

    @Autowired
    private DLCConsoleRepository repositoryDLCConsole;

    @Autowired
    private GamePCRepository repositoryPC;

    @Autowired
    private GameVRRepository repositoryVR;

    @Autowired
    private GameConsoleRepository repositoryConsole;

    @GetMapping("/getDLC/PC/{ownedGame}")
    public List<DLCPCDTO> getDLCPCbyName(@PathVariable("ownedGame") String ownedGame){

        int retorno;
        List<DLCPCDTO> vazio = new ArrayList<>();

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return vazio;
        }

        if(!repositoryPC.existsByName(ownedGame)){
            return vazio;
        }

        return service.getDLCPC(ownedGame);
    }

    @GetMapping("/getDLC/VR/{ownedGame}")
    public List<DLCVRDTO> getDLCVRbyName(@PathVariable("ownedGame") String ownedGame){

        int retorno;
        List<DLCVRDTO> vazio = new ArrayList<>();

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return vazio;
        }

        if(!repositoryVR.existsByName(ownedGame)){
            return vazio;
        }

        return service.getDLCVR(ownedGame);

    }

    @GetMapping("/getDLC/Console/{ownedGame}")
    public List<DLCConsoleDTO> getDLCConsolebyName(@PathVariable("ownedGame") String ownedGame){

        int retorno;
        List<DLCConsoleDTO> vazio = new ArrayList<>();

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return vazio;
        }

        if(!repositoryConsole.existsByName(ownedGame)){
            return vazio;
        }

        return service.getDLCConsele(ownedGame);
    }

    @PostMapping("/postDLC/PC")
    public String postDLCPC(@RequestBody DLCPC dlc){

        int retorno;
        String erro = service.validationDLCPC(dlc);

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return "Login não identificado";
        }else if(retorno == 0){
            return "Esse usuário não tem permissão para esse comando";
        }

        if(erro == null){
            repositoryDLCPC.save(dlc);

            return "DLC adicionado com sucesso";
        }else{
            return erro;
        }
    }

    @PostMapping("/postDLC/VR")
    public String postDLCVR(@RequestBody DLCVR dlc){

        int retorno;
        String erro = service.validationDLCVR(dlc);

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return "Login não identificado";
        }else if(retorno == 0){
            return "Esse usuário não tem permissão para esse comando";
        }

        if(erro == null){

            repositoryDLCVR.save(dlc);

            return "DLC adicionada com sucesso";
        }else{
            return erro;
        }
    }

    @PostMapping("/postDLC/Console")
    public String postDLCConsole(@RequestBody DLCConsole dlc){

        int retorno;
        String erro = service.validationDLCConsole(dlc);

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return "Login não identificado";
        }else if(retorno == 0){
            return "Esse usuário não tem permissão para esse comando";
        }

        if(erro == null){
            repositoryDLCConsole.save(dlc);

            return "DLC adicionado com sucesso";
        }else{
            return erro;
        }
    }

    @PutMapping("/updateDLC/PC/{id}")
    public String updateDLCPC(@RequestBody DLCPC dlc, @PathVariable("id") Long id){

        int retorno;
        String erro = service.validationDLCPC(dlc);

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return "Login não encontrado";
        }else if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }

        if(!repositoryDLCPC.existsById(id)){
            return "DLC não encontrada";
        }

        if(erro == null){
            service.updateDLCPC(dlc, id);

            return "Os dados da DLC foram atualizados";
        }else{
            return erro;
        }
    }

    @PutMapping("/updateDLC/VR/{id}")
    public String updateDLCVR(@RequestBody DLCVR dlc, @PathVariable("id") Long id){

        int retorno;
        String erro = service.validationDLCVR(dlc);

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return "Login não encontrado";
        }else if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }

        if(!repositoryDLCVR.existsById(id)){
            return "DLC não encontrada";
        }

        if(erro == null){
            service.updateDLCVR(dlc, id);

            return "Os dados da DLC foram atualizados";
        }else{
            return erro;
        }
    }

    @PutMapping("/updateDLC/Console/{id}")
    public String updateDLCConsole(@RequestBody DLCConsole dlc, @PathVariable("id") Long id){

        int retorno;
        String erro = service.validationDLCConsole(dlc);

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return "Login não encontrado";
        }else if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }

        if(!repositoryDLCConsole.existsById(id)){
            return "DLC não encontrada";
        }

        if(erro == null){
            service.updateDLCConsole(dlc, id);

            return "Os dados da DLC foram atualizados";
        }else{
            return erro;
        }
    }

    @DeleteMapping("/deleteDLC/PC/{id}")
    public String deleteDLCPC(@PathVariable("id") Long id){

        int retorno;

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return "Login não encontrado";
        }else if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }

        if(!repositoryDLCPC.existsById(id)){
            return "DLC não encontrada";
        }

        repositoryDLCPC.deleteById(id);

        return "DLC deletada com sucesso";
    }

    @DeleteMapping("/deleteDLC/VR/{id}")
    public String deleteDLCVR(@PathVariable("id") Long id){

        int retorno;

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return "Login não encontrado";
        }else if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }

        if(repositoryDLCVR.existsById(id)){
            return "DLC não encontrada";
        }

        repositoryDLCVR.deleteById(id);

        return "DLC deletada com sucesso";
    }

    @DeleteMapping("/deleteDLC/Console/{id}")
    public String deleteDLCConsole(@PathVariable("id") Long id){

        int retorno;

        retorno = uservice.loginConferer();

        if(retorno == 1){
            return "Login não encontrado";
        }else if(retorno == 0){
            return "Esse usuário não tem permissão para executar esse comando";
        }

        if(repositoryDLCConsole.existsById(id)){
            return "DLC não encontrada";
        }

        repositoryDLCConsole.deleteById(id);

        return "DLC deletada com sucesso";
    }

}