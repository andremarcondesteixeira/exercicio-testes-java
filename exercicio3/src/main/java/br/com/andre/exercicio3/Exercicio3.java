package br.com.andre.exercicio3;

import br.com.andre.exercicio1.Multiples;
import br.com.andre.exercicio2.business.HappyNumberVerifier;

public class Exercicio3 {
    public static void main(String[] args) {
        String[] words = new String[] { "André", "Marcondes", "Teixeira", "Objective", "Solutions" };
        for (String word : words) {
            System.out.println(word);
            showCalculations(new Word(word));
        }
    }

    private static void showCalculations(Word word) {
        long value = word.value();
        System.out.println("Valor: " + value);
        System.out.println("Valor é primo: " + PrimeChecker.check(value));
        boolean isHappyNumber = new HappyNumberVerifier().verify(value).isHappy();
        System.out.println("Valor é número feliz: " + isHappyNumber);
        boolean isMultiple = new Multiples().ofAny(new long[] { 3, 5 }).isMultiple(value);
        System.out.println("Valor é múltiplo de 3 ou 5: " + isMultiple);
        System.out.println("");
    }
}