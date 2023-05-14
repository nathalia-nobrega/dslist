package com.nathalia.dslist.services.impl;

import com.nathalia.dslist.repositories.BelongingRepository;
import com.nathalia.dslist.services.BelongingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BelongingServiceImpl implements BelongingService {

    private BelongingRepository repository;

    @Autowired
    public BelongingServiceImpl(BelongingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Integer save(Integer position, Long listId, Long gameId) {
        return repository.save(position, listId, gameId);
    }

    @Override
    public Integer deleteByGameId(Long gameId) {
        return repository.deleteByGameId(gameId);
    }
}
