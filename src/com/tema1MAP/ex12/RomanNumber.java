package com.tema1MAP.ex12;

import java.util.HashMap;
import java.util.Map;

public class RomanNumber {
    private String value;
    private final Map<Character, Integer> bindings = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    //Constructor implicit
    public RomanNumber() {
        this.value = "";
    }

    //Constructor de initializare
    public RomanNumber(String value) {
        String contents = "IVXLCDM";
        for (int i = 0; i < value.length(); i++)
            if (contents.indexOf(value.charAt(i)) != -1)
                continue;
            else {
                value = " ";
                System.out.println("Nu s-a introdus o valoare conforma cu nomenclatura romana de scriere a numerelor!");
                break;
            }
        this.value = value;
    }

    //Converteste un numar scris cu cifre romane intr-unul scris cu cifre arabe
    public int fromRomanToArabic() {

        RomanNumber rn = this;
        int sum = 0;
        try {
            int size = rn.value.length();

            //Daca valoarea curenta este mai mica decat urmatoarea, scadem valoarea curenta (caracterul, cu binding-ul in arabic) din urmatoarea si rezultatul din variabila sum
            for (int i = 0; i < size; i++) {
                if (i != size - 1 && bindings.get(rn.value.charAt(i)) < bindings.get(rn.value.charAt(i + 1))) {
                    sum += bindings.get(rn.value.charAt(i + 1)) - bindings.get(rn.value.charAt(i));
                    i++;
                } else {
                    sum += bindings.get(rn.value.charAt(i));
                }
            }
        } catch (NullPointerException npex) {
            System.out.println("Valoarea introdusa in cifre romane nu este valida! Conversia va esua!");
        }
        return sum;
    }

    //Afiseaza numarul in cifre romane
    public void displayAsRomanNumber() {
        System.out.println("Valoarea exprimata in notatia romana: " + value);
    }

    //Afiseaza numarul cu cifre arabe
    public void displayAsArabic() {
        System.out.println("Valoarea exprimata in notatia araba: " + this.fromRomanToArabic());
    }

}

