package com.nathalia.dslist.repositories;

import com.nathalia.dslist.entities.Belonging;
import com.nathalia.dslist.entities.BelongingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BelongingRepository extends JpaRepository<Belonging, BelongingId> {
//    void save(Integer position, Long listId, Long gameId);
//    void deleteByGameId(Long gameId);
//    List<Belonging> updatePosition(Long listId, Integer initialIndex, Integer destinationIndex);
}
