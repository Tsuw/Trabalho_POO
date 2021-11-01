package com.jogos.api.repository;

import com.jogos.api.model.GameVR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameVRRepository extends JpaRepository<GameVR, Long> {

    Boolean existsByName(String name);

}
