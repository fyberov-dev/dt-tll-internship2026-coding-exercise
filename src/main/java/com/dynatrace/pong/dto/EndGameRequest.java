package com.dynatrace.pong.dto;

public record EndGameRequest(
        int firstPlayerScore,
        int secondPlayerScore
) {
}
