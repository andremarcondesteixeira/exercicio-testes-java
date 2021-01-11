package br.com.andre.exercicio3;

import br.com.andre.exercicio1.Multiples;
import br.com.andre.exercicio2.business.HappyNumberVerifier;

public class Exercicio3 {
	public static void main(String[] args) {
		String[] words = new String[] { "André", "Marcondes", "Teixeira" };
		for (String word : words) {
			System.out.println(word + ":");
			showCalculations(new Word(word));
		}
	}

	private static void showCalculations(Word word) {
		long value = word.value();
		System.out.println("Value: " + value);
		System.out.println("Value is prime: " + PrimeChecker.check(value));
		System.out.println("Value is happy number: " + new HappyNumberVerifier().verify(value));
		boolean isMultiple = new Multiples().ofAny(new long[] { 3, 5 }).isMultiple(value);
		System.out.println("Value if multiple of 3 or 5: " + isMultiple);
	}
}