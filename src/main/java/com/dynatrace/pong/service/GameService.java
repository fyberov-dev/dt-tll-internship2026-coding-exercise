package com.dynatrace.pong.service;

import java.util.List;
import java.util.stream.Collectors;
import com.dynatrace.pong.dto.EndGameRequest;
import com.dynatrace.pong.dto.GameRequest;
import com.dynatrace.pong.dto.GameResponse;
import com.dynatrace.pong.dto.PlayerResponse;
import com.dynatrace.pong.exception.PlayerNotFoundException;
import com.dynatrace.pong.exception.TwoSamePlayersException;
import com.dynatrace.pong.model.Game;
import com.dynatrace.pong.model.Player;
import com.dynatrace.pong.repository.GameRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final PlayerService playerService;

    public GameService(GameRepository gameRepository, PlayerService playerService) {
        this.gameRepository = gameRepository;
        this.playerService = playerService;
    }

    @Transactional(readOnly = true)
    public GameResponse getGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
        return toResponse(game);
    }

    @Transactional(readOnly = true)
    public List<GameResponse> getAllGames() {
        List<Game> games = gameRepository.findAll();

        return games.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public GameResponse createGame(@Valid GameRequest request) {
        if (request.firstPlayer().equals(request.secondPlayer())) {
            throw new TwoSamePlayersException(request.firstPlayer());
        }

        PlayerResponse firstPlayerResponse = playerService.getPlayerById(request.firstPlayer());
        PlayerResponse secondPlayerResponse = playerService.getPlayerById(request.secondPlayer());

        Game game = gameRepository.save(new Game(firstPlayerResponse.getId(), secondPlayerResponse.getId()));

        return toResponse(game);
    }

    private GameResponse toResponse(Game game) {
        return new GameResponse(game.getId(), game.getFirstPlayer(), game.getSecondPlayer(), game.getWinner());
    }

    public GameResponse endGame(@Valid EndGameRequest request) {
        Game game = gameRepository.findById(request.)
                .orElseThrow(() -> new PlayerNotFoundException(id));

        game.setFirstPlayerScore(request.firstPlayerScore());
        game.setSecondPlayerScore(request.secondPlayerScore());
    }
}
