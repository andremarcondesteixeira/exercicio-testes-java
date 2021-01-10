package br.com.andre.exercicio2;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class HappyNumberVerifier {
	private @Getter int number;
	private @Getter List<Integer> digits;

	public HappyNumberVerifier(int n) {
		number = n;
		digits = new ArrayList<Integer>();
	}

	public void extractDigits() {
		digits.clear();
		while (number >= 1) {
			digits.add(number % 10);
			number /= 10;
		}
	}

	public void sumSquares() {
		number = digits.stream().map(n -> {
			return n * n;
		}).reduce((previous, sum) -> {
			return previous + sum;
		}).orElse(0);
	}
}