package com.example.wordgame_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Write a word game I.e. there is a list of words the program reads from a file,
// there is a base word ("areallylongword") to enter such a word that it was in the list,
// and the letters and the number present in the base write the input process, the leader
// table, the calculation of points, methods of getting the word in a particular position.

@SpringBootApplication
public class WordGameSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(WordGameSpringApplication.class, args);
    }
}
