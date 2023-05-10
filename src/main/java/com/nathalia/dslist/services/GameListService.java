package com.nathalia.dslist.services;

import com.nathalia.dslist.dto.GameDto;
import com.nathalia.dslist.dto.GameListDto;
import com.nathalia.dslist.dto.GameMinDto;
import com.nathalia.dslist.entities.Game;
import com.nathalia.dslist.entities.GameList;
import com.nathalia.dslist.exceptions.GameNotFoundException;
import com.nathalia.dslist.repositories.GameListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Component
public class GameListService {

    private final GameListRepository repository;

    public GameListService(GameListRepository repository) {
        this.repository = repository;
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

    private GameListDto convertToDto(GameList gameList) {
        return new ModelMapper().map(gameList, GameListDto.class);
    }

}
