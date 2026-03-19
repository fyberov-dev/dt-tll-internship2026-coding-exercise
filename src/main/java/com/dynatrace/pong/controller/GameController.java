package com.dynatrace.pong.controller;

import java.util.List;
import com.dynatrace.pong.dto.EndGameRequest;
import com.dynatrace.pong.dto.GameRequest;
import com.dynatrace.pong.dto.GameResponse;
import com.dynatrace.pong.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<GameResponse> createGame(@Valid @RequestBody GameRequest request) {
        GameResponse response = gameService.createGame(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> getGameById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    @GetMapping
    public ResponseEntity<List<GameResponse>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @PostMapping("/{id}")
    public ResponseEntity<GameResponse> endGame(@PathVariable Long id, @Valid @RequestBody EndGameRequest request) {
        GameResponse response = gameService.endGame(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
