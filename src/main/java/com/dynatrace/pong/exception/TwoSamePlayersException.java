package com.dynatrace.pong.exception;

public class TwoSamePlayersException extends RuntimeException {

    public TwoSamePlayersException(Long id) {
        super("Player cannot play against himself " + id);
    }
}
