package com.nathalia.dslist.services.impl;

import com.nathalia.dslist.dto.GameDto;
import com.nathalia.dslist.dto.GameMinDto;
import com.nathalia.dslist.model.Game;
import com.nathalia.dslist.exceptions.GameNotFoundException;
import com.nathalia.dslist.projections.GameMinDtoProjection;
import com.nathalia.dslist.repositories.GameRepository;
import com.nathalia.dslist.services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    public GameRepository repository;
    public GameMinDto gameDto;

    @Autowired
    public GameServiceImpl(GameRepository repository, GameMinDto gameDto) {
        this.repository = repository;
        this.gameDto = gameDto;
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id) throws GameNotFoundException {
        return repository.findById(id)
                .map(this::convertEntityToDto)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertEntityToMinDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findGameByList(Long listId) {
        return repository.findGameByList(listId)
                .stream()
                .map(this::convertProjectionToMinDto)
                .toList();
    }

    public GameDto convertEntityToDto(Game game) {
        return new ModelMapper().map(game, GameDto.class);
    }

    public Game convertDtoToEntity(GameDto gameDto) {
        return new ModelMapper().map(gameDto, Game.class);
    }

    public GameMinDto convertEntityToMinDto(Game game) {
        return new ModelMapper().map(game, GameMinDto.class);
    }

    public GameMinDto convertDtoToMinDto(GameDto gameDto) {
        return new ModelMapper().map(gameDto, GameMinDto.class);
    }

    public GameMinDto convertProjectionToMinDto(GameMinDtoProjection gameProjection) {
        return new GameMinDto(gameProjection);
    }
}
