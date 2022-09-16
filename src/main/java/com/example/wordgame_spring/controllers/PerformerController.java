package com.example.wordgame_spring.controllers;

import com.example.wordgame_spring.servises.PerformerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class PerformerController {

    private final PerformerService performerService;

    @GetMapping("/start")
    public String getUserById() {
        performerService.performWordGame();
        return "______The end______";
    }
}
