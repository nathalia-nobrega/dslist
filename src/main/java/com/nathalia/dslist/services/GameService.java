package com.nathalia.dslist.services;

import com.nathalia.dslist.dto.GameDto;
import com.nathalia.dslist.dto.GameMinDto;
import com.nathalia.dslist.model.Game;
import com.nathalia.dslist.exceptions.GameNotFoundException;
import com.nathalia.dslist.projections.GameMinDtoProjection;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GameService {
    @Transactional(readOnly = true)
    GameDto findById(Long id) throws GameNotFoundException;

    @Transactional(readOnly = true)
    List<GameMinDto> findAll();

    @Transactional(readOnly = true)
    List<GameMinDto> findGameByList(Long listId);

    /**
     * @param game
     * @return GameDto
     * @implNote Use this method when requesting a single game
     */
    GameDto convertEntityToDto(Game game);

    /**
     * @param game
     * @return GameMinDto
     * @implNote Use this method when requesting a list of games
     */
    GameMinDto convertEntityToMinDto(Game game);

    /**
     * @param gameProjection
     * @return GameMinDto
     * @implNote Use this method when retrieving an entity projection from the Database
     */
    GameMinDto convertProjectionToMinDto(GameMinDtoProjection gameProjection);
}
