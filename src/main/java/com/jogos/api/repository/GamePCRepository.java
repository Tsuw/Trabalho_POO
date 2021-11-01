package com.jogos.api.repository;

import com.jogos.api.model.GamePC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamePCRepository extends JpaRepository<GamePC, Long> {

    Boolean existsByName(String name);

}
