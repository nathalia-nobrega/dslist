package com.nathalia.dslist.repositories;

import com.nathalia.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GameRepository extends JpaRepository<Game, Long> {
}
