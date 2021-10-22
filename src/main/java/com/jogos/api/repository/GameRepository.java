    package com.jogos.api.repository;

    import com.jogos.api.model.GameEntity;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.Optional;

    public interface GameRepository extends JpaRepository<GameEntity, Long> {

        Optional<GameEntity> findByName(String name);
    }
