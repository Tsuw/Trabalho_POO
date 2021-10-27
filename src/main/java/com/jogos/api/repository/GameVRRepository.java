package com.jogos.api.repository;

import com.jogos.api.model.GameVR;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameVRRepository extends JpaRepository<GameVR, Long> {

    Optional<GameVR> findByName(String name);

}
