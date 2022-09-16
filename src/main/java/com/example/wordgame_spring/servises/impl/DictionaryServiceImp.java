package com.example.wordgame_spring.servises.impl;

import com.example.wordgame_spring.servises.DictionaryService;
import org.apache.commons.collections4.SetUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

@Service
public class DictionaryServiceImp implements DictionaryService {

    private static final String DICTIONARY_PATH = "src/main/resources/dictionary.txt";


    @Override
    public HashSet<String> getDictionary() {
        StringBuilder dictionaryStr = new StringBuilder();
        try (Scanner dictionaryScanner = new Scanner(new File(DICTIONARY_PATH))) {
            while (dictionaryScanner.hasNext()) {
                dictionaryStr.append(dictionaryScanner.nextLine());
            }
        } catch (Exception e) {
            try {
                throw new FileNotFoundException(String.format("file with path %s not found :(", DICTIONARY_PATH));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

        return SetUtils.hashSet(dictionaryStr.toString().split(" "));
    }
}
