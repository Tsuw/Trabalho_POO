package com.jogos.api.repository;

import com.jogos.api.model.DLCVR;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DLCVRRepository extends JpaRepository<DLCVR, Long> {

    List<DLCVR> findByOwnedGame(String ownedGame);

}
