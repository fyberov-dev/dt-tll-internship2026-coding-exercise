package com.dynatrace.pong.dto;

import lombok.Builder;

@Builder
public record GameResponse(
        Long id,
        Long firstPlayer,
        Long secondPlayer,
        Long winner
) {
}
