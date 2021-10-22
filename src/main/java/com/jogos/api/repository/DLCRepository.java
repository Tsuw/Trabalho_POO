    package com.jogos.api.repository;


    import com.jogos.api.model.DLCEntity;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.List;

    public interface DLCRepository extends JpaRepository<DLCEntity, Long> {

        List<DLCEntity> findByOwnedGame(String ownedGame);
    }
