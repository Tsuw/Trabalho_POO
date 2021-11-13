package com.jogos.api.repository;

import com.jogos.api.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByPlatform(String platform);

    @Query(value = "select g from Game g where g.platform not in ('PC', 'VR')")
    List<Game> findAllByConsole();

    Optional<Game> findGameByNameAndPlatform(String name, String platform);

    boolean existsByNameAndPlatform(String name, String platform);
}
