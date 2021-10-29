package com.jogos.api.repository;

import com.jogos.api.model.GameConsole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameConsoleRepository extends JpaRepository<GameConsole, Long>{

    Optional<GameConsole> findByName(String name);
    Boolean existsByName(String name);

}
