package br.com.andre.exercicio2;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class HappyNumberVerifier {
	private @Getter int number;

	public HappyNumberVerifier(int n) {
		number = n;
	}

	public List<Integer> digitsOf(int n) {
		var digits = new ArrayList<Integer>();
		while (n >= 1) {
			digits.add(n % 10);
			n /= 10;
		}
		return digits;
	}

	public int sumSquaresOf(ArrayList<Integer> list) {
		return list.stream().map(n -> {
			return n * n;
		}).reduce((previous, sum) -> {
			return previous + sum;
		}).orElse(0);
	}
}