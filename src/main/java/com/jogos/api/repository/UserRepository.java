package com.jogos.api.repository;

import com.jogos.api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> { //herança

    Optional<UserEntity> findByEmailIgnoreCase(String email);
}
