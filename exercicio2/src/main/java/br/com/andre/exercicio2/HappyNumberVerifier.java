package br.com.andre.exercicio2;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class HappyNumberVerifier {
	private @Getter int number;
	private @Getter List<Integer> digits;
	private @Getter List<Step> steps;
	private @Getter boolean repeated;

	public HappyNumberVerifier(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException("Happy numbers must be positive integers");

		number = n;
		digits = new ArrayList<Integer>();
		steps = new ArrayList<Step>();
		repeated = false;
	}

	public boolean verify() {
		if (number == 1) {
			return true;
		} else if(repeated) {
			return false;
		} else {
			step();
			return verify();
		}
	}

	// não deixei os métodos abaixo privados somente para mostrar que usei TDD
	// assim, não precisei excluir as etapas do tdd nos testes

	public void step() {
		extractDigits();
		sumSquares();
		repeated |= currentStepIsRepeated();
		steps.add(new Step(digits, number));
	}

	public boolean currentStepIsRepeated() {
		return steps.stream().filter(step -> step.getResult() == number).count() >= 1;
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