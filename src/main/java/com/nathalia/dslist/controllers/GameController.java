package com.nathalia.dslist.controllers;

import com.nathalia.dslist.dto.GameDto;
import com.nathalia.dslist.dto.GameMinDto;
import com.nathalia.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public GameDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<GameMinDto> findAll() {
        return service.findAll();
    }
}
