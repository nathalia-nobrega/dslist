package com.nathalia.dslist.services;

import com.nathalia.dslist.dto.GameMinDto;
import com.nathalia.dslist.entities.Game;
import com.nathalia.dslist.exceptions.GameNotFoundException;
import com.nathalia.dslist.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@AllArgsConstructor
public class GameService {
    private GameRepository repository;
    private GameMinDto gameDto;

    public GameMinDto findById(Long id) throws GameNotFoundException {
        return repository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    public List<GameMinDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    private GameMinDto convertToDto(Game game) {
        return new ModelMapper().map(game, GameMinDto.class);
    }
}
