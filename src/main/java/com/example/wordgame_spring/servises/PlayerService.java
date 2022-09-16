package com.example.wordgame_spring.servises;

import com.example.wordgame_spring.entities.Player;

import java.util.List;

public interface PlayerService {

    void printLeaderTable();

    List<Player> gatAllPlayers();

    void save(Player player);

}
