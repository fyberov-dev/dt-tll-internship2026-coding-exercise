package com.dynatrace.pong.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long firstPlayer;

    @Column(nullable = false)
    private Long secondPlayer;

    @Column(nullable = false)
    private int firstPlayerScore = 0;

    @Column(nullable = false)
    private int secondPlayerScore = 0;

    @Column(nullable = true)
    private Long winner = null;

    public Game() {
    }

    public Game(Long firstPlayer, Long secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Long getId() {
        return id;
    }

    public Long getFirstPlayer() {
        return firstPlayer;
    }

    public Long getSecondPlayer() {
        return secondPlayer;
    }

    public int getFirstPlayerScore() {
        return firstPlayerScore;
    }

    public int getSecondPlayerScore() {
        return secondPlayerScore;
    }

    public Long getWinner() {
        return winner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstPlayer(Long firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(Long secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public void setFirstPlayerScore(int firstPlayerScore) {
        this.firstPlayerScore = firstPlayerScore;
    }

    public void setSecondPlayerScore(int secondPlayerScore) {
        this.secondPlayerScore = secondPlayerScore;
    }

    public void setWinner(Long winner) {
        this.winner = winner;
    }
}
