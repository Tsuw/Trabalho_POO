package com.jogos.api.repository;

import com.jogos.api.model.DLCConsole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DLCConsoleRepository extends JpaRepository<DLCConsole, Long> {

    List<DLCConsole> findByOwnedGame(String ownedGame);

}
