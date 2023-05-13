package com.nathalia.dslist.services.impl;

import com.nathalia.dslist.dto.GameListDto;
import com.nathalia.dslist.entities.GameList;
import com.nathalia.dslist.exceptions.GameNotFoundException;
import com.nathalia.dslist.projections.GameMinDtoProjection;
import com.nathalia.dslist.repositories.GameListRepository;
import com.nathalia.dslist.repositories.GameRepository;
import com.nathalia.dslist.services.GameListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListServiceImpl implements GameListService {
    private final GameListRepository repository;
    private final GameServiceImpl gameService;
    private final GameRepository gameRepository;

    @Autowired
    public GameListServiceImpl(GameListRepository repository, GameServiceImpl gameService, GameRepository gameRepository) {
        this.repository = repository;
        this.gameService = gameService;
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public GameListDto findById(Long id) {
        return repository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Transactional
    public List<GameMinDtoProjection> move(Long listId, Integer initialIndex, Integer destinationIndex) {
        return null;
    }

    public GameListDto convertToDto(GameList gameList) {
        return new ModelMapper().map(gameList, GameListDto.class);
    }
}
