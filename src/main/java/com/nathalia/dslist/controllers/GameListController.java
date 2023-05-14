package com.nathalia.dslist.controllers;

import com.nathalia.dslist.dto.GameListDto;
import com.nathalia.dslist.dto.GameMinDto;
import com.nathalia.dslist.dto.ReplacementDto;
import com.nathalia.dslist.services.impl.GameListServiceImpl;
import com.nathalia.dslist.services.impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class GameListController {

    private final GameListServiceImpl gameListService;
    private final GameServiceImpl gameService;

    @Autowired
    public GameListController(GameListServiceImpl gameListService, GameServiceImpl gameService) {
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

    @PutMapping(value = "/{id}/games/replacement")
    public Integer move(@PathVariable Long id, @RequestBody ReplacementDto body) {
        return gameListService.move(id, body.getSourceIndex(), body.getDestinationIndex());
    }


}
