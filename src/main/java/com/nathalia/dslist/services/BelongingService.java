package com.nathalia.dslist.services;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public interface BelongingService {
    @Transactional
    Integer save(Integer position, Long listId, Long gameId);
    @Transactional
    Integer deleteByGameId(Long gameId);
}
