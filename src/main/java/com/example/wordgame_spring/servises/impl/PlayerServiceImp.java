package com.example.wordgame_spring.servises.impl;

import com.example.wordgame_spring.entities.Player;
import com.example.wordgame_spring.repositories.PlayerRepository;
import com.example.wordgame_spring.servises.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerServiceImp implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImp(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @Override
    public void printLeaderTable(){
        List<Player> players = this.gatAllPlayers();
        players.sort((p1, p2) -> p2.getScore() - p1.getScore());
        printHead();
        players.forEach(player -> System.out.println(player.toString()));
    }

    @Override
    public List<Player> gatAllPlayers(){
        return playerRepository.findAll();
    }

    @Override
    public void save(final Player player) {
        playerRepository.save(player);
    }

    public void printHead(){
        System.out.println("\n Nickname\t\t\t| Score\n" +
                "____________________|________");
    }
}
