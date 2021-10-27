package com.jogos.api.service;

import com.jogos.api.dto.DLCDTO;
import com.jogos.api.dto.DLCPCDTO;
import com.jogos.api.model.*;
import com.jogos.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class DLCService {

    @Autowired
    private DLCRepository repo;

    @Autowired
    private GamePCRepository grepo;

    @Autowired
    private DLCPCRepository repositoryDPC;

    @Autowired
    private GamePCRepository repositoryPC;

    @Autowired
    private GameVRRepository repositoryVR;

    @Autowired
    private GameConsole1Repository repositoryConsole;

    public List<DLCDTO> getDLC(String ownedGameName) {

        List<DLCDTO> list = new ArrayList<>();
        List<DLCEntity> DLCList = repo.findByOwnedGame(ownedGameName);

        for (int i = 0; i < DLCList.size(); i++) {

            DLCEntity enty = DLCList.get(i);
            DLCDTO DTO = new DLCDTO();

            DTO.setId(enty.getId());
            DTO.setOwnedGame(enty.getOwnedGame());
            DTO.setName(enty.getName());
            DTO.setReleaseDate(enty.getReleaseDate());
            DTO.setDescription(enty.getDescription());
            DTO.setDeveloper(enty.getDeveloper());
            DTO.setDistributor(enty.getDistributor());
            DTO.setScore(enty.getScore());
            DTO.setPrice(enty.getPrice());
            DTO.setGenre(enty.getGenre());
            DTO.setRating(enty.getRating());

            list.add(DTO);

        }
        return list;
    }

    public List<DLCPCDTO> getDLCPC(String ownedGameName){

        List<DLCPCDTO> list = new ArrayList<>();
        List<DLCPC> listDLC = repositoryDPC.findByOwnedGame(ownedGameName);

        for(int i = 0; i < listDLC.size(); i++){

            DLCPC enty = listDLC.get(i);
            DLCPCDTO dto = new DLCPCDTO();

            dto.setId(enty.getId());
            dto.setOwnedGame(enty.getOwnedGame());
            dto.setName(enty.getName());
            dto.setReleaseDate(enty.getReleaseDate());
            dto.setDescription(enty.getDescription());
            dto.setDeveloper(enty.getDeveloper());
            dto.setDistributor(enty.getDistributor());
            dto.setScore(enty.getScore());
            dto.setPrice(enty.getPrice());
            dto.setGenre(enty.getGenre());
            dto.setRating(enty.getRating());
            dto.setPlatform(enty.getPlatform());
            dto.setMinimumRequirements(enty.getMinimumRequirements());

            list.add(dto);
        }

        return list;
    }

    public int NameConferer(String ownedGame, String platform){

        if(platform.equals("PC") || platform.equals("pc")){
            Optional<GamePC> gamePC = repositoryPC.findByName(ownedGame);

            if(gamePC.get().isHasDLC() == false){
                return 1;
            } else return 0;

        }else if(platform.equals("VR") || platform.equals("vr")){
            Optional<GameVR> gameVR = repositoryVR.findByName(ownedGame);

            if(gameVR.get().isHasDLC() == false){
                return 1;
            }else return 0;

        }else{
            Optional<GameConsole> gameConsole = repositoryConsole.findByName(ownedGame);

            if(gameConsole.get().isHasDLC() == false){
                return 1;
            }else return 0;
        }
    }

    public boolean IDExists(Long ID) {

        return repo.existsById(ID);
    }

    public void update(DLCEntity DLC, Long id) {

        Optional<DLCEntity> enty = repo.findById(id);

        if (enty.isPresent()) {

            DLCEntity enty_update = enty.get();

            enty_update.setOwnedGame(DLC.getOwnedGame());
            enty_update.setName(DLC.getName());
            enty_update.setReleaseDate(DLC.getReleaseDate());
            enty_update.setDescription(DLC.getDescription());
            enty_update.setDeveloper(DLC.getDeveloper());
            enty_update.setPeopleInvolved(DLC.getPeopleInvolved());
            enty_update.setSoldCopies(DLC.getSoldCopies());
            enty_update.setDistributor(DLC.getDistributor());
            enty_update.setScore(DLC.getScore());
            enty_update.setPrice(DLC.getPrice());
            enty_update.setGenre(DLC.getGenre());
            enty_update.setRating(DLC.getRating());

            repo.save(enty_update);
        }

    }

}
