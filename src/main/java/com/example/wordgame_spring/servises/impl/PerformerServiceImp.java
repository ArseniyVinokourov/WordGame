package com.example.wordgame_spring.servises.impl;


import com.example.wordgame_spring.entities.Player;
import com.example.wordgame_spring.servises.*;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Scanner;

@Service
public class PerformerServiceImp implements PerformerService {

    private final PlayerService playerService;
    private final WordCheckService wordCheckService;
    private final DictionaryService dictionaryService;

    @Autowired
    public PerformerServiceImp(PlayerService playerService, WordCheckService wordCheckService, DictionaryService dictionaryService) {
        this.playerService = playerService;
        this.wordCheckService = wordCheckService;
        this.dictionaryService = dictionaryService;
    }


    @Override
    public void performWordGame() {
        System.out.println("\n\tWelcome to WordGame");
        boolean isExit = false;
        int scoreCounter;
        while (!isExit) {
            HashSet<String> dictionaryHashSet = dictionaryService.getDictionary();
            scoreCounter = 0;
            while (Boolean.TRUE.equals(wordCheckService.checkVerifiableWord(InputServiceImp.inputWordByUser("Input word: "), dictionaryHashSet))) {
                scoreCounter += 1;
            }
            System.out.println("Your score is: " + scoreCounter);
            StringBuilder nickname;
            while (true) {
                System.out.print("Enter your nickname: ");
                Scanner in = new Scanner(CloseShieldInputStream.wrap(System.in));
                nickname = new StringBuilder(in.nextLine());
                in.close();
                int nicknameLength = nickname.length();
                if (nicknameLength > 15) {
                    System.out.println("Too long nickname (max 15 symbols)\n");
                } else {
                    if (nicknameLength < 15){
                        nickname.append(" ".repeat(Math.max(0, 15 - nicknameLength)));
                    }
                    break;
                }
            }
            Player player = new Player(nickname.toString(), scoreCounter);
            playerService.save(player);
            int choice = callMainMenu();
            while (choice == 2) {
                playerService.printLeaderTable();
                choice = callMainMenu();
            }
            if (choice == 0) {
                isExit = true;
            }
        }
        System.exit(0);
    }

    private static int callMainMenu() {
        System.out.print("\nMain menu:" +
                "\n1)New Game" +
                "\n2)Leader table" +
                "\n0)Exit\n\n");
        Scanner in2 = new Scanner(CloseShieldInputStream.wrap(System.in));
        int choice = in2.nextInt();
        in2.close();
        return choice;
    }
}
