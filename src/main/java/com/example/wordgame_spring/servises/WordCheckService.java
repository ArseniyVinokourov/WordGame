package com.example.wordgame_spring.servises;

import java.util.List;
import java.util.Set;

public interface WordCheckService {

    Boolean checkVerifiableWord(String verifiableWord, Set<String> dictionary);

    Boolean doKeyWordCheck(String verifiableWord);

    Boolean doDictionaryCheck(String verifiableWord, Set<String> dictionary);

    List<Character> transformStringToCharacterList(String str);

}
