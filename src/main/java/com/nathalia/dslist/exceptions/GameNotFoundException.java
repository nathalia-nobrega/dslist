package com.nathalia.dslist.exceptions;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(Long id) {
        super("Game of ID "+id+" does not exist");
    }
}
