package com.tema1MAP.ex11;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    //Metoda responsabila de generarea permutarilor

    public static Set<String> readAndGeneratePermutations(String source) {
        //Vom stoca permutarile intr-un ArrayList
        Set<String> result = new HashSet<>();

        if (source == null)
            return null;

        //Conditia de oprire a recursivitatii
        if (source.length() == 0) {
            result.add("");
            return result;
        }

        //Obtine primul caracter
        char firstChar = source.charAt(0);

        //Obtine restul substring-ului
        String substr = source.substring(1);

        Set<String> perms = readAndGeneratePermutations(substr);

        //Accesam acum fiecare element din set-ul words si inseram permutarea in setul result
        assert perms != null;
        for (String it : perms) {

            for (int i = 0; i <= it.length(); i++) {
                result.add(it.substring(0, i) + firstChar + it.substring(i));
            }
        }
        return result;
    }

}

