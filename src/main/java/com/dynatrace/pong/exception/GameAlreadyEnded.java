package com.dynatrace.pong.exception;

public class GameAlreadyEnded extends RuntimeException {

    public GameAlreadyEnded(Long id) {
        super("Game already ended: " + id);
    }
}