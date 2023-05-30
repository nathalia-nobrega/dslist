package com.nathalia.dslist.repositories;

import com.nathalia.dslist.model.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GameListRepository extends JpaRepository<GameList, Long> {
}
