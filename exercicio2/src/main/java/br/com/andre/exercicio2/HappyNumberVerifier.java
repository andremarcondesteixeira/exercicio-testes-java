package br.com.andre.exercicio2;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class HappyNumberVerifier {
	private @Getter int number;
	private @Getter List<Integer> digits;
	private @Getter int sumOfSquares;

	public HappyNumberVerifier(int n) {
		number = n;
		digits = new ArrayList<Integer>();
	}

	public void extractDigits() {
		while (number >= 1) {
			digits.add(number % 10);
			number /= 10;
		}
	}

	public void sumSquares() {
		sumOfSquares = digits.stream().map(n -> {
			return n * n;
		}).reduce((previous, sum) -> {
			return previous + sum;
		}).orElse(0);
	}
}