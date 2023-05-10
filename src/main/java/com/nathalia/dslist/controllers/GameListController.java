package com.nathalia.dslist.controllers;

import com.nathalia.dslist.dto.GameListDto;
import com.nathalia.dslist.services.GameListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class GameListController {

    private final GameListService service;

    public GameListController(GameListService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public GameListDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<GameListDto> findAll() {
        return service.findAll();
    }

}
