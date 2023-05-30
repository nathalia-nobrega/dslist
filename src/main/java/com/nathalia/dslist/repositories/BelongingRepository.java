package com.nathalia.dslist.repositories;

import com.nathalia.dslist.model.Belonging;
import com.nathalia.dslist.model.BelongingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BelongingRepository extends JpaRepository<Belonging, BelongingId> {
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO TB_BELONGING VALUES (:position, :listId, :gameId)")
    Integer save(@Param("position") Integer position, @Param("listId") Long listId, @Param("gameId") Long gameId);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM TB_BELONGING WHERE GAME_ID = :gameId")
    Integer deleteByGameId(@Param("gameId") Long gameId);
}
