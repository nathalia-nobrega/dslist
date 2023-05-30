package com.nathalia.dslist.services;

import com.nathalia.dslist.dto.GameListDto;
import com.nathalia.dslist.model.GameList;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GameListService {
    @Transactional(readOnly = true)
    GameListDto findById(Long id);

    @Transactional(readOnly = true)
    List<GameListDto> findAll();

    GameListDto convertToDto(GameList gameList);

}
