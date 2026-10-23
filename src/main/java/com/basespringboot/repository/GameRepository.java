package com.basespringboot.repository;

public package com.basespringboot.repository;

import com.basespringboot.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
} {
    
}
