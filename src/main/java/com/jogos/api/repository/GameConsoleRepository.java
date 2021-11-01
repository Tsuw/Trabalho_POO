package com.jogos.api.repository;

import com.jogos.api.model.GameConsole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameConsoleRepository extends JpaRepository<GameConsole, Long>{

    Boolean existsByName(String name);
}
