package com.jogos.api.repository;

import com.jogos.api.model.DLCPC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DLCPCRepository extends JpaRepository<DLCPC, Long> {

    List<DLCPC> findByOwnedGame(String ownedGame);

}
