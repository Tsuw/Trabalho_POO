package com.jogos.api.repository;

import com.jogos.api.model.DlcVR;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DLCVRRepository extends JpaRepository<DlcVR, Long> {

    List<DlcVR> findByOwnedGame(String ownedGame);

}
