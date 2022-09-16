package com.example.wordgame_spring.servises.impl;

import com.example.wordgame_spring.servises.WordCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WordCheckServiceImp implements WordCheckService {

    private final String KEY_WORD = "areallylongword";


    @Override
    public Boolean checkVerifiableWord(String verifiableWord, Set<String> dictionary) {
        return (doKeyWordCheck(verifiableWord) && doDictionaryCheck(verifiableWord, dictionary));
    }

    @Override
    public Boolean doKeyWordCheck(String verifiableWord) {
        List<Character> keyWordCharList = transformStringToCharacterList(KEY_WORD);
        List<Character> verifiableWordCharList = transformStringToCharacterList(verifiableWord);
        for (Character currentCh : verifiableWordCharList) {
            if (keyWordCharList.contains(currentCh)) {
                keyWordCharList.remove(currentCh);
            } else {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean doDictionaryCheck(String verifiableWord, Set<String> dictionary){
        return dictionary.remove(verifiableWord);
    }

    @Override
    public List<Character> transformStringToCharacterList(String str) {
        List<Character> characterList = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            characterList.add(ch);
        }
        return characterList;
    }
}
