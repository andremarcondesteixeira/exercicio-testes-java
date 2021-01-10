package br.com.andre.exercicio2;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class HappyNumberVerifier {
	private @Getter int number;
	private @Getter List<Integer> digits;
	private @Getter List<Integer> previousResults;

	public HappyNumberVerifier(int n) {
		number = n;
		digits = new ArrayList<Integer>();
		previousResults = new ArrayList<Integer>();
	}

	public boolean verify() {
		if (number == 1)
			return true;
		else {
			step();
			return verify();
		}
	}

	public void step() {
		extractDigits();
		sumSquares();
		previousResults.add(number);
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