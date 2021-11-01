package com.jogos.api.service;

import com.jogos.api.dto.DLCConsoleDTO;
import com.jogos.api.dto.DlcPcDto;
import com.jogos.api.dto.DlcVrDto;
import com.jogos.api.dto.RequirementsDTO;
import com.jogos.api.model.*;
import com.jogos.api.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class DLCService {

    private final DLCPCRepository repositoryDPC;

    private final DLCVRRepository repositoryDVR;

    private final DLCConsoleRepository repositoryDConsole;

    public DLCService(DLCPCRepository repositoryDPC, DLCVRRepository repositoryDVR, DLCConsoleRepository repositoryDConsole) {
        this.repositoryDPC = repositoryDPC;
        this.repositoryDVR = repositoryDVR;
        this.repositoryDConsole = repositoryDConsole;
    }

    public List<DlcPcDto> getDLCPC(String ownedGameName){

        List<DlcPcDto> list = new ArrayList<>();
        List<DlcPC> listDLC = repositoryDPC.findByOwnedGame(ownedGameName);

        for (DlcPC enty : listDLC) {

            DlcPcDto dto = new DlcPcDto(enty);

            dto.setMinimumRequirements(new RequirementsDTO(enty.getMinimumRequirements()));
            dto.setRecommendedRequirements(new RequirementsDTO(enty.getRecommendedRequirements()));

            list.add(dto);
        }

        return list;
    }

    public List<DlcVrDto> getDLCVR(String ownedGameName){

        List<DlcVrDto> listGame = new ArrayList<>();
        List<DlcVR> listDLC = repositoryDVR.findByOwnedGame(ownedGameName);

        for (DlcVR enty : listDLC) {

            DlcVrDto dto = new DlcVrDto(enty);

            dto.setMinimumRequirements(new RequirementsDTO(enty.getMinimumRequirements()));
            dto.setRecommendedRequirements(new RequirementsDTO(enty.getRecommendedRequirements()));

            listGame.add(dto);
        }

        return listGame;
    }

    public List<DLCConsoleDTO> getDLCConsele(String ownedGameName){

        List<DLCConsoleDTO> listGame = new ArrayList<>();
        List<DLCConsole> listDLC = repositoryDConsole.findByOwnedGame(ownedGameName);

        for (DLCConsole enty : listDLC) {

            DLCConsoleDTO dto = new DLCConsoleDTO(enty);

            dto.setStorage(enty.getStorage());

            listGame.add(dto);
        }

        return listGame;
    }

    public String validationDLCPC(DlcPC dlcpc){
        return validationDLCPCSecret(dlcpc);
    }

    private String validationDLCPCSecret(DlcPC dlcpc){

        Date d = new Date();

        if(dlcpc.getOwnedGame() == null || dlcpc.getOwnedGame().isEmpty()){
            return "A DLC necessita do nome do jogo de origem";
        }

        if(dlcpc.getName() == null || dlcpc.getName().isEmpty()){
            return "A DLC necessita de um nome";
        }

        if(dlcpc.getReleaseDate() == null || d.compareTo(dlcpc.getReleaseDate()) < 0){
            return "Data invalida";
        }

        if(dlcpc.getDescription() == null || dlcpc.getDescription().isEmpty()){
            return "A DLC necessita de uma descrição";
        }

        if(dlcpc.getDeveloper() == null || dlcpc.getDeveloper().isEmpty()){
            return "A DLC necessita de um desenvolvedor";
        }

        if(dlcpc.getPeopleInvolved() < 0){
            return "Número de pessoas invalido";
        }

        if(dlcpc.getSoldCopies() < 0){
            return "Número de copias invalido";
        }

        if(dlcpc.getDistributor() == null || dlcpc.getDistributor().isEmpty()){
            return "A DLC necessita de um Distribuidor";
        }

        if(dlcpc.getScore() < 0 || dlcpc.getScore() > 100){
            return "Nota invalida";
        }

        if(dlcpc.getPrice() < 0){
            return "Preço invalido";
        }

        if(dlcpc.getGenre() == null || dlcpc.getGenre().isEmpty()){
            return "A DLC necessita de um gênero";
        }

        if(dlcpc.getRating() > 21 || dlcpc.getRating() < 0){
            return "Faixa etária invalida";
        }

        if(dlcpc.getMinimumRequirements() == null){
            return "A DLC necessita de requisitos minimos";
        }

        if(dlcpc.getRecommendedRequirements() == null){
            return "A DLC necessita de requisitos recomendados";
        }

        return null;
    }

    public String validationDLCVR(DlcVR dlcvr){
        return validationDLCVRSecret(dlcvr);
    }

    private String validationDLCVRSecret(DlcVR dlcvr){

        Date d = new Date();

        if(dlcvr.getOwnedGame() == null || dlcvr.getOwnedGame().isEmpty()){
            return "A DLC necessita do nome do jogo de origem";
        }

        if(dlcvr.getName() == null || dlcvr.getName().isEmpty()){
            return "A DLC necessita de um nome";
        }

        if(dlcvr.getReleaseDate() == null || d.compareTo(dlcvr.getReleaseDate()) < 0){
            return "Data invalida";
        }

        if(dlcvr.getDescription() == null || dlcvr.getDescription().isEmpty()){
            return "A DLC necessita de uma descrição";
        }

        if(dlcvr.getDeveloper() == null || dlcvr.getDeveloper().isEmpty()){
            return "A DLC necessita de um desenvolvedor";
        }

        if(dlcvr.getPeopleInvolved() < 0){
            return "Número de pessoas invalido";
        }

        if(dlcvr.getSoldCopies() < 0){
            return "Número de copias invalido";
        }

        if(dlcvr.getDistributor() == null || dlcvr.getDistributor().isEmpty()){
            return "A DLC necessita de um Distribuidor";
        }

        if(dlcvr.getScore() < 0 || dlcvr.getScore() > 100){
            return "Nota invalida";
        }

        if(dlcvr.getPrice() < 0){
            return "Preço invalido";
        }

        if(dlcvr.getGenre() == null || dlcvr.getGenre().isEmpty()){
            return "A DLC necessita de um gênero";
        }

        if(dlcvr.getRating() > 21 || dlcvr.getRating() < 0){
            return "Faixa etária invalida";
        }

        if(dlcvr.getMinimumRequirements() == null){
            return "A DLC necessita de requisitos minimos";
        }

        if(dlcvr.getRecommendedRequirements() == null){
            return "A DLC necessita de requisitos recomendados";
        }

        return null;
    }

    public String validationDLCConsole(DLCConsole dlcConsole){
        return validationDLCConsoleSecret(dlcConsole);
    }

    private String validationDLCConsoleSecret(DLCConsole dlcConsole){

        Date d = new Date();

        if(dlcConsole.getName() == null || dlcConsole.getName().isEmpty()){
            return "A DLC necessita de um nome";
        }

        if(dlcConsole.getReleaseDate() == null || d.compareTo(dlcConsole.getReleaseDate()) < 0){
            return "Data invalida";
        }

        if(dlcConsole.getDescription() == null || dlcConsole.getDescription().isEmpty()){
            return "A DLC necessita de uma descrição";
        }

        if(dlcConsole.getDeveloper() == null || dlcConsole.getDeveloper().isEmpty()){
            return "A DLC necessita de um desenvolvedor";
        }

        if(dlcConsole.getPeopleInvolved() < 0){
            return "Número de pessoas invalido";
        }

        if(dlcConsole.getSoldCopies() < 0){
            return "Número de copias invalido";
        }

        if(dlcConsole.getDistributor() == null || dlcConsole.getDistributor().isEmpty()){
            return "A DLC necessita de um Distribuidor";
        }

        if(dlcConsole.getScore() < 0 || dlcConsole.getScore() > 100){
            return "Nota invalida";
        }

        if(dlcConsole.getPrice() < 0){
            return "Preço invalido";
        }

        if(dlcConsole.getGenre() == null || dlcConsole.getGenre().isEmpty()){
            return "A DLC necessita de um gênero";
        }

        if(dlcConsole.getRating() > 21 || dlcConsole.getRating() < 0){
            return "Faixa etária invalida";
        }

        if(dlcConsole.getStorage() == null || dlcConsole.getStorage().isEmpty()){
            return "A DLC precisa de um valor de armazenamento";
        }

        return null;

    }

    public void updateDLCPC(DlcPC dlc, Long id){

        Optional<DlcPC> enty = repositoryDPC.findById(id);

        if(enty.isPresent()){

            DlcPC entyUpdate = enty.get();

            entyUpdate.setOwnedGame(dlc.getOwnedGame());
            entyUpdate.setName(dlc.getName());
            entyUpdate.setReleaseDate(dlc.getReleaseDate());
            entyUpdate.setDescription(dlc.getDescription());
            entyUpdate.setDeveloper(dlc.getDeveloper());
            entyUpdate.setPeopleInvolved(dlc.getPeopleInvolved());
            entyUpdate.setSoldCopies(dlc.getSoldCopies());
            entyUpdate.setDistributor(dlc.getDistributor());
            entyUpdate.setScore(dlc.getScore());
            entyUpdate.setPrice(dlc.getPrice());
            entyUpdate.setGenre(dlc.getGenre());
            entyUpdate.setRating(dlc.getRating());
            entyUpdate.setPlatform(dlc.getPlatform());
            entyUpdate.setMinimumRequirements(dlc.getMinimumRequirements());
            entyUpdate.setRecommendedRequirements(dlc.getRecommendedRequirements());

            repositoryDPC.save(entyUpdate);
        }
    }

    public void updateDLCVR(DlcVR dlc, Long id){

        Optional<DlcVR> enty = repositoryDVR.findById(id);

        if(enty.isPresent()){

            DlcVR entyUpdate = enty.get();

            entyUpdate.setOwnedGame(dlc.getOwnedGame());
            entyUpdate.setName(dlc.getName());
            entyUpdate.setReleaseDate(dlc.getReleaseDate());
            entyUpdate.setDescription(dlc.getDescription());
            entyUpdate.setDeveloper(dlc.getDeveloper());
            entyUpdate.setPeopleInvolved(dlc.getPeopleInvolved());
            entyUpdate.setSoldCopies(dlc.getSoldCopies());
            entyUpdate.setDistributor(dlc.getDistributor());
            entyUpdate.setScore(dlc.getScore());
            entyUpdate.setPrice(dlc.getPrice());
            entyUpdate.setGenre(dlc.getGenre());
            entyUpdate.setRating(dlc.getRating());
            entyUpdate.setPlatform(dlc.getPlatform());
            entyUpdate.setMinimumRequirements(dlc.getMinimumRequirements());
            entyUpdate.setRecommendedRequirements(dlc.getRecommendedRequirements());

            repositoryDVR.save(entyUpdate);
        }
    }

    public void updateDLCConsole(DLCConsole dlc, Long id){

        Optional<DLCConsole> enty = repositoryDConsole.findById(id);

        if(enty.isPresent()){

            DLCConsole entyUpdate = enty.get();

            entyUpdate.setOwnedGame(dlc.getOwnedGame());
            entyUpdate.setName(dlc.getName());
            entyUpdate.setReleaseDate(dlc.getReleaseDate());
            entyUpdate.setDescription(dlc.getDescription());
            entyUpdate.setDeveloper(dlc.getDeveloper());
            entyUpdate.setPeopleInvolved(dlc.getPeopleInvolved());
            entyUpdate.setSoldCopies(dlc.getSoldCopies());
            entyUpdate.setDistributor(dlc.getDistributor());
            entyUpdate.setScore(dlc.getScore());
            entyUpdate.setPrice(dlc.getPrice());
            entyUpdate.setGenre(dlc.getGenre());
            entyUpdate.setRating(dlc.getRating());
            entyUpdate.setPlatform(dlc.getPlatform());
            entyUpdate.setStorage(dlc.getStorage());

            repositoryDConsole.save(entyUpdate);
        }
    }
}