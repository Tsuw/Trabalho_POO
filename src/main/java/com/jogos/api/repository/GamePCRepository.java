    package com.jogos.api.repository;

    import com.jogos.api.model.GamePC;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.Optional;

    public interface GamePCRepository extends JpaRepository<GamePC, Long> {

        Optional<GamePC> findByName(String name);
    }
