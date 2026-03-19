package com.dynatrace.pong.exception;

public class EqualScoreException extends RuntimeException {

    public EqualScoreException(Long id) {
        super("Game cannot end with the same score '" + id);
    }
}