package com.tema1MAP.ex10;

import java.util.Objects;

//Clasa BigNumber, modeleaza conceptul de numar natural foarte mare, cat si posibilele operatii aritmetice elementare ce pot avea loc pe aceste structuri matematice.
public class BigNumber {
    protected String value;
    public static final String MAX_VALUE = "123456789123456789123456789";
    public static final String MIN_VALUE = "-123456789123456789123456789";
    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final String MILLION = "1000000";
    public static final String NAN = "";


    //Constructor de initializare
    public BigNumber(String value) {
        this.value = value;
    }

    //Constructor implicit
    public BigNumber() {
        this.value = BigNumber.ZERO;
    }

    //Constructor de copiere
    public BigNumber(BigNumber copy) {
        this.value = copy.value;
    }

    //Aduna 2 numere mari
    //@TODO:Adunarea numerelor mari negative
    public BigNumber add(BigNumber n2) {

        //Daca al doilea termen al sumei este 0, returnam valoarea stocata in obiectul curent
        if (n2.value.equals("0"))
            return new BigNumber(this.value);

        //Verificam care numar este mai mare
        if (this.value.length() > n2.value.length()) {
            String t = this.value;
            this.value = n2.value;
            n2.value = t;
        }

        //Variabila-rezultat
        BigNumber result = new BigNumber(BigNumber.NAN);

        //Dimensiuni termeni suma
        int n1Size = this.value.length(), n2Size = n2.value.length();

        //Inversam ambele numere
        this.value = new StringBuilder(this.value).reverse().toString();
        n2.value = new StringBuilder(n2.value).reverse().toString();

        //Realizam ,,scolareste" operatia de adunare, tinand cont de carry (,,valoarea pe care o tinem minte")
        int carry = 0;
        for (int i = 0; i < n1Size; i++) {
            int sum = ((int) (this.value.charAt(i) - '0') + (int) (n2.value.charAt(i) - '0') + carry);
            result.value += (char) ((sum % 10) + '0');
            carry = sum / 10;
        }

        //Adunam restul numerelor ramase pentru suma, tinand cont de carry
        for (int i = n1Size; i < n2.value.length(); i++) {
            int sum = ((int) (n2.value.charAt(i) - '0') + carry);
            result.value += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        //Verificam carry
        if (carry > 0)
            result.value += (char) (carry + '0');

        //Folosind StringBuilder, facem reverse pe valoarea aferenta sumei rezultante
        result.value = new StringBuilder(result.value).reverse().toString();
        return result;
    }

    //Verifica egalitatea dintre 2 numere mari
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BigNumber bigNumber)) return false;
        return Objects.equals(value, bigNumber.value);
    }

    //Afiseaza valoarea numarului mare
    @Override
    public String toString() {
        return value;
    }

    //Realizeaza conversia numarului mare la tipul Long(daca se poate)
    public long toLong() {
        try {
            long value = Long.parseLong(this.value);
            return value;
        } catch (NumberFormatException nfe) {
            System.out.println("Nu se poate realiza conversia catre long!");
        }
        return 0;
    }

    //Compara 2 numere mari si returneaza true, in situatia in care primul este mai mic decat la al doilea si false, in caz contrar
    public boolean isSmallerThan(BigNumber bn) {
        int l1 = this.value.length(), l2 = bn.value.length();

        if (l1 < l2)
            return true;
        if (l2 < l1)
            return false;

        for (int i = 0; i < l1; i++)
            if (this.value.charAt(i) < bn.value.charAt(i))
                return true;
            else if (this.value.charAt(i) > bn.value.charAt(i))
                return false;

        return false;
    }

    //Calculeaza diferenta a 2 numere mari
    public BigNumber subtract(BigNumber n2) {

        //In situatia in care cel de-al doilea termen este chiar 0, se va returna obiectul curent
        if (n2.value.equals("0"))
            return this;

        //Obiectul de returnat
        BigNumber result = new BigNumber(BigNumber.NAN);

        //Variabila ce se va concatena numarului rezultat in urma scaderii (in cazul in care rezultatul este negativ, caracterul se va transforma din spatiu in minus)
        String minus = "";

        //Adunarea unui numar mai mic dintr-unul mai mare duce la aparitia unui rezultat negativ
        if (isSmallerThan(n2)) {
            String temp = this.value;
            this.value = n2.value;
            n2.value = temp;
            minus = "-";
        }

        //Lungimi strings
        int l1 = this.value.length(), l2 = n2.value.length();

        //Inversam sirurile de caractere ce contin cele 2 numere mari
        this.value = new StringBuilder(this.value).reverse().toString();
        n2.value = new StringBuilder(n2.value).reverse().toString();

        int carry = 0;

        //Reiteram pana la finalul sirului de caractere cu dimensiunea mai mica si realizam ,,scolareste" scaderea
        for (int i = 0; i < l2; i++) {
            int sub = ((this.value.charAt(i) - '0') - (n2.value.charAt(i) - '0') - carry);
            if (sub < 0) {
                sub += 10;
                carry = 1;
            } else
                carry = 0;
            result.value += (char) (sub + '0');
        }

        //Continuam scaderea cu restul cifrelor din numarul mai mare
        for (int i = l2; i < l1; i++) {
            int sub = ((this.value.charAt(i) - '0') - carry);

            if (sub < 0) {
                sub += 10;
                carry = 1;
            } else
                carry = 0;
            result.value += (char) (sub + '0');
        }

        //Adaugam minusul in situatia in care rezultatul este unul negativ si inversam sirul pentru a afisa rezultatul precis.
        result.value += minus;
        result.value = new StringBuilder(result.value).reverse().toString();
        //Eliminam primele zerouri de la inceputul numarului
        result.value = removeZeros(result.value);
        return result;
    }


    //Metoda privata utilizata de catre functia de scadere pentru eliminarea zerourilor ce pot aparea
    private String removeZeros(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && i == 0)
                continue;
            res += s.charAt(i);
        }
        return res;
    }

    //Inmulteste doua numere mari
    public BigNumber multiply(BigNumber factor) {

        //Inmultirea cu 0
        if (this.value.equals(BigNumber.ZERO) || factor.value.equals(BigNumber.ZERO))
            return new BigNumber(BigNumber.ZERO);

        //Posibilitatea inmultirii a cel putin unuia dintre factori cu 1
        if (this.value.equals(BigNumber.ONE))
            return factor;

        if (factor.value.equals(BigNumber.ONE))
            return this;

        //Caz general:
        int lenFact1 = this.value.length();
        int lenFact2 = factor.value.length();

        //Vom opta pentru o stocare initiala a rezultatului intr-un vector de intregi, in ordine inversa
        int[] result = new int[lenFact1 + lenFact1];

        //2 indecsi utilizati pentru a gasi pozitiile in rezultat
        int idx1 = 0, idx2 = 0;

        for (int i = lenFact1 - 1; i >= 0; i--) {
            int carry = 0;    //Valoarea de tinut minte
            int n1 = this.value.charAt(i) - '0';

            //Pentru shiftarea la dreapta a pozitiei dupa fiecare inmultire efectuata asupra valorilor din cel de-al doilea factor al produsului
            idx2 = 0;

            //Parcurgem al doilea numar de la dreapta inspre stanga
            for (int j = lenFact2 - 1; j >= 0; j--) {

                //Cifra curenta
                int n2 = factor.value.charAt(j) - '0';

                //Mutliplicam cu cifra curenta a primului numar si adaugam rezultatul la cel stocat anterior
                int sum = n1 * n2 + result[idx1 + idx2] + carry;

                //Facem update pe carry pentru urmatoarea iteratie
                carry = sum / 10;

                //Inmagazinam rezultatele
                result[idx1 + idx2] = sum % 10;

                idx2++;
            }

            //Stocam carry-ul in urmatoarea valoare
            if (carry > 0)
                result[idx1 + idx2] += carry;

            //Shiftam pozitia la stanga dupa fiecare inmultire cu un numar din primul numar mare
            idx1++;
        }

        int i = result.length - 1;
        //Ignoram 0-urile de la dreapta
        while (i >= 0 && result[i] == 0)
            i--;

        String stringRes = "";
        //Formatam rezultatul obtinut sub forma de string
        while (i >= 0) {
            stringRes += (result[i--]);
        }

        //Returnam valoarea obtinuta
        return new BigNumber(stringRes);

    }

    //Ridica numarul stocat in instanta curenta la puterea exponentului
    public BigNumber exp(BigNumber exponent) {

        //Daca exponentul este 0, rezultatul ridicarii la putere este 1
        if (exponent.value.equals(BigNumber.ZERO))
            return new BigNumber(BigNumber.ONE);

        //Daca exponentul este 1, rezultatul ridicarii la putere este chiar numarul in cauza
        if (exponent.value.equals(BigNumber.ONE))
            return this;

        //Tratam ridicarea la putere ca pe o impartire repetata
        BigNumber result = new BigNumber(BigNumber.ONE);
        for (int i = 1; i <= exponent.toLong(); i++)
            result = result.multiply(this);

        return result;
    }

    //Impartirea a doua numere mari
    public BigNumber divide(BigNumber divisor) throws ArithmeticException {

        //Impartirea la 0 va rezulta intr-o exceptie
        if (divisor.value.equals(BigNumber.ZERO))
            throw new ArithmeticException("Este absolut necesar ca impartitorul sa aiba o valoare diferita de 0!");

        //Impartirea la 1 va rezulta in returnearea deimpartituli
        if (divisor.value.equals(BigNumber.ONE))
            return this;

        //Vom folosi un StringBuilder pentru returnarea rezultatului, datorita valorilor mari ce pot rezulta in urma calculelor
        StringBuilder res = new StringBuilder();

        char[] dividend = this.value.toCharArray();

        //Initial, carry-ul (valoarea de ,,tinut minte") va fi egala cu 0
        long carry = 0;

        for (int i = 0; i < dividend.length; i++) {
            //Incepem diviziunea
            long x = carry * 10 + Character.getNumericValue(dividend[i]);

            //Appenduim la rezultat catul partial
            res.append(x / Long.parseLong(divisor.value));

            //Pregatim carry-ul pentru urmatoarea iteratie
            carry = x % divisor.toLong();

        }

        //Vom continua prin a elimina posibilele zero-uri ramase
        for (int i = 0; i < res.length(); i++)
            if (res.charAt(i) != '0')
                //Returnam rezultatul
                return new BigNumber(res.substring(i));

        //Impartirea esuseaza, se returneaza un string vid
        return new BigNumber(BigNumber.NAN);
    }
}

