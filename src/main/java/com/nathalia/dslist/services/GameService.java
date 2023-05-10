package com.nathalia.dslist.services;

import com.nathalia.dslist.dto.GameDto;
import com.nathalia.dslist.dto.GameMinDto;
import com.nathalia.dslist.entities.Game;
import com.nathalia.dslist.exceptions.GameNotFoundException;
import com.nathalia.dslist.projections.GameMinDtoProjection;
import com.nathalia.dslist.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
@AllArgsConstructor
public class GameService {
    private GameRepository repository;
    private GameMinDto gameDto;

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

    /**
     * @param game
     * @return GameDto
     * @implNote Use this method when requesting a single game
     */
    private GameDto convertEntityToDto(Game game) {
        return new ModelMapper().map(game, GameDto.class);
    }

    /**
     * @param game
     * @return GameMinDto
     * @implNote Use this method when requesting a list of games
     */
    private GameMinDto convertEntityToMinDto(Game game) {
        return new ModelMapper().map(game, GameMinDto.class);
    }

    private GameMinDto convertProjectionToMinDto(GameMinDtoProjection gameProjection) {
        return new GameMinDto(gameProjection);
    }
}
