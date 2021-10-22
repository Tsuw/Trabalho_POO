package com.jogos.api.repository;

import com.jogos.api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//CRUD= Create, Read, Update, Delete (tudo da user entity)
//ganha métodos para fazer o banco de dados (escreve o sql automaticamente)
//ler documentação do spring
//abstract porque não tem todas as informações necessárias para ser classificada como objeto(não pode ter objeto)
//interface é uma classe 100% abstrata
    /*
    Referencia Spring Data:
        https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> { //herança

    Optional<UserEntity> findByEmailIgnoreCase(String email);
    Optional<List<UserEntity>> findByNameContaining(String name);


}
