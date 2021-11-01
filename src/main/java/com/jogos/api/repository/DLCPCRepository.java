package com.jogos.api.repository;

import com.jogos.api.model.DlcPC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DLCPCRepository extends JpaRepository<DlcPC, Long> {

    List<DlcPC> findByOwnedGame(String ownedGame);

}
