package com.jogos.api.repository;

import com.jogos.api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> { //herança

    Optional<UserEntity> findByEmailIgnoreCase(String email);
    Optional<List<UserEntity>> findByNameContaining(String name);


}
