package com.basespringboot.service;

import com.basespringboot.model.Game;
import com.basespringboot.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Optional<Game> updateGame(Long id, Game gameDetails) {
        return gameRepository.findById(id).map(existingGame -> {
            existingGame.setTitle(gameDetails.getTitle());
            existingGame.setGenre(gameDetails.getGenre());
            existingGame.setPrice(gameDetails.getPrice());
            return gameRepository.save(existingGame);
        });
    }

    public boolean deleteGame(Long id) {
        if (gameRepository.existsById(id)) {
            gameRepository.deleteById(id);
            return true;
        }
        return false;
    }
}