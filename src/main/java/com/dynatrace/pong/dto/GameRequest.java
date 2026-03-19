package com.dynatrace.pong.dto;

import jakarta.validation.constraints.NotNull;

public record GameRequest(
        @NotNull(message = "First player should not be null")
        Long firstPlayer,

        @NotNull(message = "Second player should not be null")
        Long secondPlayer
) {
}
