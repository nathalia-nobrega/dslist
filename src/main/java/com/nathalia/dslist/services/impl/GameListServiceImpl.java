package com.nathalia.dslist.services.impl;

import com.nathalia.dslist.dto.GameListDto;
import com.nathalia.dslist.entities.GameList;
import com.nathalia.dslist.exceptions.GameNotFoundException;
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
    private final GameRepository gameRepository;
    private final BelongingServiceImpl belongingService;

    @Autowired
    public GameListServiceImpl(GameListRepository repository, GameServiceImpl gameService, GameRepository gameRepository, BelongingServiceImpl belongingService) {
        this.repository = repository;
        this.gameRepository = gameRepository;
        this.belongingService = belongingService;
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
    public Integer move(Long listId, Integer initialIndex, Integer destinationIndex) {
        // get the id for each of the games (the one to be moved and the one that is in the destinationIndex)
        Long sourceGameId = gameRepository.findGameByList(2L).get(initialIndex).getId();
        Long destinationGameId = gameRepository.findGameByList(2L).get(destinationIndex).getId();

        // delete them from belonging table
        this.belongingService.deleteByGameId(sourceGameId);
        this.belongingService.deleteByGameId(destinationGameId);

        // insert them back with the swapped indexes
        this.belongingService.save(destinationIndex, listId, sourceGameId);
        this.belongingService.save(initialIndex, listId, destinationGameId);

        return 0;
    }

    public GameListDto convertToDto(GameList gameList) {
        return new ModelMapper().map(gameList, GameListDto.class);
    }
}
