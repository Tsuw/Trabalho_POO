package com.jogos.api.service;

import com.jogos.api.dto.DLCConsoleDTO;
import com.jogos.api.dto.DLCPCDTO;
import com.jogos.api.dto.DLCVRDTO;
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
    private DLCPCRepository repositoryDPC;

    @Autowired
    private DLCVRRepository repositoryDVR;

    @Autowired
    private DLCConsoleRepository repositoryDConsole;

    public List<DLCPCDTO> getDLCPC(String ownedGameName){

        List<DLCPCDTO> list = new ArrayList<>();
        List<DLCPC> listDLC = repositoryDPC.findByOwnedGame(ownedGameName);

        for(int i = 0; i < listDLC.size(); i++){

            DLCPC enty = listDLC.get(i);
            DLCPCDTO dto = new DLCPCDTO();

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
            dto.setRecommendedRequirements(enty.getRecommendedRequirements());

            list.add(dto);
        }

        return list;
    }

    public List<DLCVRDTO> getDLCVR(String ownedGameName){

        List<DLCVRDTO> listGame = new ArrayList<>();
        List<DLCVR> listDLC = repositoryDVR.findByOwnedGame(ownedGameName);

        for(int i = 0; i < listDLC.size(); i ++){

            DLCVR enty = listDLC.get(i);
            DLCVRDTO dto = new DLCVRDTO();

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
            dto.setRecommendedRequirements(enty.getRecommendedRequirements());

            listGame.add(dto);
        }

        return listGame;
    }

    public List<DLCConsoleDTO> getDLCConsele(String ownedGameName){

        List<DLCConsoleDTO> listGame = new ArrayList<>();
        List<DLCConsole> listDLC = repositoryDConsole.findByOwnedGame(ownedGameName);

        for(int i = 0; i < listDLC.size(); i++){

            DLCConsole enty = listDLC.get(i);
            DLCConsoleDTO dto = new DLCConsoleDTO();

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
            dto.setStorage(enty.getStorage());

            listGame.add(dto);
        }

        return listGame;
    }

    public void updateDLCPC(DLCPC dlc, Long id){

        Optional<DLCPC> enty = repositoryDPC.findById(id);

        if(enty.isPresent()){

            DLCPC entyUpdate = enty.get();

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

    public void updateDLCVR(DLCVR dlc, Long id){

        Optional<DLCVR> enty = repositoryDVR.findById(id);

        if(enty.isPresent()){

            DLCVR entyUpdate = enty.get();

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
