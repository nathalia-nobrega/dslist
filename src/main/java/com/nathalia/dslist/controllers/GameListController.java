package com.nathalia.dslist.controllers;

import com.nathalia.dslist.dto.GameListDto;
import com.nathalia.dslist.dto.GameMinDto;
import com.nathalia.dslist.services.GameListService;
import com.nathalia.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping("/{id}")
    public GameListDto findById(@PathVariable Long id) {
        return gameListService.findById(id);
    }

    @GetMapping("/{id}/games")
    public List<GameMinDto> findGameByList(@PathVariable Long id) {
        return gameService.findGameByList(id);
    }

    @GetMapping
    public List<GameListDto> findAll() {
        return gameListService.findAll();
    }

}
