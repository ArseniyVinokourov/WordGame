package com.example.wordgame_spring.servises;

import org.apache.commons.io.input.CloseShieldInputStream;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service
public class InputServiceImp {

    public static String inputWordByUser(String massage) {
        if (!massage.isEmpty()) {
            System.out.print(massage);
        }
        Scanner in = new Scanner(CloseShieldInputStream.wrap(System.in));
        String word = in.nextLine();
        in.close();
        return word.toLowerCase(Locale.ENGLISH);
    }
}
